/*
    메인으로 세팅해두는 카드들
 */

package JavaProject.hwatuFortune;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainCardDeck {
    private Stack<Card> line = new Stack<>(); //카드 나열 // TODO:변수명 바꾸면 좋을 듯
    CardDeck cardDeck = new CardDeck(); //TODO: cardDeck을 알 필요가 없으니 이렇게 하면 안될듯.



    public MainCardDeck(){
        createLine();
        System.out.println();
        popCard();
    }

    //플레이어가 카드 선택하게하기

    private void createLine(){
        List<Card> mainCardList = this.cardDeck.getMainCardList(); //TODO: 바꾸기
        for(int i = 0; i < 4; i++){
            line.push(mainCardList.get(i));
        }
        for (Card c: line){
            System.out.println(c.getMonth() + " " + c.getCardNumber());
        }

    }

    //카드 선택
    public Card selectCard(){
        return line.get(line.size()-1); // 마지막 인덱스의 카드
    }

    //카드 뽑기
    private void popCard(){
        //TODO: 만약 짝이 맞다면... (다른 클래스(rule)에서 조건 확인)
        line.pop();
        for (Card c: line){
            System.out.println(c.getMonth() + " " + c.getCardNumber());
        }
    }



}
