package lektion1;

public class Opgave6 {
    private static char[] belgianFlag =
            {'G', 'R', 'S', 'G', 'G', 'R', 'S', 'R', 'G', 'G', 'R', 'S', 'G'};

    public static void main(String[] args) {
        System.out.println("Original: " + new String(belgianFlag));
        belgian_flag(belgianFlag);
        System.out.println("Sorted:   " + new String(belgianFlag));
    }

    /**
     * Først løbes arrayed 1 gang igennem og tæller hvor mange S, G og R der fremkommer
     * Derefter mapper vi S -> 1, G -> 2 og R -> 3.
     * Derefter skriver vi tilbage i samme array først
     * alle S, derefter G og så R.
     * På denne måde bliver arrayed sorteret i rækkefølgen S, G, R uden at lave en ny array.
     * Eksempel: G R S G G R -> Tæller S=1, G=3 og R=2 -> Skriver
     * S G G G R R på pladsen.
     * @param belgian_flag gamle array overskrives sorteret.
     */
    public static void belgian_flag(char[] belgian_flag){
        int countS = 0;
        int countG = 0;
        int countR = 0;

        for (int i = 0; i < belgian_flag.length; i++) {
            char mapped = charConverterHelperMethod(belgian_flag[i]);
            if (mapped == 1) {
                countS++;
            } else if (mapped == 2) {
                countG++;
            } else if (mapped == 3) {
                countR++;
            }
        }

        int index = 0;
        for (int i = 0; i < countS; i++) {
            belgian_flag[index++] = 'S';
        }
        for (int i = 0; i < countG; i++) {
            belgian_flag[index++] = 'G';
        }
        for (int i = 0; i < countR; i++) {
            belgian_flag[index++] = 'R';
        }
    }

    public static char charConverterHelperMethod(char value){
        int syncValue = 0;
        switch (value){
            case 'S' -> syncValue = 1;
            case 'G' -> syncValue = 2;
            case 'R' -> syncValue = 3;
        }
        return (char)syncValue;
    }
}
