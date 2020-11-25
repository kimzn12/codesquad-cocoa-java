package mission6;

import java.util.Random;

public class Ghost{
    Thread thread;
    int x, y;

    public Ghost(){
        Random rd= new Random();

        this.x = rd.nextInt(700);
        this.y = -200;
    }

    public void move(){
        if(this.y < 1250){
            this.y += 20;
        }
    }
}
