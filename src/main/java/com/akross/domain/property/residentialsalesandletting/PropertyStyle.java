package com.akross.domain.property.residentialsalesandletting;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

public enum PropertyStyle {
    BARN_CONVERSION(1, 1, "Barn Conversion"), COTTAGE(2, 1, "Cottage"), CHALET(3, 1, "Chalet"), DETACHED_HOUSE(4, 1, "Detached House"), SEMI_DETACHED_HOUSE(5, 1, "Semi-Detached House"), FARM_HOUSE(6, 1, "Farm House"), MANOR_HOUSE(7, 1, "Farm House"), MEWS(8, 1, "Mews"), MID_TERRACED_HOUSE(9, 1, "Mid Terraced House"), END_TERRACED_HOUSE(10, 1, "End Terraced House"), TOWN_HOUSE(11, 1, "Town House"), VILLA(12, 1, "Villa"), LINK_DETACHED(28, 1, "Link Detached"), SHARED_HOUSE(29, 1, "Shared House"), SHELTERED_HOUSING(31, 1, "Sheltered Housing"), APARTMENT(13, 2, "Apartment"), BEDSIT(14, 2, "Bedsit"), GROUND_FLOOR_FLAT(15, 2, "Ground Floor Flat"), FLAT(16, 2, "Flat"), GROUND_FLOOR_MAISONETTE(17, 2, "Ground Floor Maisonette"), MAISONETTE(18, 2, "Maisonette"), PENTHOUSE(19, 2, "Penthouse"), STUDIO(20, 2, "Studio"), SHARED_FLAT(30, 2, "Shared Flat"), DETACHED_BUNGALOW(21, 3, "Detached Bungalow"), SEMI_DETACHED_BUNGALOW(22, 3, "Semi-Detached Bungalow"), MID_TERRACED_BUNGALOW(34, 3, "Mid Terraced Bungalow"), END_TERRACED_BUNGALOW(35, 3, "End Terraced Bungalow"), BUILDING_PLOT_LAND(23, 4, "Building Plot / Land"), GARAGE(24, 4, "Garage"), HOUSE_BOAT(25, 4, "House Boat"), MOBILE_HOME(26, 4, "Mobile Home"), PARKING(27, 4, "Parking"), EQUESTRIAN(32, 4, "Equestrian"), UNCONVERTED_BARN(33, 4, "Unconverted Barn");

    private static final Map<Integer, PropertyStyle> map = of(PropertyStyle.values())
            .collect(toMap(propertyStyle -> propertyStyle.styleId, propertyStyle -> propertyStyle));

    private final Integer styleId;
    private final Integer typeId;
    private final String styleName;

    PropertyStyle(final Integer styleId, final Integer typeId, final String styleName) {
        this.styleId = styleId;
        this.typeId = typeId;
        this.styleName = styleName;
    }

    public static Map<Integer, PropertyStyle> getMap() {
        return unmodifiableMap(map);
    }

    public Integer getStyleId() {
        return styleId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getStyleName() {
        return styleName;
    }

    @Override
    public String toString() {
        return "PropertyStyle{" +
                "styleId=" + styleId +
                ", typeId=" + typeId +
                ", styleName='" + styleName + '\'' +
                '}';
    }
}
