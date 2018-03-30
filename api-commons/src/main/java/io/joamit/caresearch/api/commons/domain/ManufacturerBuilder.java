package io.joamit.caresearch.api.commons.domain;

import org.joda.time.DateTime;

public final class ManufacturerBuilder {
    private String id;
    private String name;
    private Country country;
    private DateTime startYear;
    private DateTime endYear;
    private Boolean stillInBusiness;
    private User user;
    private DateTime createdDate;

    private ManufacturerBuilder() {
    }

    public static ManufacturerBuilder aManufacturer() {
        return new ManufacturerBuilder();
    }

    public ManufacturerBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ManufacturerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ManufacturerBuilder withCountry(Country country) {
        this.country = country;
        return this;
    }

    public ManufacturerBuilder withStartYear(DateTime startYear) {
        this.startYear = startYear;
        return this;
    }

    public ManufacturerBuilder withEndYear(DateTime endYear) {
        this.endYear = endYear;
        return this;
    }

    public ManufacturerBuilder withStillInBusiness(Boolean stillInBusiness) {
        this.stillInBusiness = stillInBusiness;
        return this;
    }

    public ManufacturerBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public ManufacturerBuilder withCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Manufacturer build() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        manufacturer.setStartYear(startYear);
        manufacturer.setEndYear(endYear);
        manufacturer.setStillInBusiness(stillInBusiness);
        manufacturer.setUser(user);
        manufacturer.setCreatedDate(createdDate);
        return manufacturer;
    }
}
