package threading;

public class ThreadInitExample {
    /**
     * Thread Class
     * This class shows example of class using Thread Class.
     */
    public static class ThreadClassExample extends Thread {
        public void run() {
            System.out.println("Thread using Thread Class Started !");
        }
    }

    /**
     * Runnable Interface
     * This class shows example of class using Runnable Interface.
     */
    public static class RunnableClassExample implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread using Runnable Interface Started !");
        }
    }

    public static void main(String[] args) {
        Thread threadClassExample = new ThreadClassExample();   //Thread creation using Thread Class
        Thread runnableClassExample = new Thread(new RunnableClassExample());   //Thread creation using Runnable Interface
        /* Anonymous Runnable Interface
         * Below example of class using Anonymous Runnable Interface.
         */
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread using Anonymous Runnable Interface Started !");
            }
        };
        Thread anonymousRunnableExample = new Thread(anonymousRunnable);    //Thread creation using Anonymous Runnable Interface
        /* Anonymous Runnable Interface Using Lambda
         * Below example of class using Anonymous Runnable Interface using Lambda.
         */
        Runnable lambdaRunnable = () -> {
            System.out.println("Thread using Lambda Runnable Interface Started !");
        };
        Thread lambdaRunnableExample = new Thread(lambdaRunnable);  //Thread creation using Anonymous Runnable Interface Using Lambda

        threadClassExample.start();
        runnableClassExample.start();
        anonymousRunnableExample.start();
        lambdaRunnableExample.start();
    }

}
