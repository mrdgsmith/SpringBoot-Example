package com.akross.gateway.enquiry.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Objects;

@JacksonXmlRootElement(localName = "data")
public class RentalEvaluationEnquiryResponse {

    private final Integer success;
    private final String response;

    public RentalEvaluationEnquiryResponse(@JacksonXmlProperty(localName = "success") final Integer success
            , @JacksonXmlProperty(localName = "response") final String response) {
        this.success = success;
        this.response = response;
    }

    public Integer getSuccess() {
        return success;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalEvaluationEnquiryResponse)) return false;
        RentalEvaluationEnquiryResponse that = (RentalEvaluationEnquiryResponse) o;
        return Objects.equals(success, that.success) &&
                Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, response);
    }

    @Override
    public String toString() {
        return "RentalEvaluationEnquiryResponse{" +
                "success=" + success +
                ", response='" + response + '\'' +
                '}';
    }
}
