package com.akross.web.health;

import com.akross.health.property.PropertiesEndpointHealthIndicator;
import com.akross.service.property.schedule.SchedulePropertyLoader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HealthControllerTest {

    @Rule
    public ExpectedException expectedException = none();

    @LocalServerPort
    private int port;

    @MockBean
    private PropertiesEndpointHealthIndicator PropertiesEndpointHealthIndicator;

    @MockBean
    private SchedulePropertyLoader schedulePropertyLoader;

    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        when(PropertiesEndpointHealthIndicator.health()).thenReturn(Health.up().build());
        restTemplate = new RestTemplateBuilder().build();
    }

    @Test
    public void shouldSayServerIsUp() {
        final ResponseEntity<String> actualResponseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/health", String.class);
        then(actualResponseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(actualResponseEntity.getBody(), hasJsonPath("Health.status", is("UP")));
    }

}