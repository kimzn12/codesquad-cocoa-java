package FinalMission.FindSamePicture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame implements Runnable{
    private BufferedImage background;
    private Thread thread; //TODO:없어도 될 것 같은데

    public GameWindow(){
        loadImage();
        init();
        //addEvent();
        thread = new Thread(this); //this
    }

    //background 이미지 로드
    private void loadImage() {
        //background이미지 다시작성
        try {
            File f = new File("./");
            System.out.println(f.getAbsolutePath());
            background = ImageIO.read(new File("./src/FinalMission/image/background2.png"));
        } catch(IOException e){
            System.exit(1); //1은 무슨 의미인가?
        }
    }

    private void init(){
        setTitle("Fine Same Picture");
        setSize(background.getWidth(),background.getHeight());
        //setSize(1200,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); //사이즈 조절 안됨
        setLocationRelativeTo(null); //가운데 창 생성
    }

    public void update(){
        repaint();
    }

    public void paint(Graphics g){
        g.drawImage(background,0,0,this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run(){
        while(true){
            update();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
