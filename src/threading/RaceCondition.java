package threading;

public class RaceCondition {

    private static int count = 0;

    /*
        Below method should count till 200000, but not works because of race condition.
     */

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1_00_000; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() + " " + count);
        };

        Thread t1 = new Thread(runnable, "T1");
        Thread t2 = new Thread(runnable, "T2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
