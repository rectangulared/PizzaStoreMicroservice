package com.rectangulared.pizzabuilder.entity;

public enum PizzasForm {
    SMALL_CIRCLE(0.75),
    CIRCLE(0.75),
    BIG_CIRCLE(0.75),
    SMALL_SQUARE(0.75),
    SQUARE(0.75),
    BIG_SQUARE(0.75);

    private final double priceFactor;

    private PizzasForm(double priceFactor) {
        this.priceFactor = priceFactor;
    }

    public double getPriceFactor() {
        return priceFactor;
    }
}
