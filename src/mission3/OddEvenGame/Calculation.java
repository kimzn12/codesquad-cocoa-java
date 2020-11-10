package mission3.OddEvenGame;


public class Calculation {

    public static void enemyWin(Player p, Enemy e) {
        p.money -= p.bettingAmount;
        e.money += p.bettingAmount;
        System.out.println("enemy Win ");
        System.out.printf("player money: %d, enemy money: %.3f\n",p.money,e.money);

    }
    public static void playerWin(Player p, Enemy e) {
        p.money += p.bettingAmount;
        e.money -= p.bettingAmount;
        System.out.println("player win");
        System.out.printf("player money: %d, enemy money: %.3f\n",p.money,e.money);
    }
}
