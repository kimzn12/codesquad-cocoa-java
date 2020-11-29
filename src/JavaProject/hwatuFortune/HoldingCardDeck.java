/*
    손에 들고 있는 카드들
 */

package JavaProject.hwatuFortune;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HoldingCardDeck {
    private Queue<Card> holdingCardQueue = new LinkedList<>();

    public HoldingCardDeck(CardDeck cardDeck){
        List<Card> holdingCardList = cardDeck.getHoldingCardList();
        holdingCardQueue.addAll(holdingCardList);
        System.out.println(holdingCardQueue.peek().getMonth());
    }

    //플레이어에게 카드 주기
    public Card getCard(){
        return holdingCardQueue.poll(); //index 0 반환하고 없애기

    }

}
