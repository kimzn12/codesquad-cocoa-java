package mission3.OddEvenGame;

import java.util.*;

/*
상대방의 소지금이 0원이 되면 다음 상대가 등장. 다음 상대는 내 소지금 * pow(1.2, numStage) 의 소지금을 가지고 등장한다.
라이벌은 총 8명이 등장한다.
게임 오버시 소지금과 진행 턴을 표시해 준다.
(옵션) 게임 오버시 이름을 입력받고 랭킹을 출력해 준다. 랭킹은 소지금이 많을 수록, 턴이 작을수록 높아진다.
 */
public class OddEvenGame {
    Player player;
    Enemy enemy;

    boolean isPlayerDie;
    boolean isEnemyDie;

    int numStage = 0; //현재 라운드

    //이름입력
    public void createPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        String name = sc.next();

        player = new Player(name);
    }

    //게임 초기화
    public void init(){
        numStage++;
        isEnemyDie = false;
        isPlayerDie = false;

        System.out.println("===== 라운드 "+ numStage + " =====");

        player.money = 100;
        enemy = new Enemy(player, numStage);
    }

    public void checkWinner(Player player,Enemy enemy) { // 메소드 하나 더 만들어야할듯
        if(player.oddOrEven.equals("홀")){
            if(enemy.enemyNum % 2 == 1){ //1,0을 파라미터로 받아서
                //if문 순서를 바꾸면 반복을 피할 수 있다.
                Calculation.playerWin(player,enemy);
            }
            else{
                Calculation.enemyWin(player,enemy);
            }
        } //return; 뒤에 짝if 필요없다.

        if(player.oddOrEven.equals("짝")) {
            if(enemy.enemyNum % 2 == 0) {
                Calculation.playerWin(player,enemy);
            }
            else{
                Calculation.enemyWin(player,enemy);
            }
        }
    }

    public void checkMoney(Player player, Enemy enemy){
        if(player.money == 0) isPlayerDie = true;
        if(enemy.money == 0) isEnemyDie = true;

    }

    //게임 진행
    public void playGame() {
        init();
        while(true){ //플레이어 또는 적의 소지금이 0이면 종료
            //1. 적 번호고르기
            //2. 홀짝선택 select
            //3. 배팅
            //4. 누가 이겼는지 확인(이거 메소드빼기), 정산
            enemy.selectNumber(); //1
            player.selectOddOrEven(); //2
            player.betMoney(enemy); //3
            checkWinner(player, enemy); // 4
            checkMoney(player,enemy);
            if(isPlayerDie) return;
            if(isEnemyDie) playGame();
        }

    }

    public static void main(String[] args){
        OddEvenGame oddevengame = new OddEvenGame();
        oddevengame.createPlayer();
        oddevengame.playGame();
    }
}
