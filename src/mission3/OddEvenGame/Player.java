package mission3.OddEvenGame;

import java.util.*;

public class Player {
    public String name;
    public  int money;
    public static final int INIT_MONEY = 100;
    public String oddOrEven;
    public int bettingAmount;

    public Player(String _name){
        this.name = _name;
        this.money = INIT_MONEY;

    }

    //홀짝선택
    public void selectOddOrEven(){
        Scanner sc = new Scanner(System.in);
        System.out.println("'홀' 또는 '짝'을 입력하세요.");

        this.oddOrEven = sc.next();

    }

    //배팅
    public void betMoney(Enemy enemy){
        Scanner sc = new Scanner(System.in);
        System.out.println("배팅 금액을 입력하세요.");
        int bettingAmount = sc.nextInt();

        if(bettingAmount > Math.min(this.money, enemy.money)){
            System.out.println("배팅 금액이 너무 큽니다.");
            betMoney(enemy); //다시하기
        }

        this.bettingAmount = bettingAmount;

    }

}
