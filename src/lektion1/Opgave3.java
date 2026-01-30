package lektion1;

import java.util.Arrays;

public class Opgave3 {
    public static void main(String[] args) {
        int[] inputTal = {5, 10, 5, 6, 4, 9, 8};
        System.out.println(Arrays.toString(prefixAverage(inputTal)));
    }

    public static double[] prefixAverage(int[] inputTal){
        double[] prefix = new double[inputTal.length];
        double sum = 0;
        for (int i = 0; i <= inputTal.length-1; i++) {
            sum += inputTal[i];
            prefix[i] = sum / (i+1);
        }
        return prefix;
    }
}
