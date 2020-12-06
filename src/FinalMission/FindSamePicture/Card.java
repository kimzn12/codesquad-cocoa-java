package FinalMission.FindSamePicture;

public class Card {
    private int month;
    private int cardNumber;
    public boolean isClose;

    public Card(int month, int cardNumber){
        this.month = month;
        this.cardNumber = cardNumber;
        this.isClose = true;
    }

    public int getMonth() {
        return month;
    }


    @Override
    public String toString(){
        return "Card<월: " + month + ", 번호: " + cardNumber + ">";
    }

}
