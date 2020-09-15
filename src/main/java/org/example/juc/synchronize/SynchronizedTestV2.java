package org.example.juc.synchronize;

/**
 * @Package org.example.juc.synchronize
 * @ClassName SynchronizedTestV2
 * @Description 使用synchronized(this)代码块来进行同步控制
 * @Author perl
 * @Date 2020/9/15 10:28 AM
 * @Version 1.0
 */
public class SynchronizedTestV2 {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        System.out.println("=========线程"+ Thread.currentThread().getName() +"：执行开始=========");
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("=========线程"+ Thread.currentThread().getName() +"：执行结束=========");
                    }
                }

            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
