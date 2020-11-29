package JavaProject.hwatuFortune;

import java.util.List;

public class Player {
    public Card drawnCard;


    //holding card deck에서 카드 뽑기
    public void drawCard(HoldingCardDeck holdingCardDeck){
        drawnCard = holdingCardDeck.getCard();
    }

    //뽑은 카드 drawn card list에 내려 놓기
    public Card getHoldingCard() {
        System.out.println("플레이어가 뽑은 카드: " + drawnCard.getMonth());
        return drawnCard;
    }

    // 카드 선택 (다른 리스트에서)

}
