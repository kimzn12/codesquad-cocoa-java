package JavaProject.hwatuFortune;

import java.util.ArrayList;

public class PairedCardDeck {
    private static final int SIZE = 4;
    private ArrayList<Card>[] pairedCards; //TODO: 이렇게 해도 되나?
    private int currentIndex; //저장할 인덱스 위치

    public PairedCardDeck(){
        pairedCards = new ArrayList[SIZE];
        currentIndex = 0;
    }

    //짝이 맞추어진 카드 저장, player가 사용
    public void addPairedCard(Card[] pairedCard){
        for(Card card: pairedCard){
            pairedCards[currentIndex].add(card);
        }
        //인덱스 값 바꾸기 : 0 ~ 3
        currentIndex++;
        currentIndex %= SIZE;
    }



}
