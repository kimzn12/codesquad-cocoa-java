/*
    뽑아서 바닥에 내려놓은 카드들
 */

package JavaProject.hwatuFortune;

import java.util.ArrayDeque;
import java.util.Deque;

public class DrawnCardDeck {
    private Deque<Card> drawCardList = new ArrayDeque<>();

    //카드 선택
    //왼쪽
    public Card selectLeftCard(){
        return drawCardList.peekFirst();
    }
    //오른쪽
    public Card selectRightCard(){
        return drawCardList.peekLast();
    }

    //TODO:카드 한 개일 경우

    //카드 뽑기
    //왼쪽
    public Card popLeftCard() {
        return drawCardList.pollFirst();
    }
    //오른쪽
    public Card popRightCard(){
        return drawCardList.pollLast();
    }

    // 플레이어에게 카드 받아서 리스트에 넣기
    //TODO: private로 바꾸기
    public void putCard(Player player){
        Card card = player.getHoldingCard();
        drawCardList.add(card);
        System.out.println("drawncardlist에 들어있는 카드: " + drawCardList.peekFirst().getMonth());
    }


}



