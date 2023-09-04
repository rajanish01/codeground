package threading;

public class SyncRaceCondition {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1_00_000; i++) {
                synchronized (SyncRaceCondition.class) {
                    count++;
                }
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
