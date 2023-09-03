package threading;

public class VirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " -> Virtual Thread Started !");
        };
        Thread vt1 = Thread.ofVirtual().start(runnable);    //Starts a virtual thread
        Thread vt2 = Thread.ofVirtual().unstarted(runnable);    //Creates a virtual thread, and starts at start event.
        vt2.start();
        vt1.join();
        vt2.join();
    }
}
