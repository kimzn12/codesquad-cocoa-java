package mission1;

import java.util.Scanner;

public class bj1330 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();

        //같으면 = ,a 크면 >, b 크면 <
        if (a == b){
            System.out.println("==");
        }
        else if(a < b){
            System.out.println("<");
        }
        else{
            System.out.println(">");
        }
    }
}
