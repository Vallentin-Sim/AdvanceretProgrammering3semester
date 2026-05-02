package aflevering;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DictionaryDoubleHashingTest {

    // Erklæres som felt men initialiseres i @BeforeEach,
    // så hver test starter med samme kendte starttilstand.
    Dictionary<Integer, String> dic;

    @BeforeEach
    void setup() {
        dic = new DictionaryDoubleHashing<>(10);
        dic.put(4371, "A");
        dic.put(1323, "B");
        dic.put(6173, "C");
        dic.put(4199, "D");
        dic.put(4344, "E");
        dic.put(9679, "F");
        dic.put(1989, "G");
    }

    @Test
    void testSize() {
        assertEquals(7, dic.size());
    }

    @Test
    void testGet() {
        assertEquals("D", dic.get(4199));
        assertEquals("G", dic.get(1989));
    }

    @Test
    void testRemove() {
        assertEquals("D", dic.remove(4199));
        assertEquals(6, dic.size());
        assertNull(dic.get(4199));
    }

    @Test
    void testGetUnchangedAfterRemoveOfOtherKey() {
        dic.remove(4199);
        assertEquals("G", dic.get(1989));
        assertEquals(6, dic.size());
    }

    @Test
    void testUpdateExistingKeyReturnsOldValue() {
        assertEquals("G", dic.put(1989, "H"));
        assertEquals("H", dic.get(1989));
        assertEquals(7, dic.size());
    }

    @Test
    void testUpdateAnotherExistingKey() {
        assertEquals("B", dic.put(1323, "I"));
        assertEquals("I", dic.get(1323));
        assertEquals(7, dic.size());
    }

    @Test
    void testPutNewKeyReturnsNull() {
        assertNull(dic.put(0, "J"));
        assertEquals(8, dic.size());
    }
}
