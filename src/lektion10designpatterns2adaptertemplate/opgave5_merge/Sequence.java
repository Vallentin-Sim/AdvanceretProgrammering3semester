package lektion10designpatterns2adaptertemplate.opgave5_merge;

import java.util.Iterator;

public interface Sequence<E> {
    public void add(E obj);
    public void addAll(Sequence<E> s);
    public E head();
    public boolean isEmpty();
    public Iterator<E> iterator();
    public void tail();
}
