package JavaProject.hwatuFortune;

public class Card {
    private int month;
    private int cardNumber;

    public Card(int month, int cardNumber){
        this.month = month;
        this.cardNumber = cardNumber;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
}

