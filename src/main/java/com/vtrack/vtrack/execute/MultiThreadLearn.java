package com.vtrack.vtrack.execute;

import javax.persistence.criteria.CriteriaBuilder;

class Update extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            Thread currentThread=Thread.currentThread();
            System.out.println("Updating "+i +" From "+ currentThread.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class delete implements Runnable{
    void print() throws InterruptedException {
        for(int i=1;i<=5;i++){
            Thread currentThread =Thread.currentThread();
            System.out.println("Deleting "+i + " From"+ currentThread.getName() );
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        try {
            print();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Insert {
    synchronized  void print(int n){
        for(int i=1;i<=5;i++){
            System.out.println("Inserting "+i );
        }
    }
}

class SyncTest{
     synchronized void print(int n) {
        for (int j = 1; j <= n; j++) {
            System.out.println("print sample " + j);
        }
    }

}

public class MultiThreadLearn {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("test");

        Update update = new Update();
        Insert insert = new Insert();

       // update.print();
        update.start();
        update.setName(" update thread");
        if(update.isAlive()){
            System.out.println(update.getName() +" is Still running");
        }
        //insert.print();
       // update.join();
        System.out.println("Ended");

        Runnable delete = new delete();


        Thread deleteThread = new Thread(delete);
        deleteThread.setName(" Delete Thread Name");
        deleteThread.start();

        Runnable book = new Runnable() {
            @Override
            public void run() {

                for(int i=1;i<=5;i++){
                    Thread currentThread=Thread.currentThread();
                    System.out.println("Book "+i +" From"+ currentThread.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };
        Runnable readBook = ()-> {
                for(int i=1;i<=5;i++){
                    Thread currentThread=Thread.currentThread();
                    System.out.println("Read Book "+i +" From"+currentThread.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        };


        Thread bookThread = new Thread(book);
        bookThread.setName(" book thread");
        bookThread.setPriority(10);
        Thread readBookThread = new Thread(readBook);
        readBookThread.setName(" read book thread");
        readBookThread.setPriority(1);
        bookThread.start();
        readBookThread.start();

        SyncTest syncTest = new SyncTest();
        Thread sample = new Thread(){
            public void run(){
                syncTest.print(5);
            }
        };
        sample.start();



        System.out.println("After delete run");

    }
}
