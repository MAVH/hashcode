package com.company.entity;

import java.util.Arrays;

public class Warehouse {
    int id;
    Coordinates coordinates;
    int[] productCount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getProductCount() {
        return productCount;
    }

    public void setProductCount(int[] productCount) {
        this.productCount = productCount;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", coordinates=" + coordinates +
                ", productCount=" + Arrays.toString(productCount) +
                '}';
    }
}
