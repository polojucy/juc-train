package org.example.juc.synchronize;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Package org.example.juc.synchronize
 * @ClassName SynchronizedTestV3
 * @Description 对象锁试例：使用synchronized(obj)代码块来进行同步控制
 * @Author perl
 * @Date 2020/9/15 10:31 AM
 * @Version 1.0
 */
public class SynchronizedTestV3 {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Runnable runnable = () -> {
            synchronized (obj1) {
                try {
                    System.out.println("=========线程"+ Thread.currentThread().getName() +"：获得obj1锁=========");
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (obj2) {
                try {
                    System.out.println("=========线程"+ Thread.currentThread().getName() +"：获得obj2锁=========");
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

}
