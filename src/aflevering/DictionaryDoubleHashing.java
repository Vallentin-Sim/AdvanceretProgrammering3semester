package aflevering;

// K extends Number: sikrer at compileren afviser ikke-numeriske nøgler.
// keyValue() kræver Number — uden bound ville fejlen først opstå ved kørselstid.
public class DictionaryDoubleHashing<K extends Number, V> implements Dictionary<K, V> {
    private static final double MAX_LOAD_FACTOR = 0.5;

    private Entry<K, V>[] table;
    private int size;

    // Markerer en slettet plads, saa soegekaeden ikke brydes efter remove.
    private final Entry<K, V> DELETED = new Entry<>(null, null);

    public DictionaryDoubleHashing() {
        this(10);
    }

    public DictionaryDoubleHashing(int length) {
        if (length < 2) {
            throw new IllegalArgumentException("Table length must be at least 2");
        }
        table = new Entry[length];
        size = 0;
    }

    private int keyValue(K key) {
        return key.intValue();
    }

    private int primaryHash(K key) {
        // Opgavens hashfunktion: h(key) = key % size.
        return Math.floorMod(keyValue(key), table.length);
    }

    private int secondaryHash(K key) {
        // Opgavens anden hashfunktion: h'(key) = 7 - (key % 7).
        return 7 - Math.floorMod(keyValue(key), 7);
    }

    private int indexFor(K key, int probe) {
        // Double hashing: h(key, i) = (h(key) + i * h'(key)) % size.
        return (primaryHash(key) + probe * secondaryHash(key)) % table.length;
    }

    private double loadFactorAfterNextInsert() {
        return (double) (size + 1) / table.length;
    }

    // O(N)
    private void rehash() {
        Entry<K, V>[] oldTable = table;

        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null && entry != DELETED) {
                insertEntry(entry.getKey(), entry.getValue());
            }
        }
        // size = oldSize fjernet — insertEntry() tæller korrekt op under løkken
    }

    private void insertEntry(K key, V value) {
        for (int probe = 0; probe < table.length; probe++) {
            int index = indexFor(key, probe);
            Entry<K, V> entry = table[index];

            if (entry == null || entry == DELETED) {
                table[index] = new Entry<>(key, value);
                size++;
                return;
            }
        }

        throw new IllegalStateException("Dictionary is full");
    }

    private int findIndex(K key) {
        for (int probe = 0; probe < table.length; probe++) {
            int index = indexFor(key, probe);
            Entry<K, V> entry = table[index];

            if (entry == null) {
                return -1;
            }
            if (entry != DELETED && entry.getKey().equals(key)) {
                return index;
            }
        }
        return -1;
    }

    // O(n) worst-case, O(1) gennemsnit
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }
        int index = findIndex(key);
        return index >= 0 ? table[index].getValue() : null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // O(N)
    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value must not be null");
        }

        int existingIndex = findIndex(key);
        if (existingIndex >= 0) {
            V oldValue = table[existingIndex].getValue();
            table[existingIndex] = new Entry<>(key, value);
            return oldValue;
        }

        if (loadFactorAfterNextInsert() > MAX_LOAD_FACTOR) {
            rehash();
        }

        // En slettet plads kan genbruges, hvis noeglen ikke findes senere i soegekaeden.
        int firstDeletedIndex = -1;

        for (int probe = 0; probe < table.length; probe++) {
            int index = indexFor(key, probe);
            Entry<K, V> entry = table[index];

            if (entry == null) {
                int insertIndex = firstDeletedIndex >= 0 ? firstDeletedIndex : index;
                table[insertIndex] = new Entry<>(key, value);
                size++;
                return null;
            }

            if (entry == DELETED && firstDeletedIndex < 0) {
                firstDeletedIndex = index;
            }
        }

        if (firstDeletedIndex >= 0) {
            table[firstDeletedIndex] = new Entry<>(key, value);
            size++;
            return null;
        }

        throw new IllegalStateException("Dictionary is full");
    }

    // O(N)
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }

        for (int probe = 0; probe < table.length; probe++) {
            int index = indexFor(key, probe);
            Entry<K, V> entry = table[index];

            if (entry == null) {
                return null;
            }
            if (entry != DELETED && entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                // En slettet markoer bevarer soegekaeden; null ville stoppe senere opslag for tidligt.
                table[index] = DELETED;
                size--;
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    // Kun til test og udskrift af tabellen.
    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t" + table[i]);
        }
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public String toString() {
            return "(" + key + " , " + value + ")";
        }
    }
}
