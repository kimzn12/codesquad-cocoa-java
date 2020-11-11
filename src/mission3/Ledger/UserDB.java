package mission3.Ledger;

import java.util.LinkedList;

public class UserDB {
    public static LinkedList<User> userDatabase = new LinkedList<>();

    /*
        UserDB의 0번째를 default값을 user로 설정해두고 고정해두고 싶다.
        이렇게 하는게 맞는지 모르겠다.
     */
    public static void init(){
        User initUser = new User();
        userDatabase.clear();
        userDatabase.add(0,initUser);
    }

}
