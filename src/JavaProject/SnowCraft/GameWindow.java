package JavaProject.SnowCraft;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame implements Runnable {

    private Thread thread;
    private BufferedImage background; // bufferedImage?
    private Player player;
    //private Snowball snowball;
    //private Input input; //input 리스너 클래스 분리 못하겠음..

    BufferedImage pImage;
    //BufferedImage sImage;

    private boolean pressedPlayer = false;
    private boolean attack = false;

    public GameWindow(){
        loadImage();
        init();
        initPlayer();
        //initSnowball();

        thread = new Thread(this); //this
        addEvent();


    }

    private void addEvent(){
        //input = new Input();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e); //?
                System.out.println("Released");
                if(pressedPlayer){
                    attack = true;
                    player.throwSnow();
                }
                //초기화
                pressedPlayer = false;

            }

            @Override
            public void mousePressed(MouseEvent e){
                attack = false; //초기화
                super.mouseClicked(e);
                System.out.println("mouse" + e.getX()+ " " + e.getY());
                System.out.println("X범위 " + player.getX() + " " + (player.getX() + pImage.getWidth()) );
                System.out.println("Y범위 " + player.getY() + " " + (player.getY() + pImage.getHeight()) );

                //캐릭터 눌렀을 경우
                if(e.getX() > player.getX() && e.getX() < (player.getX() + pImage.getWidth()) &&
                        e.getY() > player.getY()  && e.getY() < (player.getY() + pImage.getHeight())){
                    pressedPlayer = true;
                }

                System.out.println(pressedPlayer);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(pressedPlayer){
                    player.setX(e.getX());
                    player.setY(e.getY());
                }


            }
        });
        //addMouseMotionListener(input);

    }

    private void initPlayer(){
        player = new Player();
        pImage = player.getPlayerImage();
    }

//    private void initSnowball(){
//        snowball = new Snowball(); // 이거 플레이어한테 있어야 할 듯.
//        //sImage = snowball.getSnowballImage();
//    }



    private void loadImage() {
        //background이미지 다시작성
        try {
            File f = new File("./");
            System.out.println(f.getAbsolutePath());
            background = ImageIO.read(new File("./src/JavaProject/image/bg.png"));
        } catch(IOException e){
            System.exit(1); //1은 무슨 의미인가?
        }

    }

    private void init(){
        setTitle("SnowCraft");
        setSize(background.getWidth(),background.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); //사이즈 조절 안됨
        setLocationRelativeTo(null); //가운데 창 생성
    }

    public void update(){
        repaint();
    }

    public void paint(Graphics g){
        g.drawImage(background,0,0,this);

        g.drawImage(pImage,player.getX(),player.getY(),this);
        if(attack){
            System.out.println("make snowball image");
            g.drawImage(player.sImage,player.snowball.getX(),player.snowball.getY(), this);
        }

    }

    public static void main(String[] args){
        GameWindow game = new GameWindow();
        game.setVisible(true);
        game.start();
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
