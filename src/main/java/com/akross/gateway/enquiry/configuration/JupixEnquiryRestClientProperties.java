package com.akross.gateway.enquiry.configuration;

import com.akross.gateway.JupixBaseProperties;
import org.springframework.beans.factory.annotation.Value;

public class JupixEnquiryRestClientProperties extends JupixBaseProperties {

    private static final String PREFIX = "${jupix.restService.enquiry";
    private static final String URL_PREFIX = "${jupix.restService";

    private final String path;
    private final String apiKey;
    private final String agentCode;
    private final Integer branchCode;
    private final Double version;
    private final String enquirerEmail;

    public JupixEnquiryRestClientProperties(@Value(URL_PREFIX + ".rootUrl}") final String rootUrl
            , @Value(PREFIX + ".path}") final String path
            , @Value(PREFIX + ".apiKey}") final String apiKey
            , @Value(PREFIX + ".agentCode}") final String agentCode
            , @Value(PREFIX + ".branchCode}") final Integer branchCode
            , @Value(PREFIX + ".version}") final Double version
            , @Value(PREFIX + ".enquirerEmail}") final String enquirerEmail) {
        super(rootUrl);
        this.path = path;
        this.apiKey = apiKey;
        this.agentCode = agentCode;
        this.branchCode = branchCode;
        this.version = version;
        this.enquirerEmail = enquirerEmail;
    }

    public String getPath() {
        return path;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public Double getVersion() {
        return version;
    }

    public String getEnquirerEmail() {
        return enquirerEmail;
    }
}