package JavaProject.hwatuFortune;

public class Rule {
    private Card[] pairedCard = new Card[2];

    //카드 짝 맞는지 확인
    private boolean checkPair(Card card1, Card card2){
        if(card1.getMonth() == card2.getMonth()){

            return true;
        }
        return false;
    }

    //pairedcard 생성
    private void createPairedCard(Card card1, Card card2){
        pairedCard[0] = card1;
        pairedCard[1] = card2;
    }


    //짝이 맞춰진 카드들 paired card에 놓기, 이거 player에서 사용
    public void putPairedCards(PairedCardDeck pairedCardDeck,Card card1, Card card2) {
        if(checkPair(card1,card2)){
            createPairedCard(card1,card2);
            pairedCardDeck.addPairedCard(pairedCard);

        }
    }


    public int getTodayCard(){
        //TODO: 월 반환
        return 0;
    }


}
