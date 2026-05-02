package lektion8streams.undervisningsmateriale.exercises1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e -> System.out.println(e + 1));

        // TODO 1
        // Udskriver det største element i listen
        // max() sammenligner to elementer ad gangen via Comparator og returnerer en Optional
        System.out.println("Største element: " + list.stream().max((e1, e2) -> e1.compareTo(e2)).get());

        // TODO 2
        // Afgør og udskriver om alle tallene i listen er mindre end 50
        // allMatch() returnerer true kun hvis ALLE elementer opfylder betingelsen
        System.out.println("Alle < 50: " + list.stream().allMatch(e -> e < 50));

        // TODO 3
        // Udskriver antallet af LIGE tal i listen
        // Bug rettet: e%2==0 giver lige tal (deleligt med 2), e%2==1 ville give ulige
        System.out.println("Antal lige tal: " + list.stream().filter(e -> e % 2 == 0).count());

        // TODO 4
        // Udskriver antallet af ULIGE tal i listen
        // Bug rettet: e%2!=0 (eller e%2==1) giver ulige tal
        System.out.println("Antal ulige tal: " + list.stream().filter(e -> e % 2 != 0).count());

        // TODO 5 (a-d)
        // Vi beregner gennemsnittet én gang og gemmer det i en variabel,
        // så vi kan genbruge det i 5.c og 5.d uden at genberegne
        double avg = list.stream().mapToInt(e -> e).average().getAsDouble();

        // 5.a: average() returnerer OptionalDouble — getAsDouble() udtrækker værdien
        System.out.println("5.a Gennemsnit: " + avg);

        // 5.b: count() tæller antallet af elementer i streamen
        System.out.println("5.b Antal elementer: " + list.stream().count());

        // 5.c og 5.d: filter() med avg — avg er effectively final så den kan bruges i lambda
        System.out.println("5.c Antal > gennemsnit: " + list.stream().filter(e -> e > avg).count());
        System.out.println("5.d Antal < gennemsnit: " + list.stream().filter(e -> e < avg).count());

        // TODO 6
        // Udskriver antallet af gange hvert tal forekommer i listen
        // groupingBy(e -> e) grupperer identiske tal som nøgle
        // Collectors.counting() tæller antallet i hver gruppe
        Map<Integer, Long> frekvens = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println("Frekvens: " + frekvens);

        // TODO 7
        // Samme som TODO 6, men sorteret på nøgle (talværdi) i stigende orden
        // entrySet().stream() giver os en stream af Map.Entry-par så vi kan sortere
        System.out.println("Frekvens sorteret:");
        list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println("  " + e.getKey() + " forekommer " + e.getValue() + " gang(e)"));
    }
}
