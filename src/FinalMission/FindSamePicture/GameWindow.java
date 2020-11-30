package FinalMission.FindSamePicture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Timer;
import java.util.TimerTask;

public class GameWindow extends JFrame {
    private static final int BOARD_SIZE = 16;

    private JPanel jLeft;
    private JPanel jRight;
    private JPanel jTop;
    private JPanel jBottom;
    private JPanel jCenter; // 버튼이 들어갈 패널

    private BufferedImage background;
    //private BufferedImage cImage;

    private CardDeck cardDeck = new CardDeck(); //TODO: 이거 분리하고 싶었음

    private Thread thread; //TODO:없어도 될 것 같은데

    private JButton[] cardButtons;

    private boolean isOpen = false;

    //클릭한 카드 인덱스
    int indexOfClickCard;

    private int FirstCardMonth = 0;
    private int SecondCardMonth = 0;

    private Card FirstCard = null;
    private Card SecondCard = null;
    //클릭한 카드 달
    private int clickedCardMonth = 0;
    private int clickedCardIndex;
    private int FirstCardIndex;
    private int SecondCardIndex;


    public GameWindow() {
        loadImage();
        init();
        initButton();
        showFrontImage();
        showBackImage();

        setVisible(true);

    }


    //background 이미지 로드
    private void loadImage() {
        //background이미지 다시작성
        try {
            File f = new File("./");
            System.out.println(f.getAbsolutePath());
            background = ImageIO.read(new File("./src/FinalMission/image/background2.png"));
        } catch (IOException e) {
            System.exit(1); //1은 무슨 의미인가?
        }
    }

    private void init() {
        //Frame 설정
        setTitle("Fine Same Picture");
        setSize(background.getWidth(), background.getHeight());
        //setSize(1000,1000);
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
        jLeft.setPreferredSize(new Dimension(100, 1000));

        add(jRight, "East");
        jRight.setPreferredSize(new Dimension(100, 1000));

        add(jTop, "North");
        jTop.setPreferredSize(new Dimension(1000, 100));

        add(jBottom, "South");
        jBottom.setPreferredSize(new Dimension(1000, 100));

        add(jCenter, BorderLayout.CENTER);
        jCenter.setLayout(new GridLayout(4, 4, 130, 40)); // GridLayout(4,4) 지정


    }

    //버튼 생성
    private void initButton() {
        cardButtons = new JButton[BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            cardButtons[i] = new JButton("");
            jCenter.add(cardButtons[i]);

            cardButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //누르면 인덱스 출력
                    clickedCardIndex = IndexOfClickedCard(e.getSource());
                    //눌르면 앞 장 보여라
                    //showFrontImage();
                    showClickFrontImage(clickedCardIndex);
                    settingFirstnSecondCardMonth();
                    compareCard();
                }

            });
        }
    }

    //카드의 인덱스를 리턴한다.
    private int IndexOfClickedCard(Object source) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (source.equals(cardButtons[i])) {
                return i;
            }
        }
        return -1;
    }

    //    public void update() {
//        repaint();
//    }
//
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, this);
        //g.drawImage(cImage, 200, 200, this);

    }

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



    //뒷장 그림을 버튼에 저장
    //TODO: 이거 1장 출력하는 함수 분리해야함
    private void showBackImage() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < BOARD_SIZE; i++) {
                    ImageIcon imageIcon = getCardImage(0); //뒷장
                    cardButtons[i].setIcon(imageIcon);
                }
            }
        };

        timer.schedule(timerTask,2500);

    }

    private void showOneBackImage(int index) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                ImageIcon imageIcon = getCardImage(0); //뒷장
                cardButtons[index].setIcon(imageIcon);
            }
        };
        timer.schedule(timerTask,500);

    }

    private void showFrontImage() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < BOARD_SIZE; i++) {
                    int month = cardDeck.getCards().get(i).getMonth(); //TODO:이렇게하면 안된다고 들었음
                    ImageIcon imageIcon = getCardImage(month); //월 그림 출력
                    cardButtons[i].setIcon(imageIcon);
                }
            }
        };

        timer.schedule(timerTask,20);



    }

    private int getMonth(int cardIndex){
        return cardDeck.getCards().get(cardIndex).getMonth(); //TODO:이렇게하면 안된다고 들었음
    }

    private void showClickFrontImage(int index) {
        clickedCardMonth = getMonth(index);
        ImageIcon imageIcon = getCardImage(clickedCardMonth); //월 그림 출력
        cardButtons[index].setIcon(imageIcon);

        System.out.println("선택한카드의 달: " + clickedCardMonth); //TODO:지우기
    }


//    private void showOneFrontImage(){
//        int month = cardDeck.getCards().get(i).getMonth(); //TODO:이렇게하면 안된다고 들었음
//        ImageIcon imageIcon = getCardImage(month); //월 그림 출력
//        cardButtons[i].setIcon(imageIcon);
//
//    }

    //월 그림 출력
    public ImageIcon getCardImage(int month) {
        String path = "./src/FinalMission/image/CardImage/";
        String name = Integer.toString(month);
        String ext = ".png";

        ImageIcon imageIcon = new ImageIcon(path + name + ext);

        return imageIcon;
    }


    //첫번째버튼, 두번째버튼 같으면 true, 다르면 false
    private void compareCard(){
        if(FirstCard != null && SecondCard != null){
            System.out.println("첫번째 달, 두번째달: "+ FirstCard.getMonth() + ", " + SecondCard.getMonth());
            if (FirstCard.getMonth() != SecondCard.getMonth()) {
                System.out.println("카드 다름!");
                showOneBackImage(FirstCardIndex);
                showOneBackImage(SecondCardIndex);
            }
            else{
                System.out.println("카드 같음!");
            }
            //초기화
            FirstCard = null;
            SecondCard = null;
        }
        System.out.println("아직 선택 다 안함");
    }

    private void settingFirstnSecondCardMonth(){ //TODO:변수명 바꾸기
        if(FirstCard == null){
            FirstCard = cardDeck.getCards().get(clickedCardIndex);
            FirstCardIndex = clickedCardIndex;
        }else if(SecondCard == null){
            SecondCard = cardDeck.getCards().get(clickedCardIndex);
            SecondCardIndex = clickedCardIndex;
        }

    }


}