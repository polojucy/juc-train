package org.example.juc.waitnotify;

/**
 * @Package org.example.juc.waitnotify
 * @ClassName WaitNotifyAllTest
 * @Description wait/notifyAll的用法
 * @Author perl
 * @Date 2020/9/17 2:00 PM
 * @Version 1.0
 */
public class WaitNotifyAllTest {

    public static Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            synchronized (resource) {
                System.out.println(Thread.currentThread().getName() + "获得了锁....");
                try {
                    resource.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕....");
            }
        };
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(() -> {
            synchronized (resource) {
//                resource.notify();
                // 使用notifyAll唤醒所有阻塞的线程
                resource.notifyAll();
                System.out.println(Thread.currentThread().getName() + "唤醒其他线程...");
            }
        });

        thread1.start();
        thread2.start();
        // 为了保证线程1/2阻塞后再唤醒，这里稍微sleep一会儿
        Thread.sleep(100L);
        thread3.start();
    }
}
