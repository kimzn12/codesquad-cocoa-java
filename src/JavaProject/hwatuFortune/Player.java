package JavaProject.hwatuFortune;

import java.util.List;

public class Player {
    public Card drawnCard;
    private Card[] pairedCard;

    public Player(){
        this.pairedCard = new Card[2];
    }


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

    // 선택한 카드 짝이 맞는지 확인


    //짝이 맞춰진 카드들 paired card에 놓기
    private void putPairedCards(PairedCardDeck pairedCardDeck) {
        pairedCardDeck.addPairedCard(pairedCard);
    }

}
