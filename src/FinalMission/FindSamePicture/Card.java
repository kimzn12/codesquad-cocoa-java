package FinalMission.FindSamePicture;

public class Card {
    private int month;
    private int cardNumber;
    private boolean isOpen;

    public Card(int month, int cardNumber){
        this.month = month;
        this.cardNumber = cardNumber;
        this.isOpen = false;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString(){
        return "Card<월: " + month + ", 번호: " + cardNumber + ">";
    }
}
