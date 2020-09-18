package org.example.juc.waitnotify;

/**
 * @Package org.example.juc.waitnotify
 * @ClassName WaitNotifyMonitor
 * @Description 演示wait只释放当前的锁
 * @Author perl
 * @Date 2020/9/18 9:24 AM
 * @Version 1.0
 */
public class WaitNotifyMonitor {

    public static volatile Object R1 = new Object();
    public static volatile Object R2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试获取R1锁。。。");
            synchronized (R1) {
                System.out.println(Thread.currentThread().getName() + "拿到了R1锁。。。");
                System.out.println(Thread.currentThread().getName() + "尝试获取R2锁。。。");
                synchronized (R2) {
                    System.out.println(Thread.currentThread().getName() + "拿到了R2锁。。。");
                    try {
                        System.out.println(Thread.currentThread().getName() + "释放了R1锁。。。");
                        R1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试获取R1锁。。。");
            synchronized (R1) {
                System.out.println(Thread.currentThread().getName() + "拿到了R1锁。。。");
                System.out.println(Thread.currentThread().getName() + "尝试获取R2锁。。。");
                synchronized (R2) {
                    System.out.println(Thread.currentThread().getName() + "拿到了R2锁。。。");
                }
            }
        });

        t1.start();
        Thread.sleep(100L);
        t2.start();
    }
}
