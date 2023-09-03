package threading;

public class RaceCondition {

    private static Integer count = 0;

    private static void increment() {
        count++;
    }
    /*
        Below method will result 1 OR 2 because of race conditions.
     */

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            increment();
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

}
