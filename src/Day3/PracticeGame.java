package Day3;

import java.util.Scanner;

class Hero {
    public String name;
    public int hp;

    public Hero(String _name){
        this.name = _name;
        this.hp = 100;
    }

    public static void battle(Hero h1, Hero h2) {
        //왜 static..?

        while(h1.hp > 0 && h2.hp > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println(h1.name + "또는" + h2.name + "을 입력하세요.");
            String attacker = sc.next();
            //sc.close();

            if (attacker.equals(h1.name)) {
                h2.hp -= 30;
                System.out.println(h1.name + "의 공격!");
                System.out.println(h2.name + "의 체력: " + h2.hp);
            }
            else {
                h1.hp -= 30;
                System.out.println(h2.name + "의 공격!");
                System.out.println(h1.name + "의 체력: " + h1.hp);
            }
        }
        if (h1.hp ==0){
            System.out.println(h2.name + "이 이겼습니다.");
        }
        else {
            System.out.println(h1.name + "이 이겼습니다.");
        }
    }



}

public class PracticeGame {
    public static void main(String[] args){
        Hero superman = new Hero("슈퍼맨");
        Hero batman = new Hero("배트맨");

        Hero.battle(superman, batman);
    }
}
