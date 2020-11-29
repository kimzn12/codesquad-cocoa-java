package JavaProject.hwatuFortune;

public class Game {

    public void play(){
        System.out.println("Game start!");

        CardDeck cardDeck = new CardDeck();
        Player player = new Player();
        HoldingCardDeck holdingCardDeck = new HoldingCardDeck(cardDeck);
        DrawnCardDeck drawnCardDeck = new DrawnCardDeck();

        /*
            //holdingcardDeck, DrawnCardDeck확인

            player.drawCard(holdingCardDeck);
            drawnCardDeck.putCard(player);
        */

    }

    private void PlayerProcess(){
        //TODO:
    }

}
