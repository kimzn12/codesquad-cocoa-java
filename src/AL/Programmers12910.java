package AL;

import java.util.*;

public class Programmers12910 {
    public static ArrayList<Integer> solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i: arr){
            if(i % divisor == 0){
                ans.add(i);
            }
        }
        if(ans.isEmpty()){
            ans.add(-1);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {10,6,6,4,5};
        System.out.println(solution(arr,7));
    }

}
