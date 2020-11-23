package mission6;

//바나나 위에서 떨어지게 하고 싶다.

import java.util.Random;
import java.awt.*;

public class Banana {
    int x, y;

    public Banana(){
        Random rd= new Random();

        this.x = rd.nextInt(800);
        this.y = rd.nextInt(1200);
    }

}
