package com.lin.thread.priority;

public class TestPriority {

    public static void main(String[] args) {
        MyPriority myPriority=new MyPriority();
        Thread t1= new Thread(myPriority);
        Thread t2= new Thread(myPriority);
        Thread t3= new Thread(myPriority);
        Thread t4= new Thread(myPriority);
        Thread t5= new Thread(myPriority);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
    }

}

class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
