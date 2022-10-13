package com.lin.thread.more;




//观察测试线程状态
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.print(state);
        while(state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
    }


}
