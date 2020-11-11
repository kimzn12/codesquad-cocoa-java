package mission3.Ledger;

public class Record {
    private String username;
    private String date;
    private String context;
    private int income;
    private int spending;

    public Record() {
        User iniUuser = new User();
        this.username = iniUuser.getName();
        this.date = "9999-99-99";
        this.context = "!@4rfdmoca";
        this.income = 999999;
        this.spending = 9999999;
    }

    public void setUsername(String username) { this.username = username; }

    public String getUsername(){ return this.username; }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return this.date;
    }

    public void setContext(String context){
        this.context = context;
    }

    public String getContext(){
        return this.context;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getIncome(){
        return this.income;
    }

    public void setSpending(int spending){
        this.spending = spending;
    }

    public int getSpending(){
        return this.spending;
    }

}
