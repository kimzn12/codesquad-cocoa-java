package JavaProject.hwatuFortune;

import java.util.*;

public class CardDeck {
    private static final int Month = 12; //12월까지
    private static final int Card_Number = 4; //1달에 카드 4개

    private List<Card> cards = new ArrayList<>(); //card를 담은 cards리스트

    // holdingCardList, mainCardList
    // 이렇게 해도 되나?
    private List<Card> holdingCardList;
    private List<Card> mainCardList;


    //48개 카드 생성
    public CardDeck(){
        createCards();
        shuffleCards();

        createMainCardList();
        createHoldingCardList();
    }


    //mainCardList에 20개 카드 , holdingCard에 28개 카드 주기
    public List<Card> getMainCardList(){
        return mainCardList;
    }

    public List<Card> getHoldingCardList(){
        return holdingCardList;
    }

    //48개 카드 생성
    private void createCards(){
        for(int i = 1; i <= Month; i++){
            for(int j = 1; j <= Card_Number; j++){
                Card card = new Card();
                card.setMonth(i);
                card.setCardNumber(j);
                cards.add(card);
            }
        }
    }

    //카드 섞기
    private void shuffleCards(){
        Collections.shuffle(cards);
    }

    //maincardlist 생성
    private void createMainCardList(){
        mainCardList  = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            mainCardList.add(cards.get(i));
        }
    }

    //holdingcardlist 생성
    private void createHoldingCardList(){
        holdingCardList  = new ArrayList<>();

        for(int i = 20; i < cards.size(); i++){
            holdingCardList.add(cards.get(i));
        }

    }

}
