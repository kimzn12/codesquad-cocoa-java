package mission4;

import java.util.Scanner;

public class ClockAndCal {

    public static void main(String[] args) {
        System.out.println("시계 : clock, 달력: cal 을 입력하세요.");

        while(true){
            System.out.print("input>");
            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine();

            if (cmd.equals("cal")) {
                try {
                    Thread cal = new Thread(new MyCalender());
                    cal.start();
                    cal.join(60*1000);
                    //join을 사용하면 cal 쓰레드가 다 끝난 후에 main의 while문이 돌지 않는다.
                    //join 사용시 스레드가 종료되지 않은 경우 무한히 대기할 수 있기에 join에 timeout 시간을 지정해준다.

                } catch (Throwable e) {
                    //에러 날경우
                    e.printStackTrace();
                }
            }

            if (cmd.equals("clock")) {
                try {
                    while (true) {
                        Thread clock = new Thread(new hanClock());
                        clock.start();
                        clock.sleep(1000); //1초

                    }

                } catch (Throwable e) {
                    //에러 날경우
                    e.printStackTrace();
                }
            }

        }


    }
}



