package mission6;

import mission4.MyCalender;

import java.util.Scanner;

public class GameTimer implements Runnable {
    Thread thread;
    private int timeCount = 20;


    public GameTimer(){
        thread = new Thread(this);
        thread.start();
    }

    public int getTimeCount() {
        return timeCount;
    }

    public boolean checkTimeOut(){
        if(timeCount == 0) return true;
        return false;
    }

    @Override
    public void run() {
            try {
                while(true){
                    thread.sleep(1000); // 1초마다 실행
                    timeCount--;
                    System.out.println("running" + timeCount);
                    if (this.checkTimeOut()) {
                        System.out.println("Done!");
                        break;
                        //System.exit(0); // 끝나는게 아니라 점수표나오게
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



}
