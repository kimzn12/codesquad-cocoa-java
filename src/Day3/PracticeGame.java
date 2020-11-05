package Day3;


class Hero {
    public String name;
    public int hp;

    public Hero(String _name){
        this.name = _name;
        this.hp = 100;
    }

    //h를 공격
    public void punch(Hero h){
        h.hp -= 30;
        System.out.println(this.name + "의 공격!");
        System.out.println(h.name + "의 체력: " + h.hp);
        System.out.println();
    }

    public static void battle(Hero h1, Hero h2) {
        //왜 static..?
        Hero attacker, depender;

        while(h1.hp > 0 && h2.hp > 0) {
            if(Math.random() < 0.5) { // 0.00... ~ 0.9999 절반확률 : <0.5
                attacker = h1;
                depender = h2;
            }
            else {
                attacker = h2;
                depender = h1;
            }
            attacker.punch(depender);
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
