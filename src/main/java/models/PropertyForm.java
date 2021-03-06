package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class PropertyForm extends DatabaseModel {
    private static final String tableName = "property_form";
    private Property.Type propertyType;
    private Integer numberOfBedrooms;
    private Integer numberOfBathrooms;
    private Property.CityQuadrant cityQuadrant;

    public PropertyForm(final Property.Type propertyType, final Integer numberOfBedrooms,
                        final Integer numberOfBathrooms, final Property.CityQuadrant cityQuadrant) {
        this.propertyType = propertyType;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.cityQuadrant = cityQuadrant;
    }

    public PropertyForm() { }

    public static Optional<PropertyForm> createFromResultSet(final ResultSet rs) throws SQLException {
        final Property.Type type = Optional.ofNullable(rs.getString("property_type")).map(Property.Type::valueOf).orElse(null);
        final Integer numberOfBedrooms = rs.getObject("number_of_bedrooms", Integer.class);
        final Integer numberOfBathrooms = rs.getObject("number_of_bathrooms", Integer.class);
        final Property.CityQuadrant quadrant = Optional.ofNullable(rs.getString("city_quadrant")).map(Property.CityQuadrant::valueOf).orElse(null);
        return Optional.of(new PropertyForm(type, numberOfBedrooms, numberOfBathrooms, quadrant));
    }

    public Property.Type getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(final Property.Type propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(final Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(final Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Property.CityQuadrant getCityQuadrant() {
        return cityQuadrant;
    }

    public void setCityQuadrant(final Property.CityQuadrant cityQuadrant) {
        this.cityQuadrant = cityQuadrant;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PropertyForm that = (PropertyForm) o;
        return propertyType == that.propertyType &&
                Objects.equals(numberOfBedrooms, that.numberOfBedrooms) &&
                Objects.equals(numberOfBathrooms, that.numberOfBathrooms) &&
                cityQuadrant == that.cityQuadrant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyType, numberOfBedrooms, numberOfBathrooms, cityQuadrant);
    }
}
