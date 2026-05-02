package aflevering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryDoubleHashingTest {
    Dictionary<Integer, String> dic = new DictionaryDoubleHashing<>(10);
 
    @Test
    void dictionayTest() {
        dic.put(4371,"A");
        dic.put(1323,"B");
        dic.put(6173,"C");
        dic.put(4199,"D");
        dic.put(4344,"E");
        dic.put(9679,"F");
        dic.put(1989,"G");
        assertEquals(7,dic.size());
        assertEquals("D", dic.get(4199));
        assertEquals("D",dic.remove(4199));
        assertEquals(6,dic.size());
        assertEquals(null,dic.get(4199));
        assertEquals("G",dic.get(1989));
        assertEquals(6,dic.size());
        assertEquals("G",dic.put(1989,"H"));
        assertEquals("H",dic.get(1989));
        assertEquals("B",dic.put(1323,"I"));
        assertEquals(6,dic.size());
        assertEquals("I",dic.get(1323));
        assertEquals(null, dic.put(0,"J"));

    }


}