package com.vtrack.vtrack.execute;

import java.util.concurrent.*;

public class ExecutorServiceLearn {

    class UserThread implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            System.out.println("Inside Thread 1");
            return 70;
        }
    }
    class ProductThread implements  Runnable{
        final Integer resultFromThread1;

        ProductThread(Integer resultFromThread1) {
            this.resultFromThread1 = resultFromThread1;
        }

        @Override
        public void run() {
            System.out.println("Inside Thread 2");
            System.out.println("Value from thread 1: "+resultFromThread1);
        }
    }

    public static void main(String[] args)  {
        ExecutorServiceLearn executorServiceLearn = new ExecutorServiceLearn();
        executorServiceLearn.executeTasks();
    }
    public void executeTasks() {


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> futureResult = executorService.submit(new UserThread());
try {
    int resultfromthread1 = futureResult.get();
    executorService.submit(new ProductThread(resultfromthread1));

}catch(Exception e){

}

    }
}
