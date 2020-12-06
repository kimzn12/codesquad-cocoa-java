package FinalMission.FindSamePicture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GameWindow extends JFrame {
    private static final int BOARD_SIZE = 16;

    private JPanel jLeft;
    private JPanel jRight;
    private JPanel jTop;
    private JPanel jBottom;
    private JPanel jCenter; //메인패널

    private BufferedImage background;

    private CardDeck cardDeck = new CardDeck(); //TODO: 이거 분리하고 싶었음

    private JButton[] cardButtons;

    private Card FirstCard = null;
    private Card SecondCard = null;
    //클릭한 카드 달
    private int clickedCardMonth = 0;
    private int clickedCardIndex;
    private int FirstCardIndex;
    private int SecondCardIndex;


    public GameWindow() {
        loadBackgroundImage();
        initFrame();
        initPanel();
        initButton();
        showFrontOfEveryCard();
        showBackOfEveryCard();
        setVisible(true);

    }

    //background 이미지 로드
    private void loadBackgroundImage() {
        try {
            File f = new File("./");
            System.out.println(f.getAbsolutePath());
            background = ImageIO.read(new File("./src/FinalMission/image/background2.png"));
        } catch (IOException e) {
            System.exit(1); //1은 무슨 의미인가?
        }
    }

    //Frame 초기화
    private void initFrame() {
        //Frame 설정
        setTitle("Fine Same Picture");
        setSize(background.getWidth(), background.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); //사이즈 조절 안됨
        setLocationRelativeTo(null); //가운데 창 생성
    }

    //Panel 초기화
    private void initPanel() {
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
                    clickedCardIndex = IndexOfClickedButton(e.getSource()); //여기 다시공부
                    //내가 누른 버튼의 카드
                    Card clickedCard = getCardOfClickedButton(clickedCardIndex);
                    System.out.println("내가 누른 카드: " + clickedCard.toString() + ", 카드 닫혀있나?: " + clickedCard.isClose);

                    //뒷 면일 경우만 반응
                    if (clickedCard.isClose) {
                        showFrontOfClickedCard(clickedCardIndex, clickedCard);
                        settingFirstnSecondCardMonth();
                        compareCard();
                    }

                    //게임 끝났을 경우, clear 로그 메세지
                    if (checkGameClear()) {
                        JLabel label = new JLabel("@♪(*^ㅡ^*)♪♪ Clear!!♪");
                        Font font = new Font("Verdana", Font.BOLD, 70);
                        label.setFont(font);
                        JOptionPane.showMessageDialog(jCenter.getComponent(6), label);
                        System.exit(0);
                    }

                }

            });
        }
    }

    //클릭한 버튼의 인덱스를 리턴한다.
    private int IndexOfClickedButton(Object source) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (source.equals(cardButtons[i])) {
                return i;
            }
        }
        return -1;
    }


    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, this);
    }


    //전체 카드 뒷장 이미지 보이기
    private void showBackOfEveryCard() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < BOARD_SIZE; i++) {
                    showBackOfOneCard(i);
                }
            }
        };
        timer.schedule(timerTask, 1000 * 2);
    }

    //카드 한 장만 뒷장 이미지 보이기
    private void showBackOfOneCard(int index) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                ImageIcon imageIcon = getCardImage(0); //뒷장
                cardButtons[index].setIcon(imageIcon);
            }
        };
        timer.schedule(timerTask, 500);

    }

    private void showFrontOfEveryCard() {
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
        timer.schedule(timerTask, 20);
    }

    //클릭한 카드의 앞 면 보이기
    private void showFrontOfClickedCard(int index, Card card) {
        card.isClose = false; // 카드 열림
        clickedCardMonth = getMonth(index);
        ImageIcon imageIcon = getCardImage(clickedCardMonth); //월 그림 출력
        cardButtons[index].setIcon(imageIcon);
    }

    //클릭한 버튼의 카드를 리턴한다.
    private Card getCardOfClickedButton(int cardIndex) {
        Card cardOfClickedButton = cardDeck.getCards().get(cardIndex);

        return cardOfClickedButton;
    }

    private int getMonth(int cardIndex) {
        Card card = getCardOfClickedButton(cardIndex);
        return card.getMonth();
    }


    private boolean checkGameClear() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (cardDeck.getCards().get(i).isClose) {
                return false;
            }
        }
        return true;
    }


    //월 그림 출력
    private ImageIcon getCardImage(int month) {
        String path = "./src/FinalMission/image/CardImage/";
        String name = Integer.toString(month);
        String ext = ".png";

        ImageIcon imageIcon = new ImageIcon(path + name + ext);

        return imageIcon;
    }


    //첫번째버튼, 두번째버튼 같으면 true, 다르면 false
    private void compareCard() {
        if (FirstCard != null && SecondCard != null) {
            System.out.println("첫번째 달, 두번째달: " + FirstCard.getMonth() + ", " + SecondCard.getMonth());
            if (FirstCard.getMonth() != SecondCard.getMonth()) {
                System.out.println("카드 다름!");
                showBackOfOneCard(FirstCardIndex);
                FirstCard.isClose = true;
                showBackOfOneCard(SecondCardIndex);
                SecondCard.isClose = true;
            } else {
                System.out.println("카드 같음!");
            }
            //초기화
            FirstCard = null;
            SecondCard = null;

        }

    }

    private void settingFirstnSecondCardMonth() { //TODO:변수명 바꾸기
        if (FirstCard == null) {
            FirstCard = cardDeck.getCards().get(clickedCardIndex);
            FirstCardIndex = clickedCardIndex;
        } else if (SecondCard == null) {
            SecondCard = cardDeck.getCards().get(clickedCardIndex);
            SecondCardIndex = clickedCardIndex;
        }

    }


}