package mission3.Ledger;


/*
    간단한 가계부를 구현한다.
    키보드를 통해 데이터 입력을 받고 화면에 내용을 출력한다.
    사용자 등록: 사용자 이름 및 비밀번호를 입력받는다.
    데이터 입력: 날짜, 적요, 수입, 지출을 입력받는다.
    데이터 삭제: 특정 순번의 데이터를 삭제한다.
    데이터 수정: 특정 순번의 데이터를 수정할 수 있다.
    화면에 출력: 해당 월의 지출내역을 순번, 적요, 수입, 지출, 잔액으로 화면에 출력한다.
 */
public class Ledger {
    public static boolean isLogin;
    public static User user;

    // UserDB 초기화
    public static void initUserDB(){
        UserDB.init();
    }

    // RecordDB 초기화
    public static void initRecordDB(){
        RecordDB.init();
    }

    // 로그인 확인
    public static void checkLogin(){
        //로그인이 됬나? 됬으면 User 저장하기
        isLogin = false;

        User initUser = new User();
        user = UserFunction.signIn();

        if (user.equals(initUser)) {
            return;
        }
        isLogin = true;
    }




    public static void main(String[] args){
        initUserDB();
        initRecordDB();
        
        UserFunction.singUp();
        UserFunction.singUp();

        checkLogin();
        while(isLogin){
            LoginUserFunction.write(user);
            LoginUserFunction.read(user);

            isLogin = LoginUserFunction.signOut();
        }






    }
}
