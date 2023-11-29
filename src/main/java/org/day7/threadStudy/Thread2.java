package org.day7.threadStudy;

public class Thread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("새로운 스레드에서 실행 : " + i);
        }
    }
}
