package mission6;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Coin {
    int x, y;

    public Coin() {
        Random rd = new Random();

        this.x = rd.nextInt(800);
        this.y = rd.nextInt(1200);
    }

}
