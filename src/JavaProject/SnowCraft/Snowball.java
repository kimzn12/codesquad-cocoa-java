package JavaProject.SnowCraft;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Snowball {
    private int x;
    private int y;

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

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int i){
        this.x = i;
    }

    public void setY(int i){
        this.y = i;
    }

    //이미지 생성


    //날라가기
}

