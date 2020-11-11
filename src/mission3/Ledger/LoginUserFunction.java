package mission3.Ledger;

import java.util.Scanner;

public class LoginUserFunction {
    //가계부 입력
    public static void write(User user){
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("             가계부 작성             ");
        System.out.println("===================================");
        System.out.println(" @ 날짜를 입력하세요(0000-00-00): ");
        String date = sc.next();
        System.out.println(" @ 적요를 입력하세요: ");
        String context = sc.next();
        System.out.println(" @ 수입을 입력하세요: ");
        int income = sc.nextInt();
        System.out.println(" @ 지출을 입력하세요: ");
        int spending = sc.nextInt();

        AccessRecordDB.createRecord(user.getName(), date,context,income,spending);
    }

    //가계부 읽기
    public static void read(User user){
        System.out.println("===============================================================");
        System.out.printf("                       *%5s의 가계부*\n",user.getName());
        System.out.println("===============================================================");
        System.out.printf("%10s|%13s|%15s|%10s|%10s\n", "name","date", "context", "income", "spend");
        System.out.println();

        AccessRecordDB.getRecord(user);
    }

    //가계부 삭제
    public static void delete(){

    }
    //가계부 업데이트



    //회원탈퇴
    public static boolean leave(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("              회원탈퇴               ");
        System.out.println("===================================");
        System.out.println(" @ 이름을 입력하세요: ");
        String name = sc.next();
        System.out.println(" @ 비밀번호를 입력하세요: ");
        String password = sc.next();

        return false;
    }

    public static boolean signOut(){
        return false;
    }

}
