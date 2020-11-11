package mission3.Ledger;

public class User {
    private String name;
    private String password;


    public User() {
        this.name = "12erfdg5!@#$%^";
        this.password = "@#$%IKfdswdf123";
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name; //? 그냥 name
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return this.password; // ? 그냥 password
    }

}
