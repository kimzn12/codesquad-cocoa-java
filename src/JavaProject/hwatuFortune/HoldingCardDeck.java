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
    }

    //플레이어에게 카드 주기
    public Card getCard(){
        //여기서 혹시 nullpointer오류날수도 있음.
        return holdingCardQueue.poll();
    }
}
