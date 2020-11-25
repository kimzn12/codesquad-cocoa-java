/*
몬스터 나오면 스코어 출력
몬스터 만나고 다음 판 넘어가기
(지뢰 수 늘리기, 초기화)
 */



package mission2;


import java.util.Scanner;
import java.util.Random; //랜덤함수 사용하기 위해서
// 자바 배열을 출력하기 위해 필수적으로 필요 import java.util.Arrays;

class Map {
    public String[][] map;

    //1. 맵 생성
    public void createMap() {
        this.map = new String[11][11]; //0~10까지 생성

        for (int x=0; x < 11; x++) {
            for (int y=0; y < 11; y++) {
                this.map[x][y] = ".";
            }
        }
    }

    //2. 맵 출력 - Q출력함수가 map에 있어야하는지 player.moster에 있어야하는지
    public void printMap(Player p, Monster m, Mine mine){
        this.map[p.playerX][p.playerY] = "\uD83C\uDFC3";
        this.map[m.monsterX][m.monsterY] = "\uD83D\uDC7E";
        this.map[mine.mineX][mine.mineY] = "\uD83D\uDCA3";

        // Array.toString() 1차원 배열 출력, Array.deeptoString: 다차원 출력
        // output:[[0,0,0],[0,0,0]]
        for (int i = 0 ; i < 11; i++){
            for (int j = 0; j < 11; j++){
                System.out.print(this.map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        this.map[p.playerX][p.playerY] = "."; // 초기화? 안해주면 이동 후에도 이전 p 자리 그대로 찍혀나옴
    }
}


class Player {

    public int playerX;
    public int playerY;
    public int score = 0;

    public static final int INIT_LOCATION = 5;

    //생성자
    public Player(){
        this.playerX = INIT_LOCATION;
        this.playerY = INIT_LOCATION;
    }

    //2. 이동
    public void move(){
        // 키 입력받는 코드 + 밑에 플레이어 이동코드가 함께 있어도 되는건지..(입력 코드 위치가 여기가 맞나)
        Scanner sc = new Scanner(System.in);
        System.out.println("W,S,A,D중 하나를 입력하세요: ");
        String key = sc.next();
        //sc.close();

        // 이동코드 Q:else문 너무 많이 쓴 것 같다. >> switch로 바꾸어보자
        //String 함수는 ==으로 비교하지 않는다. equals()사용.

        if (key.equals("W")) this.playerX -= 1;
        else if (key.equals("S")) this.playerX += 1;
        else if (key.equals("A")) this.playerY -= 1;
        else if (key.equals("D")) this.playerY += 1;
        else System.out.println("옳은 값을 입력하세요.");
    }

    //3. 사망
    public void gameOver(){
        System.out.println("Game Over");
        //실행 끝 함수 추가?
    }

    //4. 점수
    public void getScore(){
        this.score++;
    }
}

class Monster{
    public int monsterX;
    public int monsterY;

    public Monster(){
        createMonster();
    }

    //생성
    public void createMonster(){
        Random random = new Random();

        //0부터 10까지 랜덤하게 생성
        this.monsterX = random.nextInt(11);
        this.monsterY = random.nextInt(11);

        //몬스터의 생성위치가 플레이어 위치와 겹치면 다시 생성
        if((this.monsterX == 5)&&(this.monsterY == 5)) createMonster();

    }

}

class Mine {
    public int mineX;
    public int mineY;


    //1. 생성
    public void createMine(Player p,Monster m){

        //랜덤하게 생성
        Random random = new Random();

        for (;;){
            this.mineX = random.nextInt(11);
            this.mineY = random.nextInt(11);

            if((this.mineX == p.playerX)&&(this.mineY == p.playerY)) continue;
            if((this.mineX == m.monsterX)&&(this.mineY == m.monsterY)) continue;

            break;
        }



    }
}

class PlayRPG{

    //시작
    public void start(Player p,Monster m,Mine mine, Map map){
        //생성 >> 수정하기
        map.createMap();
        mine.createMine(p,m);
    }

    //실행
    public void play(Player p,Monster m,Mine mine, Map map){
        while(p.playerX < 11 && p.playerX > -1 && p.playerY < 11 && p.playerY > -1){
            System.out.println(p.score);
            map.printMap(p,m,mine);
            p.move();

            //1. m 만나면 스코어 +, 맵 초기화
            if (p.playerX == m.monsterX && p.playerY == m.monsterY){
                p.getScore();


            }
            //2. mine 만나면 종료
            if (p.playerX == mine.mineX && p.playerY == mine.mineY){
                p.gameOver();
                this.exit();
            }

        }

    }
    //종료
    public void exit(){
        System.exit(0);
    }
}


public class SimpleRPG {
    public static void main(String[] args){
        Player player = new Player();
        Monster monster = new Monster();
        Mine mine = new Mine();
        Map map = new Map();

        PlayRPG playrpg = new PlayRPG();


        playrpg.start(player,monster,mine,map);
        playrpg.play(player,monster,mine,map);

    }
}
