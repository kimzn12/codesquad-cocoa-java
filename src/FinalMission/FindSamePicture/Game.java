package FinalMission.FindSamePicture;

public class Game {
    GameWindow gameWindow = new GameWindow();

    CardDeck cardDeck = new CardDeck();

    public void play(){
        gameWindow.setVisible(true);
        gameWindow.start();
    }
}
