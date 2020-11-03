package mission1;

import java.util.Scanner;

public class GuGudan2 {

    public int start;
    public int end;

    public void init(){
        Scanner sc = new Scanner(System.in);
        this.start = sc.nextInt();
        this.end = sc.nextInt();
        sc.close();
    }

    private void printGugudan(int dan){
        for (int i = 1; i < 10; i++){
            System.out.printf("%d * %d = %d\t", dan, i, dan * i);
        }
        System.out.println();
    }

    public void printAll(){
        for (int i = this.start; i < this.end + 1; i++) {
            printGugudan(i);
        }
    }


    public static void main(String[] args){
        GuGudan2 gugudan = new GuGudan2();
        gugudan.init();
        gugudan.printAll();
    }
}


