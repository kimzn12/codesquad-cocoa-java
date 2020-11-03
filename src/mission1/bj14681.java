/*
조건문 연습 - 사분면고르기
 */

package mission1;

import java.util.Scanner;

public class bj14681 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        //1사분면
        if(x>0 && y>0){
            System.out.println("1");
        }
        else if(x<0 && y>0){
            System.out.println("2");
        }
        else if(x<0 && y<0){
            System.out.println("3");
        }
        else {
            System.out.println("4");
        }
    }
}
