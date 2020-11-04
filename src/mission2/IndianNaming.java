/*
<인디언식 이름 짓기>
◇ 태어난 년도 뒷자리
***0년생:시끄러운, 말 많은
***1년생:푸른
***2년생:어두운 →적색
***3년생:조용한
***4년생:웅크린
***5년생:백색
***6년생:지혜로운
***7년생:용감한
***8년생:날카로운
***9년생:욕심 많은

◇ 자신의 생월
1월:늑대
2월:태양
3월:양
4월:매
5월:황소
6월:불꽃
7월:나무
8월:달빛
9월:말
10월:돼지
11월:하늘
12월:바람

◇ 자신의 생일
1일:~와(과) 함께 춤을
2일:~의 기상
3일:~은(는) 그림자 속에
4일:따로 붙는 말이 없음
5일:따로 붙는 말이 없음
6일:따로 붙는 말이 없음
7일:~의 환생
8일:~의 죽음
9일:~아래에서
10일:~을(를) 보라.
11일:~이(가) 노래하다.
12일:~의 그늘 → 그림자
13일:~의 일격
14일:~에게 쫒기는 남자
15일:~의 행진
16일:~의 왕
17일:~의 유령
18일:~을 죽인 자.
19일:~은(는) 맨날 잠잔다.
20일:~처럼..
21일:~의 고향
22일:~의 전사
23일:~은(는) 나의 친구
24일:~의 노래
25일:~의 정령
26일:~의 파수꾼
27일:~의 악마
28일:~와(과) 같은 사나이
29일:~의 심판자→을(를) 쓰러뜨린 자
30일:~의 혼
31일:~은(는) 말이 없다.


 */
package mission2;

import java.util.Scanner;

public class IndianNaming {
    public int year;
    public int month;
    public int day;

    //입력받기
    public void init(){
        Scanner sc = new Scanner(System.in);
        System.out.println("생일을 입력하시오:");
        this.year = sc.nextInt();
        this.month = sc.nextInt();
        this.day = sc.nextInt();
        sc.close();
    }

    //연도 함수
    public void yearNaming(int num){
        String[] yearnames = {"시끄러운","푸른","어두운","조용한","웅크린","백색","지혜로운","용감한","날카로운","욕심많은"};
        int end = num%10;


        System.out.print(yearnames[end]+ " ");
    }
    //달 함수
    public void monthNaming(int num){
        String[] monthnames = {"","늑대","태양","양","매","황소","불꽃","나무","달빛","말10","돼지","하늘","바람"};

        System.out.print(monthnames[num]);
    }

    //날 함수
    public void dayNaming(int num){
        String[] daynames = {"", "와(과) 함께 춤을", "의 기상", "은(는) 그림자 속에", "", "", "", "의 환생", "의 죽음", "아래에서", "을(를) 보라.", "이(가) 노래하다.", "의 그림자", "의 일격", "에게 쫒기는 남자", "의 행진", "의 왕", "의 유령", "을 죽인 자.", "은(는) 맨날 잠잔다.", "처럼..", "의 고향", "의 전사", "은(는) 나의 친구", "의 노래", "의 정령", "의 파수꾼", "의 악마", "와(과) 같은 사나이", "을(를) 쓰러뜨린 자", "의 혼", "은(는) 말이 없다."};

        System.out.print(daynames[num]);
    }

    //출력
    public void printName(){
        yearNaming(this.year);
        monthNaming(this.month);
        dayNaming(this.day);
    }

   //메인문
    public static void main(String[] args){
        IndianNaming indianName = new IndianNaming();
        indianName.init();
        indianName.printName();
    }

}
