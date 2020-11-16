package mission4;

import java.util.*;

public class Sceduler {
    public static void sc() {
        Date date = new Date();

        TimerTask runnable = new TimerTask() {
            public void run() {
                hanClock.hangulClock();
                System.out.println(date);
            }
        };

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(runnable, 0,
                60 * 1000); //delay가 아닌 firsttime을 알고싶은데...
    }


}
