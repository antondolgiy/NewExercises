import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLRUCashe4 {

    @Test
    public void testRefresh2() {
        LRUCashe cashe = new LRUCashe(4);
        cashe.put("a", "A");
        cashe.put("b", "B");
        cashe.put("c", "C");
        cashe.put("d", "D");
        cashe.get("b");

        assertEquals("A", cashe.removeFirst());
        assertEquals("C", cashe.removeFirst());
        assertEquals("D", cashe.removeFirst());
        assertEquals("B", cashe.removeFirst());


    }

}
