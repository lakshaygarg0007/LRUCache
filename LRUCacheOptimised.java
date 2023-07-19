package com.lakshay.cache;

import javafx.util.Pair;

import java.util.*;

public class Main {
    private static int cacheSize;
    private static Map<Integer, Integer> cache;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Cache Size");
        cacheSize = Integer.parseInt(scanner.nextLine());
        cache = new LinkedHashMap<>(cacheSize, 0.75f, true);

        while (true) {
            System.out.println("Please Select Operation");
            System.out.println("1. Add Value in Cache");
            System.out.println("2. Get Key Value in Cache");
            System.out.println("3. Print Cache");
            System.out.println("0. Exit");
            int operation = scanner.nextInt();

            if (operation == 1) {
                System.out.println("Please Enter key and Value");
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                addKey(key, value);
            } else if (operation == 2) {
                System.out.println("Please Enter key to check Value");
                int key = scanner.nextInt();
                getKey(key);
            } else if (operation == 3) {
                System.out.println("Printing Cache");
                printCache();
            } else {
                System.out.println("Bye !!!");
                return;
            }
        }
    }

    public static void printCache() {
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void getKey(int key) {
        Integer value = cache.get(key);
        if (value != null) {
            System.out.println("Key " + key + " Value " + value);
        } else {
            System.out.println("Key Does Not Exist");
        }
    }

    public static void addKey(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() >= cacheSize) {
            Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        cache.put(key, value);
    }
}
