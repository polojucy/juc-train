package org.example.juc.synchronize;

/**
 * @Package org.example.juc.synchronize
 * @ClassName SynchronizedTestV1
 * @Description 不进行任何同步控制
 * @Author perl
 * @Date 2020/9/15 10:27 AM
 * @Version 1.0
 */
public class SynchronizedTestV1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("=========线程1：执行开始=========");
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("=========线程1：执行结束=========");
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("=========线程2：执行开始=========");
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("=========线程1：执行结束=========");
            }
        });
        thread1.start();
        thread2.start();
    }
}
