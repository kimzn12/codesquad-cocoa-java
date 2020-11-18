package mission4;

import java.util.Calendar;
import java.util.Scanner;


public class MyCalender implements Runnable {
    Calendar cal = Calendar.getInstance();
    int [][] calFormat = new int[6][7];

    // 달 입력받기
    public void setDate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("* 년도를 입력하세요:");
        int year = sc.nextInt();
        System.out.println("* 달을 입력하세요:");
        int month = sc.nextInt();

        makeCalender(year,month);
    }

    //입력한 달의 달력 세팅
    public void makeCalender(int year, int month){
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH,month-1);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 마지막일

        for (int i = 1; i <= lastDay; i++) {
            cal.set(Calendar.DATE, i); //계속 cal의 날짜를 바꾸기
            int week = cal.get(Calendar.WEEK_OF_MONTH)-1; // 0주부터 시작
            int day = cal.get(Calendar.DAY_OF_WEEK) - 1; // 0: 일요일

            calFormat[week][day] = i;
            // cal의 [몇째 주][무슨 요일]
            // 1: 일요일 (idx: 0) , 1: 1째주 (idx: 0)
        }

        printCalender();
    }

    //오늘의 달력 만들기
    public void makeTodayCalender(){
        int year= cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        makeCalender(year,month);
    }

    //캘린더 출력
    public void printCalender(){
        System.out.println("===========================");
        System.out.println("\t\t\t\t"+cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1));
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for (int i = 0; i < 6; i++){
            for (int j = 0 ; j < 7; j++){
                if (calFormat[i][j]==0) System.out.print("\t");
                else System.out.print(calFormat[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    @Override
    public void run() {
        makeTodayCalender(); //오늘의 달력 출력
        setDate(); // 원하는 달력 출력
    }
}
