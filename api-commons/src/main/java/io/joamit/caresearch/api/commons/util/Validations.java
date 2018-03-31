package io.joamit.caresearch.api.commons.util;

import io.joamit.caresearch.api.commons.domain.Car;
import io.joamit.caresearch.api.commons.domain.Engine;
import io.joamit.caresearch.api.commons.domain.Manufacturer;

public final class Validations {

    public static void validateCar(Car car) {
        if (car == null) throw new IllegalStateException("Car can not be null!!");
        if (car.getEngine() == null) throw new IllegalStateException("Car must have an engine!!");
        if (car.getManufacturer() == null) throw new IllegalStateException("Car must have a manufacturer!!");
        if (car.getName() == null) throw new IllegalStateException("Car is missing its name!!");
    }

    public static void validateEngine(Engine engine) {
        if (engine == null) throw new IllegalStateException("Engine can not be null!!");
        if (engine.getManufacturer() == null) throw new IllegalStateException("Engine must have a manufacturer!!");
        if (engine.getName() == null) throw new IllegalStateException("Engine is missing its name!!");
    }

    public static void validateManufacturer(Manufacturer manufacturer) {
        if (manufacturer == null) throw new IllegalStateException("Manufacturer can not be null!!");
        if (manufacturer.getName() == null) throw new IllegalStateException("Manufacturer is missing its name!!");
    }
}
