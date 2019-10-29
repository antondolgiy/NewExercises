import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Anton on 25.10.2017.
 */

public class TestLRUCashe {
    LRUCashe cashe = new LRUCashe(4);

    @Before
    public void setCashe() {

        cashe.put("a", "A");
        cashe.put("b", "B");
        cashe.put("c", "C");
        cashe.put("d", "D");
    }


    @Test
    public void testPut() {


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

    @Test
    public void testRemove() {



        assertEquals("A", cashe.removeFirst());
        assertEquals("B", cashe.removeFirst());
        assertEquals("C", cashe.removeFirst());
        assertEquals("D", cashe.removeFirst());
        assertEquals(null, cashe.removeFirst());

    }

    @Test
    public void testRefresh() {


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

    @Test
    public void testRefresh2() {


        cashe.get("b");

        assertEquals("A", cashe.removeFirst());
        assertEquals("C", cashe.removeFirst());
        assertEquals("D", cashe.removeFirst());
        assertEquals("B", cashe.removeFirst());


    }

    @Test
    public void testPutNull() {

        cashe.put(null, null);
        cashe.put(null, "C");

        assertEquals("A", cashe.removeFirst());
        assertEquals("B", cashe.removeFirst());
        assertEquals("C", cashe.removeFirst());
        assertEquals("D", cashe.removeFirst());

        assertEquals(null, cashe.removeFirst());

    }

}

