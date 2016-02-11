package com.company;

import com.company.entity.Coordinates;
import com.company.entity.Order;
import com.company.entity.Simulation;
import com.company.entity.Warehouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String PATH = "D:\\hashcode\\src\\resources\\mother_of_all_warehouses.in";

    public static void main(String[] args) {
        File file = new File(PATH);
        FileReader fr = null;
        Scanner scanner = null;
        try {
            fr = new FileReader(file);
            scanner = new Scanner(fr);
            Simulation simulation = new Simulation();
            putGeneralInfo(scanner, simulation);
            int[] productWeights = putProductInfo(scanner, simulation);
            for(int i : productWeights) {
                System.out.println(i);
            }
            System.out.println(simulation);
            Warehouse[] warehouseList = putWarehouseInfo(scanner, simulation);
            for(Warehouse warehouse : warehouseList) {
                System.out.println(warehouse);
            }
            System.out.println(simulation);
            Order[] orderList = putOrderInfo(scanner, simulation);

            for(Order order : orderList) {
                System.out.println(order);
            }






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(scanner != null) {
                scanner.close();
            }
        }
    }

    public static void putGeneralInfo(Scanner scanner, Simulation simulation) {
        simulation.setRowCount(scanner.nextInt());
        simulation.setColumnCount(scanner.nextInt());
        simulation.setDroneCount(scanner.nextInt());
        simulation.setTurnCount(scanner.nextInt());
        simulation.setMaxPayload(scanner.nextInt());
        simulation.setProductTypeCount(scanner.nextInt());
    }

    public static int[] putProductInfo(Scanner scanner, Simulation simulation) {
        int[] productWeights = new int[simulation.getProductTypeCount()];
        for (int i = 0; i < productWeights.length; i++) {
            productWeights[i] = scanner.nextInt();
        }
        return productWeights;
    }

    public static Warehouse[] putWarehouseInfo(Scanner scanner, Simulation simulation) {
        simulation.setWarehouseCount(scanner.nextInt());
        Warehouse[] warehouses = new Warehouse[simulation.getWarehouseCount()];

        for (int i = 0; i < warehouses.length; i++) {
            Warehouse warehouse = new Warehouse();
            warehouse.setId(i);
            Coordinates coordinates = new Coordinates();
            coordinates.setX(scanner.nextInt());
            coordinates.setY(scanner.nextInt());
            int[] products = new int[simulation.getProductTypeCount()];
            for (int j = 0; j < products.length; j++) {
                products[j] = scanner.nextInt();
            }
            warehouse.setCoordinates(coordinates);
            warehouse.setProductCount(products);
            warehouses[i] = warehouse;
        }
        return warehouses;
    }

    public static Order[] putOrderInfo(Scanner scanner, Simulation simulation) {
        int orderCount = scanner.nextInt();
        simulation.setOrderCount(orderCount);
        System.out.println(orderCount);
        Order[] orders = new Order[orderCount];
        for (int i = 0; i < orders.length; i++) {
            Order order = new Order();
            order.setId(i);
            Coordinates coordinates = new Coordinates();
            coordinates.setX(scanner.nextInt());
            coordinates.setY(scanner.nextInt());
            order.setProductCount(scanner.nextInt());
            order.setCoordinates(coordinates);

            int[] products = new int[simulation.getProductTypeCount()];
            for (int j = 0; j < order.getProductCount(); j++) {
                int a = scanner.nextInt();
                products[a]++;
            }
            order.setProductList(products);
            orders[i] = order;
        }
        return orders;
    }
    }
