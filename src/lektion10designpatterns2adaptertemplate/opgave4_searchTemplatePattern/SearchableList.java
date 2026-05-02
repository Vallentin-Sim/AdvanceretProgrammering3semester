package lektion10designpatterns2adaptertemplate.opgave4_searchTemplatePattern;

import java.util.List;

public class SearchableList<E extends Comparable<E>> extends SearchPattern<E> {
    private List<E> list;
    private int currentIndex;

    public SearchableList(List<E> list) {
        this.list = list;
    }

    // Resets the cursor so the same object can be reused across multiple search() calls.
    @Override
    protected void init() {
        currentIndex = 0;
    }

    // The template loop stops when there are no more elements to inspect.
    @Override
    protected boolean isEmpty() {
        return currentIndex >= list.size();
    }

    // Returns the element at the current cursor position without advancing it.
    // The template method compares this against the search target.
    @Override
    protected E select() {
        return list.get(currentIndex);
    }

    // Called only when select() did NOT match — discard the current element
    // by advancing the cursor so the next iteration inspects the next one.
    @Override
    protected void split(E m) {
        currentIndex++;
    }
}
