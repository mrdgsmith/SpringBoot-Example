package com.akross.gateway.property;

import com.akross.gateway.property.configuration.JupixPropertiesRestClientProperties;
import com.akross.gateway.property.entity.Properties;
import com.akross.gateway.property.exception.PropertiesGatewayException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.akross.gateway.property.enitity.builders.entity.TestPropertiesBuilder.aProperties;
import static com.akross.gateway.property.enitity.builders.entity.TestPropertyBuilder.aProperty;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class HttpPropertyClientUnitTest {

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private RestTemplate jupixPropertiesRestClient;

    @Mock
    private JupixPropertiesRestClientProperties jupixPropertiesRestClientProperties;

    @InjectMocks
    private HttpPropertyClient httpPropertyClient;

    private static ResponseEntity<Properties>
    createResponseEntityPropertiesResponse(final HttpStatus httpStatus, final Properties properties) {
        return ResponseEntity
                .status(httpStatus)
                .body(properties);
    }

    @Test
    public void shouldGetProperties() {
        final String path = "path";
        final String clientId = "clientId";
        final String passphrase = "passphrase";
        final double version = 5.0;

        setupJupixPropertiesRestClientProperties(path, clientId, passphrase, version);

        final Properties properties = aProperties()
                .withProperties(singletonList(aProperty()
                        .withPropertyId(555L)
                        .build()))
                .build();

        final ArgumentCaptor<String> uriRequestArgumentCaptor = forClass(String.class);
        setupJupixPropertiesRestClient(properties, OK, uriRequestArgumentCaptor);

        final Properties actualProperties = httpPropertyClient.getProperties();
        assertThat(actualProperties, is(properties));
        assertWhatShouldHappen(uriRequestArgumentCaptor.getValue(), Properties.class, path, clientId, passphrase, version);
    }

    @Test
    public void shouldThrowPropertiesGatewayExceptionWhenUnsuccessful() {
        final String path = "path";
        final String clientId = "clientId";
        final String passphrase = "passphrase";
        final double version = 5.0;

        final ArgumentCaptor<String> uriRequestArgumentCaptor = forClass(String.class);

        setupJupixPropertiesRestClientProperties(path, clientId, passphrase, version);
        setupJupixPropertiesRestClient(null, INTERNAL_SERVER_ERROR, uriRequestArgumentCaptor);

        try {
            httpPropertyClient.getProperties();
            fail("My method didn't throw when I expected it to");
        } catch (final PropertiesGatewayException propertiesGatewayException) {
            final String uriRequest = uriRequestArgumentCaptor.getValue();
            assertThat(propertiesGatewayException.getMessage()
                    , is("Failed to get properties with this get request " + uriRequest));
            assertWhatShouldHappen(uriRequest, Properties.class, path, clientId, passphrase, version);
        }
    }

    private void setupJupixPropertiesRestClient(final Properties properties, final HttpStatus httpStatus
            , final ArgumentCaptor<String> uriRequestArgumentCaptor) {
        when(jupixPropertiesRestClient.getForEntity(uriRequestArgumentCaptor.capture(), eq(Properties.class)))
                .thenReturn(createResponseEntityPropertiesResponse(httpStatus, properties));
    }

    private void assertWhatShouldHappen(final String uriRequest, final Class<Properties> clazz
            , final String path, final String clientId, final String passphrase, final double version) {
        assertThat(uriRequest, is(path + "?clientID=" + clientId + "&passphrase="
                + passphrase + "&version=" + version));
        verify(jupixPropertiesRestClient).getForEntity(uriRequest, clazz);
        verifyNoMoreInteractions(jupixPropertiesRestClient);
    }

    private void setupJupixPropertiesRestClientProperties(final String path
            , final String clientId
            , final String passphrase
            , final double version) {
        when(jupixPropertiesRestClientProperties.getPath()).thenReturn(path);
        when(jupixPropertiesRestClientProperties.getClientId()).thenReturn(clientId);
        when(jupixPropertiesRestClientProperties.getPassphrase()).thenReturn(passphrase);
        when(jupixPropertiesRestClientProperties.getVersion()).thenReturn(version);
    }
}