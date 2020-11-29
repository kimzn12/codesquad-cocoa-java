/*
    메인으로 세팅해두는 카드들
 */

package JavaProject.hwatuFortune;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainCardDeck {
    private ArrayList<Stack<Card>> board = new ArrayList<>();
    private static final int SIZE = 5;
    private boolean isFront = false;

    public MainCardDeck(CardDeck cardDeck) {
        createBoard(cardDeck);
    }


    private void createBoard(CardDeck cardDeck) { //4*5
        //stack 4개 만들기
        for (int i = 0; i < 4; i++) {
            Stack<Card> line = new Stack<>();
            board.add(line);
        }

        // 20개 카드 받아오기
        List<Card> mainCardList = cardDeck.getMainCardList(); //TODO: 바꾸기

        //1차원 리스트 >> 2차원 리스트
        for (int i = 0; i < mainCardList.size(); i++) {
            int column = i / SIZE;

            switch (column) {
                case 0:
                    board.get(0).push(mainCardList.get(i));
                    //line1.push(mainCardList.get(i));
                    break;
                case 1:
                    board.get(1).push(mainCardList.get(i));
                    //line2.push(mainCardList.get(i));
                    break;
                case 2:
                    board.get(2).push(mainCardList.get(i));
                    //line3.push(mainCardList.get(i));
                    break;
                case 3:
                    board.get(3).push(mainCardList.get(i));
                    //line4.push(mainCardList.get(i));
                    break;
            }
        }
    }

    //카드 선택
    //플레이어가 카드 선택하게하기
    public Card selectCard(int column) { //열(column)
        Stack<Card> line = board.get(column);
        return line.peek(); // 마지막 인덱스의 카드 조회
    }

    //카드 뽑기
    public void popCard(int column) { //선택한 열의 카드 뽑기
        //TODO: 만약 짝이 맞다면 실행 (다른 클래스(rule)에서 조건 확인)
        Stack<Card> line = board.get(column);
        line.pop();
//        for (Card c : line) {
//            System.out.println(c.getMonth() + " " + c.getCardNumber());
//        }
    }

    //카드 뒤집기
    private void openCard(){
        //마지막 카드모음
        Card[] lastCards = new Card[4];
        for(int i = 0; i < board.size(); i++){
            lastCards[i] = board.get(i).peek();
        }
        //TODO: 마지막 카드이면 앞 면을 보여야함.
    }


}
