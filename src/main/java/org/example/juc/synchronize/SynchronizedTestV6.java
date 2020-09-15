package org.example.juc.synchronize;

/**
 * @Package org.example.juc.synchronize
 * @ClassName SynchronizedTestV6
 * @Description 类锁的形式2-代码块：使用synchronized(xx.class)
 * @Author perl
 * @Date 2020/9/15 11:44 AM
 * @Version 1.0
 */
public class SynchronizedTestV6 implements Runnable{

    @Override
    public void run() {
        method();
    }

    private void method() {
        synchronized (SynchronizedTestV6.class) {
            System.out.println("线程"+ Thread.currentThread().getName() + "开始执行");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+ Thread.currentThread().getName() + "执行结束");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new SynchronizedTestV6());
        Thread thread2 = new Thread(new SynchronizedTestV6());
        thread1.start();
        thread2.start();
    }
}
