package com.company.entity;

public class Drone {
    private int id;
    private Coordinates coordinates;
    private int[] products;
    private int returningStep;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getProducts() {
        return products;
    }

    public void setProducts(int[] products) {
        this.products = products;
    }

    public int getReturningStep() {
        return returningStep;
    }

    public void setReturningStep(int returningStep) {
        this.returningStep = returningStep;
    }
}
