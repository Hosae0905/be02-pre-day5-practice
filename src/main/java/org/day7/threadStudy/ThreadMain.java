package org.day7.threadStudy;

/**
 * 여러 스레드를 이용해서 동시에 여러 작업을 수행
 * 장점
 * 작업 속도가 빨라진다.
 * 진짜 장점은 비동기 작업이 가능하다.
 * 단점
 * CPU가 왔다갔다 하는 시간도 걸린다. (특정 상황에서 오히려 느려질 수 있다) --> 컨택스트 스위칭
 * 동기화가 어려워진다.
 * 스레드 세이프하지 않을 수 있다.
 *
 */

public class ThreadMain {
    public static void main(String[] args) {

        Thread thread = new Thread1();      // 스레드를 사용하기 위해서는 객체를 생성해줘야 한다. (다형성)
        thread.start();     // 스레드를 시작하는 메서드 (run() 메서드를 실행시킨다.)

        Runnable runnable = new Thread2();
        Thread thread2 = new Thread(runnable);
        thread2.start();


        for (int i = 0; i < 100; i++) {
            System.out.println("메인 스레드에서 실행함 : " + i);
        }
    }
}
