package com.company.entity;


public class Simulation {
    int rowCount;
    int columnCount;
    int droneCount;
    int turnCount;
    int maxPayload;
    int productTypeCount;
    int warehouseCount;
    int orderCount;


    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getDroneCount() {
        return droneCount;
    }

    public void setDroneCount(int droneCount) {
        this.droneCount = droneCount;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
    }

    public int getProductTypeCount() {
        return productTypeCount;
    }

    public void setProductTypeCount(int productTypeCount) {
        this.productTypeCount = productTypeCount;
    }

    public int getWarehouseCount() {
        return warehouseCount;
    }

    public void setWarehouseCount(int warehouseCount) {
        this.warehouseCount = warehouseCount;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "Simulation{" +
                "rowCount=" + rowCount +
                ", columnCount=" + columnCount +
                ", droneCount=" + droneCount +
                ", turnCount=" + turnCount +
                ", maxPayload=" + maxPayload +
                ", productTypeCount=" + productTypeCount +
                ", warehouseCount=" + warehouseCount +
                ", orderCount=" + orderCount +
                '}';
    }
}
