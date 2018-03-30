package io.joamit.caresearch.api.commons.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {

    @Id
    private String id;
    private String name;
    private String description;
    private DateTime launched;
    private Boolean stillProduced;
    private DateTime discontinued;
    @DBRef
    private Manufacturer manufacturer;
    @DBRef
    private Engine engine;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getLaunched() {
        return launched;
    }

    public void setLaunched(DateTime launched) {
        this.launched = launched;
    }

    public Boolean getStillProduced() {
        return stillProduced;
    }

    public void setStillProduced(Boolean stillProduced) {
        this.stillProduced = stillProduced;
    }

    public DateTime getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(DateTime discontinued) {
        this.discontinued = discontinued;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
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
