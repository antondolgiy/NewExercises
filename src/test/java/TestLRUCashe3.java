import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLRUCashe3 {

    @Test
    public void testRefresh() {
        LRUCashe cashe = new LRUCashe(4);
        cashe.put("a", "A");
        cashe.put("b", "B");
        cashe.put("c", "C");
        cashe.put("d", "D");
        cashe.put("a", "AA");
        cashe.put("e", "E");

        assertEquals(null, cashe.get("b"));
        assertEquals("C", cashe.removeFirst());
        assertEquals("D", cashe.removeFirst());
        assertEquals("AA", cashe.removeFirst());
        assertEquals("E", cashe.removeFirst());
        assertEquals(null, cashe.removeFirst());
        assertEquals(null, cashe.removeFirst());


    }

}
