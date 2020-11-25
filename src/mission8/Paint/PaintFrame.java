package mission8.Paint;

import javax.swing.*;
import java.awt.*;

public class PaintFrame extends JFrame {
    public PaintFrame(String title){
        //윈도우 설정
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200,1200);
        setTitle(title);

        //패널 생성
        Component pane = getContentPane();
        pane.setBackground(Color.WHITE);

        setVisible(true);
    }

}
