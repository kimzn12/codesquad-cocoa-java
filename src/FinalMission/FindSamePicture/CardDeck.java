package FinalMission.FindSamePicture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private static final int MONTH = 8; //12월까지
    private static final int CARD_NUMBER = 2; //카드 2개
    private static final int BOARD_SIZE = 4;
    private List<Card> cards;
    public Card[][] board;


    public CardDeck() {
        cards = new ArrayList<>();
        board = new Card[BOARD_SIZE][BOARD_SIZE];

        createCards();
        shuffleCards();
        createBoard();
        printBoard();
    }

    public List<Card> getCards(){
        return cards;
    }

    private void createCards() {

        for (int month = 1; month <= MONTH; month++) {
            for (int cardNumber = 1; cardNumber <= CARD_NUMBER; cardNumber++) {
                Card card = new Card(month, cardNumber);
                cards.add(card);
            }
        }
    }


    //카드 섞기
    private void shuffleCards() {
        Collections.shuffle(cards);
    }

    private void createBoard() {
        for(int i  = 0; i < BOARD_SIZE; i++){
            for(int j = 0 ; j < BOARD_SIZE; j++){
                board[i][j] = cards.get((i * BOARD_SIZE) + j);
            }
        }
    }

    //보드 콘솔에 확인
    private void printBoard() {
        System.out.println("<<<< 보드 확인 >>>>");
        for(int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.printf("%3d", this.board[i][j].getMonth());
            }
            System.out.println();
        }
    }


    //카드 잘 들어갔나 확인
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Card card : cards){
            sb.append(card.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
