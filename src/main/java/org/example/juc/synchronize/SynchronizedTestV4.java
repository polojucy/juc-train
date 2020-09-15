package org.example.juc.synchronize;

/**
 * @Package org.example.juc.synchronize
 * @ClassName SynchronizedTestV4
 * @Description 方法锁试例：使用synchronized关键字修饰方法进行同步控制
 * @Author perl
 * @Date 2020/9/15 11:15 AM
 * @Version 1.0
 */
public class SynchronizedTestV4 implements Runnable {
    @Override
    public void run() {
        try {
            syncMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void syncMethod() throws InterruptedException {
        System.out.println("线程"+ Thread.currentThread().getName() + "开始执行");
        Thread.sleep(3000L);
        System.out.println("线程"+ Thread.currentThread().getName() + "执行结束");
    }

    public static void main(String[] args) {
        SynchronizedTestV4 v4 = new SynchronizedTestV4();
        Thread thread1 = new Thread(v4);
        Thread thread2 = new Thread(v4);

        thread1.start();
        thread2.start();
    }
}
