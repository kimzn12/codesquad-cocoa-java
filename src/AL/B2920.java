package AL;

import java.util.Scanner;
import java.util.Arrays;


import static java.lang.System.*;

public class B2920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(in);

        int[] ascending = {1,2,3,4,5,6,7,8};
        int[] descending = {8,7,6,5,4,3,2,1};

        int[] myMelody = new int[8];

        for (int i = 0; i <myMelody.length; i++){
            int note = sc.nextInt();
            myMelody[i] = note;
        }

        //**배열 비교 주의
        if (Arrays.toString(myMelody).equals(Arrays.toString(ascending))) {
            out.println("ascending");
        }
        else if (Arrays.toString(myMelody).equals(Arrays.toString(descending))){
            out.println("descending");
        }
        else out.println("mixed");

    }
}
