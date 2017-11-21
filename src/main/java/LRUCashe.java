

import java.util.HashMap;

/**
 * Created by Anton on 24.10.2017.
 */
public class LRUCashe<K, V> {

    private HashMap<K, Node> map = new HashMap<K, Node>();
    private int capacity;
    //first=old,first candidate to b deleted; last=fresh,"just used"
    private Node first;
    private Node last;

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

    }

    public LRUCashe(int capacity) {
        if (capacity < 3) {
            System.out.println("make it at least 3 dude...");
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        if (key != null) {
            if (map.size() == 0) {
                Node nod = new Node(null, key, value, null);
                map.put(key, nod);
                first = nod;
                last = nod;
            } else {

                if (map.containsKey(key)) {
                    Node refreshed = map.get(key);
                    if (refreshed == last) {

                        refreshed.value = value;


                    } else if (refreshed == first) {

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

                        refreshed.value = value;

                        refreshed.previous.next = refreshed.next;
                        refreshed.next.previous = refreshed.previous;

                        refreshed.previous = last;
                        refreshed.next = null;

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
        } else {
            System.out.println("don't put value with null key!");
        }
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node refreshed = map.get(key);

            if (refreshed == first) {


                last.next = first;

                first.previous = last;

                Node tobe1st = first.next;

                tobe1st.previous = null;

                first.next = null;

                last = first;


                first = tobe1st;
            } else if (refreshed != last) {
                refreshed.previous.next = refreshed.next;
                refreshed.next.previous = refreshed.previous;

                refreshed.previous = last;
                refreshed.next = null;

                last.next = refreshed;
                last = refreshed;
            }

            return refreshed.value;
        } else {
            System.out.println("no such key.");
            return null;
        }

    }

    public V removeFirst() {
        V result = null;
        if (first != null && first != last) {
            result = first.value;
            map.remove(first.key);
            first = first.next;
            first.previous = null;
        } else if (first != null && first == last) {
            result = first.value;
            map.remove(first.key);
            first.value = null;
            last.value = null;
            first = null;
            last = null;
        }

        return result;
    }


}

