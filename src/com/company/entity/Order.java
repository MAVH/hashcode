package com.company.entity;


import java.util.Arrays;

public class Order {
    int id;
    int productCount;
    Coordinates coordinates;
    int[] productList;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getId() {
        return id;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getProductList() {
        return productList;
    }

    public void setProductList(int[] productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productCount=" + productCount +
                ", coordinates=" + coordinates +
                ", productList=" + Arrays.toString(productList) +
                '}';
    }
}
