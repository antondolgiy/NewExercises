import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Anton on 25.10.2017.
 */

public class TestLRUCashe {

    LRUCashe lruCashe=new LRUCashe(3);
    LRUCashe lruCashe1=new LRUCashe(4);

    {
        lruCashe.putNod("aa",null);
        lruCashe.putNod("bb",null);
        lruCashe.putNod("cc",null);

        lruCashe1.putNod("aa",null);
        lruCashe1.putNod("bb",null);
        lruCashe1.putNod("cc",null);
    }
    @Test
    public void testAdded(){
        // refresh from first by put
        lruCashe.putNod("aa","dasAA");//bb,cc,aa
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

    @Test
    public void testAdded2(){
        Map<String, LRUCashe.Node> map=lruCashe1.map;

        // refresh from first by put
        lruCashe1.putNod("aa",null);//bb,cc,aa
        assert (map.containsKey("bb")&&map.containsKey("cc")&&map.containsKey("aa"));
        lruCashe1.putNod("zz",null);//bb,cc,aa,zz
        assert (map.containsKey("bb")&&map.containsKey("cc")&&map.containsKey("aa")&&map.containsKey("zz"));
        // refresh from first by get
        lruCashe1.getNod("cc");//bb,aa,zz,cc
        assert (map.containsKey("bb")&&map.containsKey("aa")&&map.containsKey("zz")&&map.containsKey("cc"));
        //put the same
        lruCashe1.putNod("xx",null);//aa,zz,cc,xx
        assert (map.containsKey("aa")&&map.containsKey("zz")&&map.containsKey("cc")&&map.containsKey("xx"));
        lruCashe1.putNod("xx",null);//aa,zz,cc,xx
        //get the last
        lruCashe1.getNod("xx");
        lruCashe1.getNod("xx");

        assert (map.containsKey("aa")&&map.containsKey("zz")&&map.containsKey("cc")&&map.containsKey("xx"));
        lruCashe1.putNod("uu",null);//zz,cc,xx,uu
        lruCashe1.putNod("vv",null);//cc,xx,uu,vv
        assert (map.containsKey("cc")&&map.containsKey("xx")&&map.containsKey("uu")&&map.containsKey("vv"));

        //refresh from mid by get
        lruCashe1.getNod("uu");//cc,xx,vv,uu
        assert (map.containsKey("cc")&&map.containsKey("xx")&&map.containsKey("vv")&&map.containsKey("uu"));
        lruCashe1.putNod("ii",null);//xx,vv,uu,ii
        assert (map.containsKey("xx")&&map.containsKey("vv")&&map.containsKey("uu")&&map.containsKey("ii"));
        lruCashe1.putNod("mm",null);//vv,uu,ii,mm
        assert (map.containsKey("vv")&&map.containsKey("uu")&&map.containsKey("ii")&&map.containsKey("mm"));

        assert (map.containsKey("vv")&&map.containsKey("uu")&&map.containsKey("ii")&&map.containsKey("mm"));

        lruCashe1.putNod("hh",null);//uu,ii,mm,hh
        assert (map.containsKey("uu"));
        assert (map.containsKey("ii"));
        assert (map.containsKey("mm"));
        assert (map.containsKey("hh"));
        //refresh from mid by put
        lruCashe1.putNod("mm",null);//uu,ii,hh,mm
        lruCashe1.putNod("jj",null);//ii,hh,mm,jj
        lruCashe1.putNod("pp",null);//hh,mm,jj,pp
        assert (map.containsKey("hh")&&map.containsKey("mm")&&map.containsKey("jj")&&map.containsKey("pp"));
        lruCashe1.putNod("nn",null);//mm,jj,pp,nn
        assert (map.containsKey("mm")&&map.containsKey("jj")&&map.containsKey("pp")&&map.containsKey("nn"));


    }
    @Test
    public void anotherTest(){
        LRUCashe <Integer,String> lruCashe3=new LRUCashe(4);
        lruCashe3.putNod(new Integer(123),"bubd");
        lruCashe3.putNod(618,"vbnbvbn");
        lruCashe3.putNod(619,"dddd");
        lruCashe3.putNod(123,"dafaq");
        lruCashe3.putNod(618,"dfdfdffff");
        lruCashe3.putNod(233,"fff");
        lruCashe3.putNod(659,"fffff");
        System.out.println(lruCashe3.getNod(123));
        System.out.println(lruCashe3.getNod(618));
        System.out.println(lruCashe3.getNod(619));
        System.out.println(lruCashe3.getNod(659));
        System.out.println(lruCashe3.getNod(233));

    }


}
