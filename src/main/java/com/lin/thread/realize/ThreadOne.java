package com.lin.thread.realize;

public class ThreadOne  extends Thread {

    @Override
    public void run(){
        System.out.println("testone");

    }

    public static void main(String[] args) {
        ThreadOne threadOne =new ThreadOne();
//        threadOne.run();
        //多线程执行start方法，而thread只可执行run方法
        threadOne.start();

        System.out.println("main");
    }
}
