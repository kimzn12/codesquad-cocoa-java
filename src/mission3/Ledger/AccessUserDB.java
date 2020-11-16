package mission3.Ledger;

public class AccessUserDB {

    //유저생성
    public static void createUser(String name, String password) { //어차피 userdb는 하나니까
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        UserDB.userDatabase.add(user);

        System.out.println(UserDB.userDatabase.get(1).getName()); // 잘 들어갔는지 확인
    }

    // 읽어오기
    public static User readUser(String name, String password) {
        int idx = 0;
        //여기다가 if문 사용. UserDB에서 get 0 --> 0에 값이 없으면 null 리턴.
        for (User user : UserDB.userDatabase) {
            if (user.getName().equals(name)) {
                if (user.getPassword().equals(password)) {
                    idx = UserDB.userDatabase.indexOf(user);
                    return UserDB.userDatabase.get(idx);
                }
            }
        }
        return UserDB.userDatabase.get(idx); // 없으면 idx0유저 반환
    }
}
