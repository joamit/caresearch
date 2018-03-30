package io.joamit.caresearch.api.commons.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Manufacturer {

    @Id
    private String id;
    private String name;
    private Country country;
    private DateTime startYear;
    private DateTime endYear;
    private Boolean stillInBusiness;
    @CreatedBy
    private User user;
    @CreatedDate
    private DateTime createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public DateTime getStartYear() {
        return startYear;
    }

    public void setStartYear(DateTime startYear) {
        this.startYear = startYear;
    }

    public DateTime getEndYear() {
        return endYear;
    }

    public void setEndYear(DateTime endYear) {
        this.endYear = endYear;
    }

    public Boolean getStillInBusiness() {
        return stillInBusiness;
    }

    public void setStillInBusiness(Boolean stillInBusiness) {
        this.stillInBusiness = stillInBusiness;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }
}
