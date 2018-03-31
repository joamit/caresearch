package io.joamit.caresearch.api.commons.domain;


import java.util.Date;

public final class CarBuilder {
    private String id;
    private String name;
    private String description;
    private Date launched;
    private Boolean stillProduced;
    private Date discontinued;
    private Manufacturer manufacturer;
    private Engine engine;
    private User user;
    private Date createdDate;

    private CarBuilder() {
    }

    public static CarBuilder aCar() {
        return new CarBuilder();
    }

    public CarBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public CarBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CarBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CarBuilder withLaunched(Date launched) {
        this.launched = launched;
        return this;
    }

    public CarBuilder withStillProduced(Boolean stillProduced) {
        this.stillProduced = stillProduced;
        return this;
    }

    public CarBuilder withDiscontinued(Date discontinued) {
        this.discontinued = discontinued;
        return this;
    }

    public CarBuilder withManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public CarBuilder withEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public CarBuilder withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Car build() {
        Car car = new Car();
        car.setId(id);
        car.setName(name);
        car.setDescription(description);
        car.setLaunched(launched);
        car.setStillProduced(stillProduced);
        car.setDiscontinued(discontinued);
        car.setManufacturer(manufacturer);
        car.setEngine(engine);
        car.setUser(user);
        car.setCreatedDate(createdDate);
        return car;
    }
}
