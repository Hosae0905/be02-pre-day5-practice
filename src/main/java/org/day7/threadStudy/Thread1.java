package org.day7.threadStudy;

/**
 * 스레드를 만들기 위한 방법
 * 1. 클래스를 상속받아서 사용
 * 2. Runnable 인터페이스를 구현해서 사용
 * 메인 메서드와 관계없이 독립적으로 실행되게 된다.
 */

public class Thread1 extends Thread{        // 상속받으면 하나의 스레드로 만들 수 있다.

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("스레드에서 실행 : " + i);
        }
    }
}
