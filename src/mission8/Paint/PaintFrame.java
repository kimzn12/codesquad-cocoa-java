package mission8.Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintFrame extends JFrame {
    public int startX, startY, endX, endY;

    JRadioButton rLine;
    JRadioButton rOval;
    JRadioButton rRect;
    JRadioButton rFreeLine;

    boolean drawLine = false;
    boolean drawOval = false;
    boolean drawRect = false;
    boolean drawFreeLine = false;

    public PaintFrame(String title) {
        //윈도우 설정
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //닫힘
        setSize(1200, 1200);
        setLayout(new FlowLayout());

        rFreeLine = new JRadioButton("연필");
        rLine = new JRadioButton("직선");
        rOval = new JRadioButton("원");
        rRect = new JRadioButton("사각형");

        //라디오버튼 생성
        makeRadioButton();

        //이벤트 리스너 추가
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());

        setVisible(true);
    }

    //라디오 버튼 생성,리스너추가
    public void makeRadioButton() {
        rFreeLine = new JRadioButton("연필");
        rLine = new JRadioButton("직선");
        rOval = new JRadioButton("원");
        rRect = new JRadioButton("사각형");

        //버튼 중 하나만 선택
        ButtonGroup bg = new ButtonGroup();
        bg.add(rFreeLine);
        bg.add(rLine);
        bg.add(rOval);
        bg.add(rRect);


        //프레임에 버튼 추가
        add(rFreeLine);
        add(rLine);
        add(rOval);
        add(rRect);

        //리스너 등록
        rOval.addActionListener(e -> drawOval = true);
        rLine.addActionListener(e -> drawLine = true);
        rRect.addActionListener(e -> drawRect = true);
        rFreeLine.addActionListener(e -> drawFreeLine = true);
    }

    //내부 클래스로 리스너 구현
    class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("pressed");
            startX = e.getX();
            startY = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Released");
            endX = e.getX();
            endY = e.getY();
            repaint();
        }

    }

    class MyMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

            startX = e.getX();
            startY = e.getY();
            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);

        if (drawFreeLine) {
            g.drawString("●", startX, startY);
        }

        //직선
        if (drawLine) {
            g.drawLine(startX, startY, endX, endY);
        }

        //사각형
        if (drawRect) {
            g.drawRect(startX, startY, endX - startX, endY - startY);
        }

        //원
        if (drawOval) {
            g.drawOval(startX, startY, endX - startX, endY - startY);
        }
    }

    public void update(Graphics g){
        //update는 이전 영역을 지우고 다시 그림을 그려주는데
        //지우는 영역을 작성해주지 않았다. 따라서, 그린 그림이 그대로 남아있다.
        //g.clearRect(0, 0, 1200, 1200); //화면지우는코드
        paint(g);
    }
}


