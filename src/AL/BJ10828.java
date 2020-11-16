package AL;

import java.util.*;

public class BJ10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < num; i++) {
            int money = sc.nextInt();
            if (money == 0) {
                stack.pop();
            }
            else {
                stack.push(money);
            }

        }
        sc.close();

        for(Integer i:stack){
            sum += i;
        }

        System.out.println(sum);
    }
}


