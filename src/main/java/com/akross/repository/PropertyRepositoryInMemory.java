package com.akross.repository;

import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.repository.property.entity.Property;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Transactional(readOnly = true)
public interface PropertyRepositoryInMemory<T extends Property> extends JpaRepository<T, Long> {

    String DATE_LAST_MODIFIED = "dateLastModified";
    String TIME_LAST_MODIFIED = "timeLastModified";

    @Query("SELECT property FROM Property property WHERE" +
            " lower(property.address3) = lower(:location)" +
            " AND property.rent >= :minimumPrice" +
            " AND property.rent <= :maximumPrice" +
            " AND property.propertyType IN :propertyType" +
            " AND property.propertyBedrooms = :bedroomAmount" +
            " ORDER BY " + DATE_LAST_MODIFIED + " DESC, " + TIME_LAST_MODIFIED + " ASC")
    List<T> getPropertiesBySearchCriteria(@Param("location") final String location
            , @Param("minimumPrice") final BigDecimal minimumPrice
            , @Param("maximumPrice") final BigDecimal maximumPrice
            , @Param("propertyType") final List<PropertyType> propertyTypes
            , @Param("bedroomAmount") final Integer bedroomAmount
    );

    @Query("SELECT property FROM Property property WHERE" +
            " property.isFeaturedProperty = 'true'" +
            " AND property.department IN ('LETTINGS')" +
            " AND property.availability IN ('LET')" +
            " ORDER BY " + DATE_LAST_MODIFIED + " DESC, " + TIME_LAST_MODIFIED + " ASC")
    List<T> getFeaturedProperties();

    @Override
    default List<T> findAll() {
        return findAll(new Sort(Arrays.asList(
                new Order(DESC, DATE_LAST_MODIFIED)
                , new Order(ASC, TIME_LAST_MODIFIED)
        )));
    }
}