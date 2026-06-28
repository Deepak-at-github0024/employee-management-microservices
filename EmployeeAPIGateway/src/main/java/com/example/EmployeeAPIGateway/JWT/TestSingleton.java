package com.example.EmployeeAPIGateway.JWT;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestSingleton {

    public static void main(String arg[]) throws InterruptedException {
        Set<IIMSCalender> instances = ConcurrentHashMap.newKeySet();

        Runnable task = () -> {
            IIMSCalender instance = IIMSCalender.getInstance();
            instances.add(instance);
            System.out.println(Thread.currentThread().getName() + " -> " + instance.hashCode());
        };

        // Create multiple threads
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");
        Thread t4 = new Thread(task, "Thread-4");

        // Start them together
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all to finish
        t1.join();
        t2.join();
        t3.join();
        t4.join();


        // Check how many unique instances were created
        System.out.println("Unique instances count: " + instances.size());

    }
}
