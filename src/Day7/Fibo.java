package Day7;

public class Fibo {
    public static int fibo(int i){
        if(i == 0 || i ==1) return 1;

        return fibo(i-1) + fibo(i-2);
    }
    public static void main(String[] args){
        System.out.println(fibo(8));
    }
}
