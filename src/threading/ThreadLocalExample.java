package threading;

public class ThreadLocalExample {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread t1 = new Thread(() -> {
            threadLocal.set("Thread 1");    //thread can set only once value here
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();       //removed set value from thread local
            System.out.println(threadLocal.get());  //result null
        });
        System.out.println(threadLocal.get());  //will result null because main thread not set any value in thread local
        t1.start();

    }

}
