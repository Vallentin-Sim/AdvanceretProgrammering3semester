package lektion10designpatterns2adaptertemplate.opgave5_merge;

// FindAll: beholder ALLE elementer fra begge sekvenser.
// Ens elementer (compareTo == 0) bevares begge — ét fra s1, ét fra s2.
public class FindAll<E extends Comparable<E>> extends MergeTemplate<E> {

    // s1.head < s2.head — tag fra s1 og flyt videre i s1
    @Override
    protected void move1(Sequence<E> s) {
        g.add(s.head());
        s.tail();
    }

    // s1.head > s2.head — tag fra s2 og flyt videre i s2
    @Override
    protected void move2(Sequence<E> s) {
        g.add(s.head());
        s.tail();
    }

    // s1.head == s2.head — behold begge (multiset: tilføj ét fra hver)
    @Override
    protected void move3(Sequence<E> s1, Sequence<E> s2) {
        g.add(s1.head());
        s1.tail();
        g.add(s2.head());
        s2.tail();
    }

    // s2 er løbet tør — tøm resten af s1 direkte ind i g
    @Override
    protected void moveTail1(Sequence<E> s) {
        while (!s.isEmpty()) {
            g.add(s.head());
            s.tail();
        }
    }

    // s1 er løbet tør — tøm resten af s2 direkte ind i g
    @Override
    protected void movetail2(Sequence<E> s) {
        while (!s.isEmpty()) {
            g.add(s.head());
            s.tail();
        }
    }
}
