

import java.util.HashMap;

/**
 * Created by Anton on 24.10.2017.
 */
public class LRUCashe<K, V> {

    HashMap<K, Node> map = new HashMap();
    int capacity;
    //first=old,first candidate to b deleted; last=fresh,"just used"
    Node first;
    Node last;

    class Node {
        Node previous;
        K key;
        V value;
        Node next;

        public Node(Node previous, K key, V value, Node next) {
            this.previous = previous;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "NODE(key:" + key + "," + "value:" + value + ")";
        }
    }

    public LRUCashe(int capacity) {
        if (capacity < 3) {
            System.out.println("make it at least 3 dude...");
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }

    public void putNod(K key, V value) {
        if (map.size() == 0) {
            Node nod = new Node(null, key, value, null);
            map.put(key, nod);
            first = nod;
            last = nod;
        } else {

            if (map.containsKey(key)) {
                Node refreshed = map.get(key);
                if (refreshed == last) {
                    // should cashed value be replaced with new value? if yeas then
                    refreshed.value = value;

                    ;
                } else if (refreshed == first) {
                    /*
                    refreshed.value=value;
                    first = refreshed.next;
                    first.previous = null;
                    refreshed.next=null;
                    refreshed.previous = last;
                    last=refreshed;
                    */
                    // should cashed value be replaced with new value? if yeas then
                    refreshed.value = value;

                    //make link from current last element to new last elment
                    last.next = first;
                    //make link from new to carrent last element
                    first.previous = last;
                    //find what element will be first
                    Node tobe1st = first.next;
                    //as future first element it should have previous
                    tobe1st.previous = null;
                    //and future last element should not have next
                    first.next = null;
                    //declare first as last
                    last = first;
                    //and declare tobe1st as first

                    first = tobe1st;
                } else {
                    // should cashed value be replaced with new value? if yeas then
                    refreshed.value = value;

                    refreshed.previous.next = refreshed.next;
                    refreshed.next.previous = refreshed.previous;

                    refreshed.previous = last;
                    refreshed.next = null;
                    //вот этой одной строчкой ссылку забыл перекинуть -  и жЁпа
                    last.next = refreshed;
                    last = refreshed;
                }
            } else {
                if (map.size() < capacity) {

                    Node nod = new Node(last, key, value, null);
                    last.next = nod;
                    last = nod;
                    map.put(key, nod);

                } else {

                    map.remove(first.key);
                    Node toBeFirst = first.next;
                    toBeFirst.previous = null;
                    first = toBeFirst;
                    Node nod = new Node(last, key, value, null);
                    last.next = nod;
                    last = nod;
                    map.put(key, nod);

                }
            }

        }
    }

    Node getNod(K key) {
        if (map.containsKey(key)) {
            Node refreshed = map.get(key);
            if (refreshed == last) {
                ;
            } else if (refreshed == first) {

                //make link from current last element to new last elment
                last.next = first;
                //make link from new to carrent last element
                first.previous = last;
                //find what element will be first
                Node tobe1st = first.next;
                //as future first element it should have previous
                tobe1st.previous = null;
                //and future last element should not have next
                first.next = null;
                //declare first as last
                last = first;
                //and declare tobe1st as first

                first = tobe1st;
            } else {
                refreshed.previous.next = refreshed.next;
                refreshed.next.previous = refreshed.previous;

                refreshed.previous = last;
                refreshed.next = null;
                //вот этой одной строчкой ссылку забыл перекинуть -  и жЁпа
                last.next = refreshed;
                last = refreshed;
            }

            return refreshed;
        } else {
            System.out.println("no sach key");
            return null;
        }

    }


}

