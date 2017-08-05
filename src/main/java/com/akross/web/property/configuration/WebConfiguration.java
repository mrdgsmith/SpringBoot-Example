package com.akross.web.property.configuration;

import com.akross.domain.property.Department;
import com.akross.domain.property.residentialsalesandletting.FloorAreaUnit;
import com.akross.domain.property.residentialsalesandletting.PropertyAge;
import com.akross.domain.property.residentialsalesandletting.PropertyStyle;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.Availability;
import com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE;
import static java.time.format.DateTimeFormatter.*;

@SpringBootConfiguration
public class WebConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .enable(WRAP_ROOT_VALUE)
                .setSerializationInclusion(NON_EMPTY)
                .setSerializationInclusion(NON_NULL)
                .setSerializationInclusion(NON_DEFAULT)
                .disable(FAIL_ON_EMPTY_BEANS)
                .registerModules(new JavaTimeModule()
                        .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(ISO_DATE_TIME))
                        .addSerializer(LocalDate.class, new LocalDateSerializer(ISO_DATE))
                        .addSerializer(LocalTime.class, new LocalTimeSerializer(ISO_TIME))
                        .addSerializer(Availability.class, new AvailabilitySerializer())
                        .addSerializer(RentFrequency.class, new RentFrequencySerializer())
                        .addSerializer(PropertyAge.class, new PropertyAgeSerializer())
                        .addSerializer(FloorAreaUnit.class, new FloorAreaUnitSerializer())
                        .addSerializer(PropertyType.class, new PropertyTypeSerializer())
                        .addSerializer(PropertyStyle.class, new PropertyStyleSerializer())
                        .addSerializer(Department.class, new DepartmentSerializer())
                );
    }

    private static class AvailabilitySerializer extends StdSerializer<Availability> {

        private AvailabilitySerializer() {
            super(Availability.class);
        }

        public void serialize(final Availability availability, final JsonGenerator generator
                , final SerializerProvider provider) throws IOException {
            generator.writeString(availability.getDescription());
        }
    }

    private static class RentFrequencySerializer extends StdSerializer<RentFrequency> {

        private RentFrequencySerializer() {
            super(RentFrequency.class);
        }

        public void serialize(final RentFrequency rentFrequency, final JsonGenerator generator
                , final SerializerProvider provider) throws IOException {
            generator.writeString(rentFrequency.getDescription());
        }
    }

    private static class PropertyAgeSerializer extends StdSerializer<PropertyAge> {

        private PropertyAgeSerializer() {
            super(PropertyAge.class);
        }

        public void serialize(final PropertyAge propertyAge, final JsonGenerator generator
                , final SerializerProvider provider) throws IOException {
            generator.writeString(propertyAge.getDescription());
        }
    }

    private static class FloorAreaUnitSerializer extends StdSerializer<FloorAreaUnit> {

        private FloorAreaUnitSerializer() {
            super(FloorAreaUnit.class);
        }

        public void serialize(final FloorAreaUnit floorAreaUnit, final JsonGenerator generator
                , final SerializerProvider provider) throws IOException {
            generator.writeString(floorAreaUnit.getFloorAreaUnit());
        }
    }

    private static class PropertyTypeSerializer extends StdSerializer<PropertyType> {

        private PropertyTypeSerializer() {
            super(PropertyType.class);
        }

        public void serialize(final PropertyType propertyType, final JsonGenerator generator
                , final SerializerProvider provider) throws IOException {
            generator.writeString(propertyType.getType());
        }
    }

    private static class PropertyStyleSerializer extends StdSerializer<PropertyStyle> {

        private PropertyStyleSerializer() {
            super(PropertyStyle.class);
        }

        public void serialize(final PropertyStyle propertyStyle, final JsonGenerator generator
                , final SerializerProvider provider) throws IOException {
            generator.writeString(propertyStyle.getStyleName());
        }
    }

    private static class DepartmentSerializer extends StdSerializer<Department> {

        private DepartmentSerializer() {
            super(Department.class);
        }

        public void serialize(final Department department, final JsonGenerator generator
                , final SerializerProvider provider) throws IOException {
            generator.writeString(department.getDescription());
        }
    }
}