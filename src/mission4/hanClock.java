package mission4;

import java.util.*;

public class hanClock implements Runnable {
    @Override
    public void run() {

        String[][] hangulClock = {{" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "}};

        String[][] hangulNumber = {{"한", "두", "세", "네", "다", "섯"},
                {"여", "섯", "일", "곱", "여", "덟"},
                {"아", "홉", "열", "한", "두", "시"},
                {"자", "이", "삼", "사", "오", "십"},
                {"정", "일", "이", "삼", "사", "오"},
                {"오", "육", "칠", "팔", "구", "분"}};

        //날짜 가져오기
        Calendar cal = Calendar.getInstance();

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        //시간 출력
        //정오
        if (hour == 12 && minute == 0) {
            hangulClock[4][0] = hangulNumber[4][0];
            hangulClock[5][0] = hangulNumber[5][0];
        }
        //자정
        else if (hour == 0 && minute == 0) {
            hangulClock[3][0] = hangulNumber[3][0];
            hangulClock[4][0] = hangulNumber[4][0];
        } else {
            //시,분 표시
            hangulClock[2][5] = hangulNumber[2][5];
            if (hour > 12) hour -= 12;

            //시
            switch (hour) {
                case 1:
                    hangulClock[0][0] = hangulNumber[0][0];
                    break;
                case 2:
                    hangulClock[0][1] = hangulNumber[0][1];
                    break;
                case 3:
                    hangulClock[0][2] = hangulNumber[0][2];
                    break;
                case 4: //여기서부터 인덱스 고쳐야함.
                    hangulClock[0][3] = hangulNumber[0][3];
                    break;
                case 5:
                    hangulClock[0][4] = hangulNumber[0][4];
                    hangulClock[0][5] = hangulNumber[0][5];
                    break;
                case 6:
                    hangulClock[1][0] = hangulNumber[1][0];
                    hangulClock[1][1] = hangulNumber[1][1];
                    break;
                case 7:
                    hangulClock[1][2] = hangulNumber[1][2];
                    hangulClock[1][3] = hangulNumber[1][3];
                    break;
                case 8:
                    hangulClock[1][4] = hangulNumber[1][4];
                    hangulClock[1][5] = hangulNumber[1][5];
                    break;
                case 9:
                    hangulClock[2][0] = hangulNumber[2][0];
                    hangulClock[2][1] = hangulNumber[2][1];
                    break;
                case 10:
                    hangulClock[2][2] = hangulNumber[2][2];
                    break;
                case 11:
                    hangulClock[2][2] = hangulNumber[2][2];
                    hangulClock[2][3] = hangulNumber[2][3];
                    break;
                case 12:
                    hangulClock[2][2] = hangulNumber[2][2];
                    hangulClock[2][4] = hangulNumber[2][4];
                    break;
            }
            //분
            hangulClock[5][5] = hangulNumber[5][5]; //분 0일때 표시되면 안됨

            int minuteFirst = minute / 10;
            int minuteSecond = minute % 10;

            //1*,2*,3*,4*,5*
            if (minuteFirst > 0) {
                hangulClock[3][5] = hangulNumber[3][5];
                if (minuteFirst > 1)
                    hangulClock[3][minuteFirst - 1] = hangulNumber[3][minuteFirst - 1];
            }

            //*1 ~ *9
            if (minuteSecond > 0 && minuteSecond < 6) {
                hangulClock[4][minuteSecond] = hangulNumber[4][minuteSecond];
            }
            if (minuteSecond > 5) {
                hangulClock[5][minuteSecond - 5] = hangulNumber[5][minuteSecond - 5];
            }

        }
        //화면 출력
        System.out.println("==========================");

        for (String[] i : hangulClock) {
            for (String j : i) {
                System.out.printf("%s\t", j);
            }
            System.out.println();
        }
        System.out.println("                      " + sec);
        System.out.println("==========================");

    }

}

