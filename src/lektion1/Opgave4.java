package lektion1;

public class Opgave4 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n){
        int[] fibTal = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0){
                fibTal[0] = 0;
            } else if (i == 1){
                fibTal[i] = 1;
            } else if (i == 2){
                fibTal[i] = 1;
            } else {
                fibTal[i] = fibTal[i-1] + fibTal[i-2];
            }
        }
        return fibTal[n-1];
    }
}
