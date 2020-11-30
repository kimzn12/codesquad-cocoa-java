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

    //카드 선택해서 paired에 넣기 ,좀 이상함
    public void selectPairedCard(Rule rule, MainCardDeck mainCardDeck,int column,DrawnCardDeck drawnCardDeck,PairedCardDeck pairedCardDeck){
        Card card1 = mainCardDeck.selectMainCard(column);
        Card card2 = drawnCardDeck.selectDrawnCard();
        rule.putPairedCards(pairedCardDeck,card1,card2);
        //카드 제거
        mainCardDeck.popCard(column);
        drawnCardDeck.popCard();
    }




}
