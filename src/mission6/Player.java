package mission6;

import java.awt.*;
import java.util.Random;

public class Player {
    int x, y;
    int score;

    public Player(){
        this.x = 500;
        this.y = 800;
    }

    //이동
    public void move(){

    }

    //바나나 밟았을 때 - 랜덤으로 스코어 빼기
    public boolean stepOnBanana(Banana banana){
        //바나나 충돌
        if (isCollide(banana.x,banana.y)){
            //바나나지우기:메인에
            //점수 깎기 ,
            // 0점이면 깎으면 안됨
            Random rd = new Random();
            int lostScore = rd.nextInt(5)+1; //1~5점 깎음
            this.score -= lostScore;

            return true;
        }
        return false;
    }

    //코인 먹었을 때 - 스코어 +5점
    public boolean getCoin(Coin coin){
        //코인 충돌
        if(isCollide(coin.x,coin.y)){
            //코인 지우기 : main쪽에 있음
            //점수 획득
            this.score += 5;
            System.out.println(this.score);

            return true;
        }
        return false;
    }

    //충돌
    private boolean isCollide(int x, int y){

        if (this.x > (x-30) && this.x < (x+30) && this.y > (y-30) && this.y < (y+30)){
           //범위로 지정하지 않으면 충돌 판단이 너무 빡세다
            return true;
        }
        return false;
    }

}
