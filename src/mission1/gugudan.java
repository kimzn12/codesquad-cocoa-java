package mission1;

import java.util.Scanner;

public class gugudan {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int i;

        for(;num1 <= num2; num1++){
            System.out.println("*************" + num1 + "단 입니다.*************");
            for(i = 1; i < 10; i++){
                System.out.printf("%d * %d = %d\n",num1,i,num1*i);
            }
        }

    }

}