/**
 * @Package PACKAGE_NAME
 * @ClassName Test
 * @Description TODO
 * @Author perl
 * @Date 2020/9/17 10:21 AM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("test....");
        });

        thread.start();
        thread.start();
    }
}
