package org.example.juc.synchronize;

/**
 * @Package org.example.juc.synchronize
 * @ClassName SynchronizedTestV5
 * @Description 类锁的形式1-静态方法锁：使用synchronized关键字修饰static方法
 * @Author perl
 * @Date 2020/9/15 11:38 AM
 * @Version 1.0
 */
public class SynchronizedTestV5 implements Runnable{

    static SynchronizedTestV5 instance1 = new SynchronizedTestV5();
    static SynchronizedTestV5 instance2 = new SynchronizedTestV5();

    @Override
    public void run() {
        method();
    }

    public static void method() {
        System.out.println("线程"+ Thread.currentThread().getName() + "开始执行");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+ Thread.currentThread().getName() + "执行结束");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
    }


}
