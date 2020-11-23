package mission6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class GameWindow extends JFrame implements KeyListener,Runnable { //KeyListener : 키보드 이벤트 처리, Runnable : 스레드
    int windowWidth = 800;
    int windowHeight = 1200;

    int direction = 1;

    //키보드입력 변수
    boolean KeyUp = false;
    boolean KeyDown = false;
    boolean KeyLeft = false;
    boolean KeyRight = false;

    Thread thread; // 스레드 생성

    Toolkit tk = Toolkit.getDefaultToolkit(); //이미지 불러오기 위한 툴킷

    Image backgroundImage = new ImageIcon(GameWindow.class.getResource("./image/background2.png")).getImage();
    Image playerImage1 = new ImageIcon(GameWindow.class.getResource("./image/Player1.png")).getImage(); //up
    Image playerImage2 = new ImageIcon(GameWindow.class.getResource("./image/Player2.png")).getImage(); //down
    Image playerImage3 = new ImageIcon(GameWindow.class.getResource("./image/Player3.png")).getImage(); //right
    Image playerImage4 = new ImageIcon(GameWindow.class.getResource("./image/Player4.png")).getImage(); //left

    Image bananaImage = new ImageIcon(GameWindow.class.getResource("./image/banana1.png")).getImage();
    Image coinImage = new ImageIcon(GameWindow.class.getResource("./image/coin1.png")).getImage();

    Player player = new Player();
    Banana banana;
    Coin coin;

    ArrayList coinList = new ArrayList();
    ArrayList bananaList = new ArrayList();

    //더블버퍼링
    Image buffImage; //buff에 그려질 이미지
    Graphics buffg; //그래픽 공간에서 그림을 그린후 한번에 화면에 출력

    Label score = new Label();
    Font font = new Font("Serif", Font.BOLD, 50);

    public GameWindow(String title){
        init();
        start();

        setTitle(title);
        setSize(windowWidth,windowHeight);
        setResizable(false); // 창 크기 고정

        //화면 중앙에 생성
        Dimension screenSize = tk.getScreenSize(); // 화면 크기 구하기
        setLocation((screenSize.width/2)-(windowWidth/2),(screenSize.height/2)-(windowHeight/2)); // 중앙에 생성

        score.setFont(font); //폰트 적용
        setLayout(new FlowLayout()); // ? 이거 안하면 화면에 score만 뜨고 나머지 안 뜸
        add(score);
        //score.setSize(500,500);

        setVisible(true);
    }

    public void init() {
        addCoinList(); // 코인 추가
        addBananaList();//바나나 추가
    }

    //시작 처리
    public void start(){
        //x표시 눌렀을 때 종료시키기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //키보드
        addKeyListener(this); //키보드 이벤트 실행
        thread= new Thread(this); //스레드 생성,실행
        thread.start();
    }



    public void paint(Graphics g){
        buffImage = createImage(windowWidth,windowHeight); // buffimage의 크기를 기본 크기와 같게 설정
        buffg = buffImage.getGraphics(); //그래픽 객체 얻기

        update(g); //메소드 반복적으로 실행?
    }

    public void update(Graphics g){
        // 0,0 에서 위에서 정한 해상도 크기만큼 화면을 지움
        // 이거 안하면 뒤에 창 겹쳐서 나옴.
        buffg.clearRect(0, 0, windowWidth, windowHeight);

        buffg.drawImage(backgroundImage, 0, 0, null);

        for(int i = 0; i < coinList.size(); i ++){
            System.out.println(coinList.size());
            coin = (Coin)coinList.get(i);
            buffg.drawImage(coinImage, coin.x, coin.y, this);
        }

        for(int i = 0; i < bananaList.size();i++){
            banana = (Banana)bananaList.get(i);
            buffg.drawImage(bananaImage, banana.x, banana.y, this);
        }

        if(direction == 1) buffg.drawImage(playerImage1, player.x, player.y, this);
        else if(direction == 2) buffg.drawImage(playerImage2, player.x, player.y, this);
        else if(direction == 3) buffg.drawImage(playerImage3, player.x, player.y, this);
        else if(direction == 4) buffg.drawImage(playerImage4, player.x, player.y, this);

        g.drawImage(buffImage,0,0,null); //화면에 buff에 그린 buffImage 가져옴

    }



    @Override
    public void keyTyped(KeyEvent e) { //키보드 타이핑될 때

    }

    @Override
    public void keyPressed(KeyEvent e) { // 키 눌렸을 때
        //방향키에 따라
        int KeyCode = e.getKeyCode();


        switch (KeyCode){
            case KeyEvent.VK_UP:
                KeyUp = true;
                direction = 1;
                break;
            case KeyEvent.VK_DOWN:
                KeyDown = true;
                direction = 2;
                break;
            case KeyEvent.VK_RIGHT:
                KeyRight = true;
                direction = 3;
                break;
            case KeyEvent.VK_LEFT:
                KeyLeft = true;
                direction = 4;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) { //키 떼어졌을 때
        int KeyCode = e.getKeyCode();

        switch (KeyCode){
            case KeyEvent.VK_UP:
                KeyUp = false;
                break;
            case KeyEvent.VK_DOWN:
                KeyDown = false;
                break;
            case KeyEvent.VK_RIGHT:
                KeyRight = false;
                break;
            case KeyEvent.VK_LEFT:
                KeyLeft = false;
                break;
        }
    }

    public void KeyProcess(){
//        int[] dx = {};
//        int[] dy = {};

        if(KeyUp) player.y -= 5;
        if(KeyDown) player.y += 5;
        if(KeyLeft)  player.x -= 5;
        if(KeyRight) player.x += 5;

    }

    public void updateLabel(){
        score.setText("Score : " + player.score);
    }

    //코인 생성 (분리하기)
    public void addCoinList(){
        for (int i = 0; i < 10; i++){
            coin = new Coin();
            coinList.add(coin);
        }
    }

    //바나나 리스트 생성 (분리하기)
    public void addBananaList(){
        for (int i = 0; i < 10; i++){
            banana = new Banana();
            bananaList.add(banana);
        }
    }


    public void coinProcess(){
        //코인 먹으면 코인 지우기
        for (int j = 0; j < coinList.size(); ++j){
            coin = (Coin) coinList.get(j);
            if(player.getCoin(coin)){
                coinList.remove(coin);
            }
        }
    }

    public void bananaProcess() {
        for(int i = 0; i < bananaList.size(); ++i){
            banana = (Banana) bananaList.get(i);
            if(player.stepOnBanana(banana)){
                bananaList.remove(banana);
            }
        }
    }


    @Override
    public void run() {
        try{
            while(true){
                KeyProcess();

                updateLabel();
                coinProcess();
                bananaProcess();

                //repaint() > update() > paint()
                repaint();

                Thread.sleep(20); // 왜 깜빡이누..
            }
        }
        catch (Exception e){

        }

    }



}
