import java.util.HashMap;

/**
 * Created by Anton on 24.10.2017.
 */
public class LRUCashe {

    HashMap<String,Node> map=new HashMap();
    int capacity;
    //first=old,first candidate to b deleted; last=fresh,"just used"
    Node first;
    Node last;
    class Node{
        Node previous;
        String key;
        String value;
        Node next;

        public Node(Node previous,String key,String value,Node next ){
            this.previous=previous;
            this.key=key;
            this.value=value;
            this.next=next;

        }
        @Override
        public String toString(){
            return "NODE(key:"+key+","+"value:"+value+")";
        }

    }
    LRUCashe(int capacity){
        if(capacity<3){
            System.out.println("make it at least 3 dude...");
            throw new IllegalArgumentException();
        }
        this.capacity=capacity;
    }
    public void putNod(String key, String value) {
        if (map.size() == 0) {
            Node nod = new Node(null, key, value, null);
            map.put(key, nod);
            first = nod;
            last = nod;
        }

        else {

            if (map.containsKey(key)) {
                Node refreshed = map.get(key);
                if(refreshed.equals(last)){
                    ;}
                else if (refreshed.equals(first)){
                    last.next=refreshed;
                    refreshed.previous=last;
                    last=refreshed;
                    Node tobe1st=first.next;
                    tobe1st.previous=null;
                    first=tobe1st;}
                else{
                    refreshed.previous.next=refreshed.next;
                    refreshed.next.previous=refreshed.previous;

                    refreshed.previous = last;
                    refreshed.next = null;
                    //вот этой одной строчкой ссылку забыл перекинуть -  и жЁпа
                    last.next=refreshed;
                    last=refreshed;
                }
            }
            else{
                if (map.size()<capacity){

                    Node nod = new Node(last, key, value, null);
                    last.next = nod;
                    last = nod;
                    map.put(key, nod);

                }
                else {

                    map.remove(first.key);
                    Node toBeFirst=first.next;
                    toBeFirst.previous=null;
                    first=toBeFirst;
                    Node nod = new Node(last, key, value, null);
                    last.next = nod;
                    last = nod;
                    map.put(key, nod);

                }
            }

        }


    }
    Node getNod(String key){
        Node refreshed = map.get(key);
        if(refreshed.equals(last)){
            ;}
        else if (refreshed.equals(first)){
            last.next=refreshed;
            refreshed.previous=last;
            last=refreshed;
            Node tobe1st=first.next;
            tobe1st.previous=null;
            first=tobe1st;}
        else{
            refreshed.previous.next=refreshed.next;
            refreshed.next.previous=refreshed.previous;

            refreshed.previous = last;
            refreshed.next = null;
            //вот этой одной строчкой ссылку забыл перекинуть -  и жЁпа
            last.next=refreshed;
            last=refreshed;
        }

        return refreshed;
    }
}
