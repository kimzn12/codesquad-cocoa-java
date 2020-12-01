package FinalMission.FindSamePicture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {
    private int month;
    private int cardNumber;
    public boolean isClose;

    public Card(int month, int cardNumber){
        this.month = month;
        this.cardNumber = cardNumber;
        this.isClose = true;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString(){
        return "Card<월: " + month + ", 번호: " + cardNumber + ">";
    }


    //이미지 로드
    public BufferedImage getImage(){
        String path = "./src/FinalMission/image/CardImage/";
        String name = Integer.toString(this.month);
        String ext = ".png";

        File f = new File(path + name + ext);
        System.out.println(f);
        try{
            return ImageIO.read(f);
        } catch(IOException e){
            System.exit(1);
            return null;
        }
    }

//    public ImageIcon getCardImage(int month){
//        String path = "./src/FinalMission/image/CardImage/";
//        String name = Integer.toString(month);
//        String ext = ".png";
//
//        ImageIcon imageIcon= new ImageIcon(path + name + ext);
//
//        return imageIcon;
//    }
}
