package lektion10designpatterns2adaptertemplate.opgave5_merge;

// Combine: intersection — kun elementer der optræder i BEGGE sekvenser.
// Når et match er fundet, tilføjes kun ét af de to ens objekter til resultatet.
public class Combine<E extends Comparable<E>> extends MergeTemplate<E> {

    // s1.head < s2.head — s1's element kan ikke have et match i s2 (s2 er kun større fremover).
    // Elementet smides væk ved at kalde tail(). Vi SKAL kalde tail() her —
    // ellers stopper while-løkken i merge() aldrig med at tjekke det samme element.
    @Override
    protected void move1(Sequence<E> s) {
        s.tail();
    }

    // Samme logik som move1 men for s2's unikke element
    @Override
    protected void move2(Sequence<E> s) {
        s.tail();
    }

    // s1.head == s2.head — match fundet. Tilføj ét objekt til g, smid begge af.
    @Override
    protected void move3(Sequence<E> s1, Sequence<E> s2) {
        g.add(s1.head());
        s1.tail();
        s2.tail();
    }

    // moveTail1 og movetail2 er IKKE overskredet.
    // Når én sekvens er tom, har resterende elementer i den anden intet matchpunkt —
    // de kan aldrig opfylde intersection-kravet, så de ignoreres (default tom impl.).
}
