import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLRUCashe2 {

  @Test
  public void testRemove() {
      LRUCashe cashe = new LRUCashe(4);
      cashe.put("a", "A");
      cashe.put("b", "B");
      cashe.put("c", "C");
      cashe.put("d", "D");

      assertEquals("A", cashe.removeFirst());
      assertEquals("B", cashe.removeFirst());
      assertEquals("C", cashe.removeFirst());
      assertEquals("D", cashe.removeFirst());
      assertEquals(null, cashe.removeFirst());

  }

}
