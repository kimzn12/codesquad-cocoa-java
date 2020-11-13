package AL;

import java.util.*;

public class Programmers68644 {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numbers.length-1; i++){
            for (int j = i+1; j < numbers.length; j++){
                int sum = i + j;
                if (!answer.contains(sum)){
                    answer.add(sum);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
