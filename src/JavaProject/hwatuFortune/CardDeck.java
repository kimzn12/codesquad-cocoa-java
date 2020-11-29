package JavaProject.hwatuFortune;

import java.util.*;

public class CardDeck {
    private static final int Month = 12; //12월까지
    private static final int Card_Number = 4; //1달에 카드 4개

    public static List<Card> cards; //card를 담은 cards리스트

    // holdingCardList, mainCardList
    // TODO::이렇게 해도 되나?
    private List<Card> holdingCardList;
    private List<Card> mainCardList;


    //48개 카드 생성
    public CardDeck() {
        createCards();
        shuffleCards();

        //TODO:생성자에서 이걸 가지고 있어야 하나...
    }

    //48개 카드 생성
    private void createCards() {
        cards = new ArrayList<>();
        for (int month = 1; month <= Month; month++) {
            for (int cardNumber = 1; cardNumber <= Card_Number; cardNumber++) {
                Card card = new Card(month, cardNumber);
                cards.add(card);
            }
        }
    }


    //카드 섞기
    private void shuffleCards() {
        Collections.shuffle(cards);
    }
    //mainCardList에 20개 카드 , holdingCard에 28개 카드 주기

    //maincardlist 생성
    public List<Card> getMainCardList() {
        mainCardList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            mainCardList.add(cards.get(i));
        }
        return mainCardList;
    }

    //holdingcardlist 생성
    public List<Card> getHoldingCardList() {
        holdingCardList = new LinkedList<>();

        for (int i = 20; i < cards.size(); i++) {
            holdingCardList.add(cards.get(i));
        }
        return holdingCardList;
    }

}
