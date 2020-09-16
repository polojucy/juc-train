package org.example.juc.createthread;

/**
 * @Package org.example.juc.createthread
 * @ClassName CreateThreadV1
 * @Description 创建线程方式1：继承Thread类,并重写run方法
 * @Author perl
 * @Date 2020/9/16 10:16 AM
 * @Version 1.0
 */
public class CreateThreadV1 extends Thread{

    @Override
    public void run() {
        while (true) {
            System.out.println("do something.....");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CreateThreadV1 createThreadV1 = new CreateThreadV1();
        createThreadV1.start();
    }
}
