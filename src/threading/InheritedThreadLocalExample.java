package threading;

public class InheritedThreadLocalExample {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread parent = new Thread(() -> {
            threadLocal.set("Parent Thread Data");
            inheritableThreadLocal.set("Parent Thread Inheritable Data");

            System.out.println("Parent : " + threadLocal.get());
            System.out.println("Parent In : " + inheritableThreadLocal.get());

            Thread child = new Thread(() -> {
                System.out.println("Child : " + threadLocal.get()); //no access to parent thread data
                System.out.println("Child In : " + inheritableThreadLocal.get());   //keeps parent thread data
            });
            child.start();
        });

        Thread other = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Other : " + threadLocal.get()); //null
            System.out.println("Other In : " + inheritableThreadLocal.get());   //null
        });

        parent.start();
        other.start();
    }
}
