import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anton on 23.11.2017.
 */
public class TestReverseSpecialList {
    @Test
    public  void testAdd(){
        ArrayList<String> original =new ArrayList<String>(Arrays.asList("a","b","c","d"));
        SpecialList<String>specialList=new SpecialList<String>();
        for (String s:original){
            specialList.addElement(s);
        }
        for (int i = 0; i <original.size(); i++) {
            assertEquals(original.get(original.size() - 1 - i),specialList.removeLast());
        }
    }
    @Test
    public void testReverse(){
        ArrayList<String> original =new ArrayList<String>(Arrays.asList("a","b","c","d"));
        SpecialList<String>specialList=new SpecialList<String>();
        for (String s:original){
            specialList.addElement(s);
        }
        specialList.swapAll();
        for (int i = 0; i <original.size(); i++) {
            assertEquals(original.get(i),specialList.removeLast());
        }
    }

    @Test
    public void testReverseSize2(){
        ArrayList<String> original =new ArrayList<String>(Arrays.asList("a","b"));
        SpecialList<String>specialList=new SpecialList<String>();
        for (String s:original){
            specialList.addElement(s);
        }
        specialList.swapAll();
        for (int i = 0; i <original.size(); i++) {
            assertEquals(original.get(i),specialList.removeLast());
        }
    }

    @Test
    public void testReverseSize3(){
        ArrayList<String> original =new ArrayList<String>(Arrays.asList("a","b", "c"));
        SpecialList<String>specialList=new SpecialList<String>();
        for (String s:original){
            specialList.addElement(s);
        }
        specialList.swapAll();
        for (int i = 0; i <original.size(); i++) {
            assertEquals(original.get(i),specialList.removeLast());
        }
    }

}
