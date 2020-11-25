package mission8.Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintFrame extends JFrame {
    private int startX, startY, endX, endY;

    private boolean drawLine = false;
    private boolean drawOval = false;
    private boolean drawRect = false;
    private boolean drawFreeLine = false;
    private boolean clear = true;

    Button bFreeLine = new Button("Pencil");
    Button bLine = new Button("Line");
    Button bOval = new Button("circle");
    Button bRect = new Button("Rectangle");
    Button bClear = new Button("clear");

    JPanel panel = new JPanel(new FlowLayout());

    public PaintFrame(String title) {
        //윈도우 설정
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //닫힘
        setSize(1200, 1200);
        setLayout(new BorderLayout());

        //버튼
        makeButton();

        //이벤트 리스너 추가
        addMyListener();

        setVisible(true);
    }

    //라디오 버튼 추가,리스너 등록
    public void makeButton() {
        //리스너 등록
        bOval.addActionListener(e -> {
            drawOval = true;
            drawLine = false;
            drawFreeLine = false;
            drawRect = false;
            clear = false;

        });

        bRect.addActionListener(e -> {
            drawOval = false;
            drawLine = false;
            drawFreeLine = false;
            drawRect = true;
            clear = false;

        });

        bLine.addActionListener(e -> {
            drawOval = false;
            drawLine = true;
            drawFreeLine = false;
            drawRect = false;
            clear = false;
        });

        bFreeLine.addActionListener(e -> {
            drawOval = false;
            drawLine = false;
            drawFreeLine = true;
            drawRect = false;
            clear = false;
        });

        bClear.addActionListener(e -> {
            drawOval = false;
            drawLine = false;
            drawFreeLine = false;
            drawRect = false;
            clear = true;
        });

        panel.add(bFreeLine);
        panel.add(bLine);
        panel.add(bOval);
        panel.add(bRect);
        panel.add(bClear);

        add("North", panel);

    }

    public void addMyListener(){
        addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               super.mouseDragged(e); //?
               if(drawFreeLine){
                   startX = e.getX();
                   startY = e.getY();
                   repaint();
               }
           }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
        });

    }



    public void paint(Graphics g) {

        g.setColor(Color.BLACK);

        //화면 지우기
        if(clear){
            g.clearRect(0, 0, 1200, 1200); //화면지우는코드
        }

        //연필
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


