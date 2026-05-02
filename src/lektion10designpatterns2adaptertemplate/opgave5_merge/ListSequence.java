package lektion10designpatterns2adaptertemplate.opgave5_merge;

import java.util.Iterator;
import java.util.LinkedList;

// Adapter: ListSequence tilpasser LinkedList til Sequence-interfacet.
// LinkedList er Adaptee — vi ejer ikke den klasse og kan ikke ændre den.
// Sequence er Target — det interface kalderen forventer.
// ListSequence er Adapteren — den "oversætter" imellem dem.
public class ListSequence<E> implements Sequence<E> {

    private LinkedList<E> list = new LinkedList<>();

    // Oversættes direkte: LinkedList.add() tilføjer bagest — præcis hvad Sequence kræver
    @Override
    public void add(E obj) {
        list.add(obj);
    }

    // addAll har ingen direkte LinkedList-modstykke der tager en Sequence,
    // så vi løber selv igennem s med dens iterator og tilføjer element for element
    @Override
    public void addAll(Sequence<E> s) {
        Iterator<E> it = s.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
    }

    // getFirst() returnerer det første element uden at fjerne det — præcis head()-semantik
    @Override
    public E head() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    // removeFirst() fjerner det første element — præcis tail()-semantik
    @Override
    public void tail() {
        list.removeFirst();
    }
}
