package org.example.juc.interruptthread;

import java.io.BufferedReader;
import java.io.Reader;

/**
 * @Package org.example.juc.interruptthread
 * @ClassName InterruptThreadV2
 * @Description 演示如何正确停止线程(run方法中有阻塞线程操作--sleep)
 * @Author perl
 * @Date 2020/9/16 1:59 PM
 * @Version 1.0
 */
public class InterruptThreadV2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("do something....");
                    Thread.sleep(100L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        thread.start();
        Thread.sleep(3000L);
        thread.interrupt();
    }
}
