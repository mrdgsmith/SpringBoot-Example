package com.akross.gateway;

import com.akross.repository.property.entity.Property;

import java.util.List;

public interface PropertyClient {
    List<? extends Property> getProperties();
}