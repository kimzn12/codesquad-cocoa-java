package mission3.OddEvenGame;

import java.util.Random;

public class Enemy {
    public double money;
    public int enemyNum;

    public Enemy(Player player,int numStage){
        this.money = (player.money * Math.pow(1.2, numStage));
    }

    public void selectNumber(){
        Random rd = new Random();
        this.enemyNum = rd.nextInt(20) + 1; //1~20중 랜덤선택
    }

}
