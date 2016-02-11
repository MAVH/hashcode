package com.company;

import com.company.entity.Coordinates;
import com.company.entity.Order;
import com.company.entity.Simulation;
import com.company.entity.Warehouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static String PATH = "mother_of_all_warehouses.in";
    public static String OUTPUT_FILE = "output.txt";

    private static Order[] orderList;
    private static int[] productWeights;
    private static Simulation simulation;
    private static Warehouse[] warehouseList;

    public static void main(String[] args) {
        File file = new File(PATH);
        FileReader fr = null;
        Scanner scanner = null;
        try {
            fr = new FileReader(file);
            scanner = new Scanner(fr);
            simulation = new Simulation();
            putGeneralInfo(scanner, simulation);
            productWeights = putProductInfo(scanner, simulation);
            for(int i : productWeights) {
                System.out.println(i);
            }
            System.out.println(simulation);
            warehouseList = putWarehouseInfo(scanner, simulation);
            for(Warehouse warehouse : warehouseList) {
                System.out.println(warehouse);
            }
            System.out.println(simulation);
            orderList = putOrderInfo(scanner, simulation);

            for(Order order : orderList) {
                System.out.println(order);
            }

            for(Warehouse warehouse: warehouseList) {
                warehouse.setUse(countUsefulness(warehouse.getCoordinates()));
            }

            for(Order order: orderList){
                order.setUse(countUsefulness(order.getCoordinates()));
            }

            if(warehouseList.length != 1){
                return;
            }

            Warehouse warehouse = warehouseList[0];

            Map<Integer, Integer> map = warehouse.getUse();
            List list = new ArrayList(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                    return a.getValue() - b.getValue();
                }
            });

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

    private static Map<Integer, Integer> countUsefulness(Coordinates coords) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Order order: orderList) {
            int use = countDistance(coords, order.getCoordinates())*order.weight(productWeights, simulation);
            map.put(order.getId(), use);

        }

        return map;
    }

    private static int countDistance(Coordinates a, Coordinates b) {
        return (int)Math.ceil(Math.sqrt(Math.pow(a.getX() - b.getX(),2) + Math.pow(a.getY()-b.getY(), 2)));
    }
}
