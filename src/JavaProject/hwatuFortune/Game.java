package JavaProject.hwatuFortune;

public class Game {

    public void play(){
        System.out.println("Game start!");

        CardDeck cardDeck = new CardDeck();
//        Player player = new Player();
//        Rule rule = new Rule();
  //      MainCardDeck mainCardDeck = new MainCardDeck(cardDeck);
        HoldingCardDeck holdingCardDeck = new HoldingCardDeck(cardDeck);
        holdingCardDeck.getCard();

    }
}
