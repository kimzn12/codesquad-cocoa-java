package AL;
/*
    1. 인형 뽑기
    1-1) 가장 위에 있는 인형을 뽑는다.
    1-2) 인형을 가지고 나온 자리는 0으로 바꾼다.

    2. 인형 바구니에 넣기
    2-1) 만약 바구니가 비어있거나 || 바로위의 인형과 집어넣으려는 인형이 같지않다면 push
    2-2) 같으면 anw+2(2개 터트려야하니까) , 바구니 맨 위 인형 pop

    3. 다음 move 인덱스로 넘어간다.
 */

import java.util.Stack;

public class Programmers64061 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();


        for (int move : moves){
            move -= 1;
            //가장 위에 있는 인형 가지고 나오기
            for (int i = 0; i <board.length; i++) {
                int dollNum = board[i][move];
                if (dollNum == 0) continue;
                //인형 뽑음
                board[i][move] = 0;
                //인형 바구니에 집어넣기
                //인형 2개 겹치면 터트리기
                if (basket.size() == 0 || dollNum != basket.lastElement()) {
                    basket.push(dollNum);
                } else {
                    answer += 2;
                    basket.pop();
                }
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
}
