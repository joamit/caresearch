package io.joamit.caresearch.api.commons.domain;

import java.util.Date;

public final class EngineBuilder {
    private String id;
    private Integer horsePower;
    private Integer valves;
    private Integer piston;
    private String name;
    private String description;
    private Manufacturer manufacturer;
    private User user;
    private Date createdDate;

    private EngineBuilder() {
    }

    public static EngineBuilder anEngine() {
        return new EngineBuilder();
    }

    public EngineBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public EngineBuilder withHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public EngineBuilder withValves(Integer valves) {
        this.valves = valves;
        return this;
    }

    public EngineBuilder withPiston(Integer piston) {
        this.piston = piston;
        return this;
    }

    public EngineBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EngineBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineBuilder withManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public EngineBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public EngineBuilder withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Engine build() {
        Engine engine = new Engine();
        engine.setId(id);
        engine.setHorsePower(horsePower);
        engine.setValves(valves);
        engine.setPiston(piston);
        engine.setName(name);
        engine.setDescription(description);
        engine.setManufacturer(manufacturer);
        engine.setUser(user);
        engine.setCreatedDate(createdDate);
        return engine;
    }
}
