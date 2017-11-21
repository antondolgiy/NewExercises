import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLRUCashe5 {
    @Test
    public void testPutNull() {
        LRUCashe cashe = new LRUCashe(4);
        cashe.put("a", "A");
        cashe.put("b", "B");
        cashe.put(null, null);
        cashe.put(null, "C");

        assertEquals("A", cashe.removeFirst());
        assertEquals("Bv", cashe.removeFirst());
        assertEquals(null, cashe.removeFirst());

    }


}
