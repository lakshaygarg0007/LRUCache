package com.lakshay.cache;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private static int cacheSize;
    private static Deque<Pair<Integer, Integer>> cache;

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Cache Size");
        cacheSize = Integer.parseInt(scanner.nextLine());
        cache = new LinkedList<>();
        while (true) {
            System.out.println("Please Select Operation");
            System.out.println("1. Add Value in Cache");
            System.out.println("2. Get Key Value in Cache");
            System.out.println("3. Print Cache");
            System.out.println("0. Exit");
            int operation = scanner.nextInt();
            if(operation == 1) {
                System.out.println("Please Enter key and Value");
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                addKey(key, value);
            } else if(operation == 2) {
                System.out.println("Please Enter key to check Value");
                int key = scanner.nextInt();
                getKey(key);
            } else if(operation == 3) {
                System.out.println("Printing Cache");
                printCache();
            } else {
                System.out.println("Bye !!!");
                return;
            }

        }
    }

    public static void printCache() {
        cache.forEach(pair -> {
            System.out.println(pair.getKey() + " " + pair.getValue());
        });
    }


    public static void getKey(int key) {
        Iterator<Pair<Integer, Integer>> iterator = cache.iterator();
        while(iterator.hasNext()) {
            Pair<Integer, Integer> values = iterator.next();
            if(values.getKey() == key) {
                int val = values.getValue();
                iterator.remove();
                cache.addFirst(new Pair<>(key, val));
                System.out.println("Key " + key + "Value ");
                return;
            }
        }
        System.out.println("Key Does Not Exists");
    }


    public static void addKey(int key, int value) {
        boolean keyExists = false;
        for (Pair<Integer, Integer> pair : cache) {
                if (pair.getKey() == key) {
                    cache.remove(pair);
                    cache.addFirst(new Pair<>(key, value));
                    keyExists = true;
                    break;
                }
            }

        if (keyExists) {
            return; // Return from the addKey method
        }
        if (cacheSize == cache.size()) {
            cache.removeLast();
            cache.addFirst(new Pair<>(key, value));
        } else {
            cache.addFirst(new Pair<>(key, value));
        }
    }



}
