package org.example.juc.interruptthread;

/**
 * @Package org.example.juc.interruptthread
 * @ClassName InterruptThreadV1
 * @Description 演示如何正确停止线程(run方法中没有阻塞线程操作)
 * @Author perl
 * @Date 2020/9/16 1:51 PM
 * @Version 1.0
 */
public class InterruptThreadV1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("do something....");
            }

            System.out.println("execute done!!!!");
        });
        thread.start();
        Thread.sleep(3000L);
        thread.interrupt();
    }
}
