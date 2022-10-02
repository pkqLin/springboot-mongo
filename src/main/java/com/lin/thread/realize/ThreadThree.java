package com.lin.thread.realize;

public class ThreadThree implements Runnable {
    @Override
    public void run() {
        System.out.println("这里执行runable的run方法");
    }

    public static void main(String[] args) {
        ThreadThree threadThree = new ThreadThree();
        //开启代理实现
        new Thread(threadThree).start();
    }
}
