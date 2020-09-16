package org.example.juc.createthread;

/**
 * @Package org.example.juc.createthread
 * @ClassName CreateThreadV2
 * @Description 创建线程方式2：实现Runnable接口,并实现run方法
 * @Author perl
 * @Date 2020/9/16 10:25 AM
 * @Version 1.0
 */
public class CreateThreadV2 implements Runnable{
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
        Thread createThreadV2 = new Thread(new CreateThreadV2());
        createThreadV2.start();
    }
}
