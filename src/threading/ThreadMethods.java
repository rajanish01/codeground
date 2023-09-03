package threading;

public class ThreadMethods {

    public static class MyThread implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName(); //Gets name of current running thread
            System.out.println(threadName + " Running !");
        }
    }

    public static class SleepingThread implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " Going To Sleep !");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " Woke Up !");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Started !");
        Thread newThreadWithName = new Thread(new MyThread(), "MyThread");  //Set a name to thread while declaration
        newThreadWithName.start();
        Thread sleepingThread = new Thread(new SleepingThread());
        sleepingThread.start();

        Runnable runnableCounter = () -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " Count : " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread counter = new Thread(runnableCounter);
        counter.setDaemon(true);    //Main thread stops counter thread just after its exits.
        counter.start();
        counter.join();     //Makes Main thread wait until counter thread is running.

    }

}
