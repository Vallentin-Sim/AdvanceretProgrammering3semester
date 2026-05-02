package lektion10designpatterns2adaptertemplate.opgave5_merge;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {

        // --- AGF-sekvens (sorteret: primært ugedag, sekundært navn) ---
        Sequence<Team> agf = new ListSequence<>();
        agf.add(new Team("basketball", Weekday.TIRSDAG));
        agf.add(new Team("volleyball", Weekday.TIRSDAG));
        agf.add(new Team("fodbold",    Weekday.TORSDAG));
        agf.add(new Team("håndbold",   Weekday.TORSDAG));

        // --- AIA-sekvens ---
        Sequence<Team> aia = new ListSequence<>();
        aia.add(new Team("basketball", Weekday.TIRSDAG));
        aia.add(new Team("floorball",  Weekday.ONSDAG));
        aia.add(new Team("fodbold",    Weekday.TORSDAG));

        // Print begge sekvenser
        System.out.println("=== AGF ===");
        printSequence(agf);

        System.out.println("\n=== AIA ===");
        printSequence(aia);

        // Flet: vi opretter nye sekvenser til fletningen fordi merge() tømmer s1 og s2
        Sequence<Team> agfKopi = new ListSequence<>();
        agfKopi.addAll(agf);

        Sequence<Team> aiaKopi = new ListSequence<>();
        aiaKopi.addAll(aia);

        Sequence<Team> resultat = new ListSequence<>();
        MergeTemplate<Team> merger = new FindAll<>();
        merger.merge(agfKopi, aiaKopi, resultat);

        System.out.println("\n=== Flettet (AGF + AIA) ===");
        printSequence(resultat);

        // Combine: kun hold der findes i BEGGE klubber
        Sequence<Team> agfKopi2 = new ListSequence<>();
        agfKopi2.addAll(agf);

        Sequence<Team> aiaKopi2 = new ListSequence<>();
        aiaKopi2.addAll(aia);

        Sequence<Team> faelles = new ListSequence<>();
        MergeTemplate<Team> combiner = new Combine<>();
        combiner.merge(agfKopi2, aiaKopi2, faelles);

        System.out.println("\n=== Fælles hold (AGF ∩ AIA) ===");
        printSequence(faelles);
    }

    private static void printSequence(Sequence<Team> seq) {
        Iterator<Team> it = seq.iterator();
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }
    }
}
