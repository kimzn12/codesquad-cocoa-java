/*
반복문 - 숫자의 합
개수받고 합구하기

*nextInt() 범위 :-2,147,483,648 ~2,147,483,647 (10자리)
*string.charAt(i)-'0'
 문자 - 문자0 : str > int 형변환
 */

package mission1;

import java.util.Scanner;

public class bj11720 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        String num = sc.next();
        int sum = 0;

        for(int i=0; i < count; i++){
            sum += num.charAt(i)-'0';
        }
        System.out.println(sum);
    }

}
