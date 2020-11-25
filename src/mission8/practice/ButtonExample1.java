package mission8;

import javax.swing.*;
import java.awt.*;

public class ButtonExample1 extends JFrame {
    public static final long serialVersionUID = 1L; // 이거 이해안됨

    //생성자
    public ButtonExample1(String title){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setTitle(title);
        decorate();
        setVisible(true);
    }

    //패널 색상 지정
    public void decorate(){
        Component pane = getContentPane();
        pane.setBackground(Color.BLACK);
    }

    //버튼 추가
    public void addButton(){
        JButton button = new JButton("버튼!");
        add(button);
        setVisible(true); //버튼도 보여주기
    }

    public static void main(String[] args){

        ButtonExample1 ex = new ButtonExample1("hi button");

        //2초 후
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        //버튼 추가
        ex.addButton();

    }

}
