package lektion8streams.undervisningsmateriale.exercises1;

import java.util.List;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e-> System.out.println(e+1));

        //  TODO 1
        //	Udskriver det største element i listen

        //  TODO 2
        //	Afgør og udskriver om alle tallene i listen er mindre end 50

        //  TODO 3
        // 	Udskriver antallet af lige tal i listen

        //  TODO 4
        //	Udskriver antallet af ulige tal i listen

        //  TODO
        //  Udskriver
        //      Gennemsnittet af tallene i listen 5.a
        //      Antallet af tallene i listen 5.b
        //      Antallet af tallene i listen der er større end gennemsnittet 5.c
        //      Antallet af tallene i listen der er mindre end gennemsnittet 5.d

        //  TODO 5
        //	Udskriver antallet af gange de forskellige tal forekommer i listen

        //  TODO 7
        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
    }
}
