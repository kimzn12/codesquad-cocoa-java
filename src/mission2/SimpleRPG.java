package mission2;

import java.util.Scanner;
// 자바 배열을 출력하기 위해 필수적으로 필요 import java.util.Arrays;

class Map {
    //변수
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

    //2. 맵 출력 - 출력함수가 map에 있어야하는지 player.moster에 있어야하는지
    public void printMap(Player p, Monster m){
        this.map[p.playerX][p.playerY] = "P";
        this.map[m.monsterX][m.monsterY] = "M";

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

    //1. 생성
    public void createPlayer(){
        this.playerX = 5;
        this.playerY = 5;
    }

    //2. 이동
    public void move(){
        // 키 입력받는 코드 + 밑에 플레이어 이동코드가 함께 있어도 되는건지..(입력 코드 위치가 여기가 맞나)
        Scanner sc = new Scanner(System.in);
        System.out.println("W,S,A,D중 하나를 입력하세요: ");
        String key = sc.next();
        sc.close();

        // 이동코드 Q:else문 너무 많이 쓴 것 같다. >> switch로 바꾸어보자
        //String 함수는 ==으로 비교하지 않는다. equals()사용.
        if (key.equals("W")) this.playerX -= 1;
        else if (key.equals("S")) this.playerX += 1;
        else if (key.equals("A")) this.playerY -= 1;
        else if (key.equals("D")) this.playerY += 1;
        else System.out.println("옳은 값을 입력하세요.");
    }

    //3. 사망
    public void gameOver(Mine mine){
        if (this.playerX == mine.mineX && this.playerY == mine.mineY){
            System.out.println("Game Over");
            //실행 끝 함수 추가
        }
    }

    //4. 점수
    public void score(Monster m){
        if (this.playerX == m.monsterX && this.playerY == m.monsterY){
            this.score++;
        }

    }
}



class Mine {
    public int mineX;
    public int mineY;

    //1. 생성
    public void createMine(){
        //랜덤하게 생성
        this.mineX = 5;
        this.mineY = 6;
    }

}

class Monster{
    public int monsterX;
    public int monsterY;

    //생성
    public void createMonster(){
        //0부터 10까지 랜덤하게
        this.monsterX = 4;
        this.monsterY = 5;

    }

}

public class SimpleRPG {
    public static void main(String[] args){
        Map map = new Map();
        Player player = new Player();
        Monster monster = new Monster();

        map.createMap();
        player.createPlayer();
        monster.createMonster();

        map.printMap(player,monster);
        player.move();
        map.printMap(player,monster);
    }
}
