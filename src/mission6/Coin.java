package mission6;

import java.util.ArrayList;
import java.util.Random;

public class Coin {
    private int x;
    private int y;
    private static final int NUMBER_OF_COIN = 15;

    //private ArrayList<Coin> coinList = new ArrayList<>();

    public Coin() {
        Random rd= new Random();

        this.x = rd.nextInt(800);
        this.y = rd.nextInt(1200);
    }

    //대체 왜 만드는 지 모르겠다.
    //GameWindow 클래스에서
    //int coinX = coin.getX();
    //로 쓰고 있는데 의미 없는거 아닌가?
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
