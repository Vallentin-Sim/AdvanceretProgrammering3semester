package lektion10designpatterns2adaptertemplate.opgave4_searchTemplatePattern;

import java.util.List;

public class BinarySearchableList<E extends Comparable<E>> extends SearchPattern<E> {
    private List<E> list;
    private int low;
    private int high;
    private int mid;

    public BinarySearchableList(List<E> list) {
        this.list = list;
    }

    // Establishes the full window [0, size-1] at the start of each search.
    @Override
    protected void init() {
        low = 0;
        high = list.size() - 1;
    }

    // The window collapses to nothing when low passes high — target not present.
    @Override
    protected boolean isEmpty() {
        return low > high;
    }

    // Picks the midpoint of the current window.
    // Storing mid as a field lets split() reuse it without recalculating.
    @Override
    protected E select() {
        mid = (low + high) / 2;
        return list.get(mid);
    }

    // Called when the midpoint did NOT match. Discards the half that cannot
    // contain the target by tightening either the lower or upper bound.
    // Because the list is sorted, if m > mid element then target is to the right,
    // otherwise it must be to the left.
    @Override
    protected void split(E m) {
        if (m.compareTo(list.get(mid)) > 0) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
}
