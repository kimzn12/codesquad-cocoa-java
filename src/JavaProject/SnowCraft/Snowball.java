package JavaProject.SnowCraft;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Snowball {
    public int x;
    public int y;

    public Snowball(){
        //getSnowballImage();
    }

    public BufferedImage getSnowballImage() {
        File f = new File("./src/JavaProject/image/snow.png");
        try {
            return ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
            return null; //저번에 이거 몰랐던 듯
        }
    }

    //날라가기
    public void move(){
        if (this.x > 0){
            this.x -= 50;
            this.y -= 50;
        }

        System.out.println("after move " + this.x + " " + this.y);

    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    //이미지 생성
}

