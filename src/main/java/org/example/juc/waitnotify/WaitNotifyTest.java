package org.example.juc.waitnotify;

/**
 * @Package org.example.juc.waitnotify
 * @ClassName WaitNotifyTest
 * @Description wait/notify的用法
 * @Author perl
 * @Date 2020/9/17 1:53 PM
 * @Version 1.0
 */
public class WaitNotifyTest {

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "进入了synchronized代码块，获得了锁..");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "被唤醒了，执行完毕...");
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "进入了synchronized代码块，获得了锁..");
                object.notifyAll();
                System.out.println(Thread.currentThread().getName() + "执行完毕...");
            }
        });
        threadA.start();
        Thread.sleep(100L);
        threadB.start();
    }
}
