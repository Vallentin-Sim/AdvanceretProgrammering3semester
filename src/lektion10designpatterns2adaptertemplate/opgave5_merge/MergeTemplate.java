package lektion10designpatterns2adaptertemplate.opgave5_merge;

// Template Method: merge() definerer den faste algoritme for fletning.
// De 5 primitive metoder (move1..movetail2) er de variable trin som
// subklasser kan overskrive for at ændre adfærd ved ens/ikke-ens elementer.
public abstract class MergeTemplate<E extends Comparable<E>> {

    protected Sequence<E> g;

    // Template method — final så ingen subklasse kan ændre selve algoritmen
    // Pre:  s1 og s2 er sorteret i ikke-aftagende orden, g er tom
    // Post: g er sorteret og indeholder resultatet af fletning af s1 og s2
    public final Sequence<E> merge(Sequence<E> s1, Sequence<E> s2, Sequence<E> g) {
        this.g = g;

        // Kør så længe begge sekvenser har elementer
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.head().compareTo(s2.head()) < 0) {
                move1(s1);          // s1's hoved er mindst — tag fra s1
            } else if (s1.head().compareTo(s2.head()) > 0) {
                move2(s2);          // s2's hoved er mindst — tag fra s2
            } else {
                move3(s1, s2);      // Ens hoveder — subklassen bestemmer hvad der sker
            }
        }

        // Tøm den sekvens der evt. har rester
        if (!s1.isEmpty()) {
            moveTail1(s1);
        } else if (!s2.isEmpty()) {
            movetail2(s2);
        }

        return g;
    }

    // Primitive metoder med tomme default-implementeringer.
    // Subklasser overskriver kun dem de har brug for.
    protected void move1(Sequence<E> s) {}
    protected void move2(Sequence<E> s) {}
    protected void move3(Sequence<E> s1, Sequence<E> s2) {}
    protected void moveTail1(Sequence<E> s) {}
    protected void movetail2(Sequence<E> s) {}
}
