package org.example.juc.waitnotify.producerconsumerproblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Package org.example.juc.waitnotify.producerconsumerproblem
 * @ClassName ProducerConsumerProblem
 * @Description 使用wait/notify实现生产者消费者模式
 * @Author perl
 * @Date 2020/9/18 10:53 AM
 * @Version 1.0
 */
public class ProducerConsumerProblem {

    public static void main(String[] args) {
        Stock stock = new Stock();

        Thread producerThread = new Thread(new Producer(stock));
        Thread consumerThread = new Thread(new Consumer(stock));
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    private Stock stock;

    public Producer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stock.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable {
    private Stock stock;

    public Consumer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stock.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Stock {
    private LinkedList<Integer> stock = new LinkedList<>();
    private int maxSize = 10;
    private Random random = new Random();

    public synchronized void put() throws InterruptedException {
        while (stock.size() == maxSize) {
            wait();
        }
        stock.push(random.nextInt(100));
        System.out.println("成功生产一个商品，目前一共有" + stock.size() + "件商品");
        notify();
    }

    public synchronized void take() throws InterruptedException {
        while (stock.size() == 0) {
            wait();
        }
        stock.poll();
        System.out.println("成功消费一个商品，剩余" + stock.size() + "件商品");
        notify();
    }
}
