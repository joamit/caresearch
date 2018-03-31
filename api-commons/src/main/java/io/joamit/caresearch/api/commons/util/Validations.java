package io.joamit.caresearch.api.commons.util;

import io.joamit.caresearch.api.commons.domain.Car;

public final class Validations {

    public static void validateCar(Car car) {
        if (car == null) throw new IllegalStateException("Car can not be null!!");
        if (car.getEngine() == null) throw new IllegalStateException("Car must have an engine!!");
        if (car.getManufacturer() == null) throw new IllegalStateException("Car must have a manufacturer!!");
        if (car.getName() == null) throw new IllegalStateException("Car is missing its name!!");
    }
}
