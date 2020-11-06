package AL;

import java.util.Scanner;

public class BJ8958 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int answer = 0; // 최종점수
        int score = 0; //중간에 획득하는 점수
        int[] answerSet = new int[num];

        for (int i = 0; i < num; i++){
            String ox = sc.next();
            for ( int j = 0; j < ox.length(); j++){
                if (ox.charAt(j) == 'X') {
                    score = 0;
                    continue; //ox[j] >> ox.charAt[j]
                }
                score++;
                answer += score;

            }

            answerSet[i] = answer;
            //초기화
            answer = 0;
            score = 0;
        }

        for (int i = 0; i < answerSet.length; i++){
            System.out.println(answerSet[i]);
        }
    }
}
