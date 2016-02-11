package com.company.entity;


import java.util.Arrays;
import java.util.Map;

public class Order {
    private int id;
    private int productCount;
    private Coordinates coordinates;
    private int[] productList;
    private Map<Integer, Integer> use;
    private Status status;


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

    public Map<Integer, Integer> getUse() {
        return use;
    }

    public void setUse(Map<Integer, Integer> use) {
        this.use = use;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
