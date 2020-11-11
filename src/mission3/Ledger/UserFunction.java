package mission3.Ledger;

import java.util.*;

public class UserFunction {
    public static String username;

    public static void singUp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("              회원가입               ");
        System.out.println("===================================");
        System.out.println(" @ 이름을 입력하세요: ");
        String name = sc.next();
        System.out.println(" @ 비밀번호를 입력하세요: ");
        String password = sc.next();

        AccessUserDB.createUser(name,password);
    }

    public static User signIn() {
        User user;

        Scanner sc = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("               로그인               ");
        System.out.println("===================================");
        System.out.println(" @ 이름을 입력하세요: ");
        String name2 = sc.next();
        System.out.println(" @ 비밀번호를 입력하세요: ");
        String password2 = sc.next();

        if (AccessUserDB.readUser(name2,password2) == UserDB.userDatabase.get(0)){
            System.out.println("+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+");
            System.out.println("        로그인에 실패하였습니다.      ");
            System.out.println("  아이디나 비밀번호를 다시 확인해주세요.");
            System.out.println("+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+");
            singUp();
        }
        System.out.println("+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+");
        System.out.println("      로그인에 성공하였습니다.     ");
        System.out.printf("      %s님 환영합니다  ~.~!!!   \n",AccessUserDB.readUser(name2,password2).getName());
        System.out.println("+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+ㅡㅡ+");

        user = AccessUserDB.readUser(name2,password2);

        return user;
    }

}
