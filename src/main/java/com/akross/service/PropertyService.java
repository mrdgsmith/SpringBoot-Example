package com.akross.service;

import com.akross.domain.Department;
import com.akross.domain.container.Property;

public interface PropertyService {
    Property getFeaturedProperties(final Department department, final Integer propertyAmount);
}
