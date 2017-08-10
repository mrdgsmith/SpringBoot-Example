package com.akross.gateway.enquiry.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "data")
public class RentalEvaluationEnquiryResponse {

    @XmlElement(name = "success")
    private final Integer success;
    @XmlElement(name = "response")
    private final String response;

    private RentalEvaluationEnquiryResponse() {
        this(null, null);
    }

    public RentalEvaluationEnquiryResponse(final Integer success, final String response) {
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
