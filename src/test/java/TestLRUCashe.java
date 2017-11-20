import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Anton on 25.10.2017.
 */

    public class TestLRUCashe {


    @Test
    public void testPut() {
        LRUCashe cashe = new LRUCashe(4);
        cashe.put("a", "A");
        cashe.put("b", "B");
        cashe.put("c", "C");
        cashe.put("d", "D");

        assertEquals("A", cashe.get("a"));
        assertEquals("B", cashe.get("b"));
        assertEquals("C", cashe.get("c"));
        assertEquals("D", cashe.get("d"));

        cashe.put("e", "EE");
        assertEquals(null, cashe.get("a"));
        assertEquals("EE", cashe.get("e"));

        cashe.put("f", "FF");
        assertEquals(null, cashe.get("b"));
        assertEquals("FF", cashe.get("f"));


    }

}

