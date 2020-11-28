package JavaProject.SnowCraft;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    //private players; //이미지 저장할 배열
    private int x;
    private int y;

    Snowball snowball;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        snowball= new Snowball();
        //loadImage();
        //getPlayerImage();
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

//    public BufferedImage getImage(long frame){
//        //TODO: ?
//    }

    private void loadImage(){
        //TODO: 여러 이미지 배열에 로드
    }

    public BufferedImage getPlayerImage(){
        String path = "./src/JavaProject/image/player1";
        String ext = ".png";

        File f = new File(path + ext);
        try{
            return ImageIO.read(f);
        } catch(IOException e){
            System.exit(1);
            return null;
        }
    }

    public void throwSnow(){
        snowball.move();
    }

    public void initSnowball(){
        snowball.x = this.x;
        snowball.y = this.y;
    }

}
