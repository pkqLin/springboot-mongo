package com.lin.thread.more;

public class TestSleep {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(i);

            }
        } catch (Exception e) {

        }
    }


}
