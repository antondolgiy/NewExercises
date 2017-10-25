import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anton on 25.10.2017.
 */

public class TestLRUCashe {

    LRUCashe lruCashe=new LRUCashe(3);
    {
        lruCashe.putNod("aa",null);
        lruCashe.putNod("bb",null);
        lruCashe.putNod("cc",null);
    }
    @Test
    public void testAdded(){
       // refresh from first by put
        lruCashe.putNod("aa",null);//bb,cc,aa
        assert (lruCashe.map.containsKey("bb")&&lruCashe.map.containsKey("cc")&&lruCashe.map.containsKey("aa"));
        lruCashe.putNod("zz",null);//cc,aa,zz
        assert (lruCashe.map.containsKey("cc")&&lruCashe.map.containsKey("aa")&&lruCashe.map.containsKey("zz"));
        // refresh from first by get
        lruCashe.getNod("cc");//aa,zz,cc
        assert (lruCashe.map.containsKey("aa")&&lruCashe.map.containsKey("zz")&&lruCashe.map.containsKey("cc"));
        //put the same
        lruCashe.putNod("xx",null);//zz,cc,xx
        assert (lruCashe.map.containsKey("zz")&&lruCashe.map.containsKey("cc")&&lruCashe.map.containsKey("xx"));
        lruCashe.putNod("xx",null);//zz,cc,xx
        //get the last
        lruCashe.getNod("xx");
        lruCashe.getNod("xx");

        assert (lruCashe.map.containsKey("zz")&&lruCashe.map.containsKey("cc")&&lruCashe.map.containsKey("xx"));
        lruCashe.putNod("uu",null);//cc,xx,uu
        lruCashe.putNod("vv",null);//xx,uu,vv
        assert (lruCashe.map.containsKey("xx")&&lruCashe.map.containsKey("uu")&&lruCashe.map.containsKey("vv"));

        //refresh from mid by get
        lruCashe.getNod("uu");//xx,vv,uu
        lruCashe.putNod("ii",null);//vv,uu,ii
        lruCashe.putNod("mm",null);//uu,ii,mm

        assert (lruCashe.map.containsKey("uu")&&lruCashe.map.containsKey("ii")&&lruCashe.map.containsKey("mm"));
        lruCashe.putNod("hh",null);//ii,mm,hh
        assert (lruCashe.map.containsKey("ii")&&lruCashe.map.containsKey("mm")&&lruCashe.map.containsKey("hh"));
        //refresh from mid by put
        lruCashe.putNod("mm",null);//ii,hh,mm
        lruCashe.putNod("jj",null);//hh,mm,jj
        lruCashe.putNod("pp",null);//mm,jj,pp
        assert (lruCashe.map.containsKey("mm")&&lruCashe.map.containsKey("jj")&&lruCashe.map.containsKey("pp"));
        lruCashe.putNod("nn",null);
        assert (lruCashe.map.containsKey("jj")&&lruCashe.map.containsKey("pp")&&lruCashe.map.containsKey("nn"));


    }

}
