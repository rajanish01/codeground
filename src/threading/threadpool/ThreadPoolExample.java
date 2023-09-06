package threading.threadpool;

public class ThreadPoolExample {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3, 10);
        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            threadPool.execute(() -> {  //for every i, we are creating a runnable instance and passing to thread pool for execution
                String message = Thread.currentThread().getName() + " : Task " + taskNo;
                System.out.println(message);
            });
        }
        threadPool.waitUntilAllTaskFinished();
        threadPool.stop();
    }

}
