package FinalMission.FindSamePicture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame implements ActionListener {
    private static final int BOARD_SIZE = 16;

    private JPanel jLeft;
    private JPanel jRight;
    private JPanel jTop;
    private JPanel jBottom;
    private JPanel jCenter; // 버튼이 들어갈 패널

    private BufferedImage background;
    //private BufferedImage cImage;

    private Card card;
    private CardDeck cardDeck;

    private Thread thread; //TODO:없어도 될 것 같은데

    private JButton[] cardButtons;


    public GameWindow() {
        //loadImage();
        init();
        initButton();
        showCardImage();
        //addEvent();
       // thread = new Thread(this); //this
        setVisible(true);

    }



    //background 이미지 로드
    private void loadImage() {
        //background이미지 다시작성
        try {
            File f = new File("./");
            System.out.println(f.getAbsolutePath());
            background = ImageIO.read(new File("./src/FinalMission/image/CardImage/1.png"));
        } catch (IOException e) {
            System.exit(1); //1은 무슨 의미인가?
        }
    }

    private void init() {
        //Frame 설정
        setTitle("Fine Same Picture");
        //setSize(background.getWidth(), background.getHeight());
        setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); //사이즈 조절 안됨
        setLocationRelativeTo(null); //가운데 창 생성

        //패널 설정
        jLeft = new JPanel();
        jRight = new JPanel();
        jTop = new JPanel();
        jBottom = new JPanel();
        jCenter = new JPanel(); // 버튼이 들어갈 패널

        //이렇게하면 가장자리에 여백을 줄 수 있다.
        add(jLeft, "West");
        jLeft.setPreferredSize(new Dimension(70, 1000));

        add(jRight, "East");
        jRight.setPreferredSize(new Dimension(70, 1000));

        add(jTop, "North");
        jTop.setPreferredSize(new Dimension(1000, 70));

        add(jBottom, "South");
        jBottom.setPreferredSize(new Dimension(1000, 70));

        add(jCenter,BorderLayout.CENTER);
        jCenter.setLayout(new GridLayout(4, 4, 50, 50)); // GridLayout(4,4) 지정


    }
    //버튼 생성
    private void initButton() {
        cardButtons = new JButton[BOARD_SIZE];

        for(int i = 0; i < BOARD_SIZE; i++){
            cardButtons[i] = new JButton("hi");
            jCenter.add(cardButtons[i]);
        }
    }


//    public void update() {
//        repaint();
//    }
//
//    public void paint(Graphics g) {
//        g.drawImage(background, 0, 0, this);
//        //g.drawImage(cImage, 200, 200, this);
//
//    }

//    public void start() {
//        thread.start();
//    }

//    @Override
//    public void run() {
//        while (true) {
//            update();
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //그림을 버튼에 저장
    private void showCardImage() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                cardButtons[i].setIcon((new ImageIcon("./src/FinalMission/image/CardImage/1.png")));
            }
        }
    }
}
