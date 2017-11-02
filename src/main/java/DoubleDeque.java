import java.util.NoSuchElementException;

/**
 * Created by Anton on 02.11.2017.
 */
public class DoubleDeque<T> {
    private int capasity=16;
    private int size=0;
    private Node head=null;
    private Node tail=null;

    public DoubleDeque(){

    }

    public DoubleDeque(int capasity){
        this.capasity=capasity;
    }
    class Node{
        private T element;
        Node next=null;
        Node previous=null;
        public Node(T element){
            this.element=element;
        }
    }

    public int size(){
        return this.size;
    }

    public void addLastElement(T element){
        if(size<capasity) {
            Node node = new Node(element);
            if (size == 0) {
                head = node;
                tail = node;
                node.next = null;
                node.previous = null;
                size++;
            } else {
                tail.next = node;
                node.previous = tail;
                tail = node;
                size++;
            }
        }
        else {throw new IllegalStateException();}

    }

    public void addFirstElement(T element){
        if(size<capasity) {
            Node node = new Node(element);
            if (size == 0) {
                head = node;
                tail = node;
                node.next = null;
                node.previous = null;
                size++;
            } else {
                head.previous=node;
                node.next=head;
                head=node;
                size++;
            }
        }
        else {throw new IllegalStateException();}

    }

    public boolean offerLastElement(T element){
        if(size<capasity) {
            Node node = new Node(element);
            if (size == 0) {
                head = node;
                tail = node;
                node.next = null;
                node.previous = null;
                size++;
            } else {
                tail.next = node;
                node.previous = tail;
                tail = node;
                size++;
            }
            return true;
        }
        else return false;

    }

    public boolean offerFirstElement(T element){
        if(size<capasity) {
            Node node = new Node(element);
            if (size == 0) {
                head = node;
                tail = node;
                node.next = null;
                node.previous = null;
                size++;
            } else {
                head.previous=node;
                node.next=head;
                head=node;
                size++;
            }
            return true;
        }
        else return false;

    }

    public  T removeFirst(){
        T element=null;
        if(size==0){
            throw new NoSuchElementException();
        }
        if(size==1){
            element= head.element;
            head=null;
            tail=null;
            size--;
        }
        else {element= head.element;
            head=head.next;
            head.previous=null;
            size--;
        }
        return element;
    }

    public T removeLast(){
        T element=null;
        if(size==0){
            throw new NoSuchElementException();
        }
        if(size==1){
            element= tail.element;
            head=null;
            tail=null;
            size--;
        }
        else {element= tail.element;
            tail=tail.previous;
            tail.next=null;
            size--;
        }
        return element;


    }

    public  T pollFirst(){
        T element=null;
        if(size==0){
            return null;
        }
        if(size==1){
            element= head.element;
            head=null;
            tail=null;
            size--;
        }
        else {element= head.element;
            head=head.next;
            head.previous=null;
            size--;
        }
        return element;
    }

    public T pollLast(){
        T element=null;
        if(size==0){
            return null;
        }
        if(size==1){
            element= tail.element;
            head=null;
            tail=null;
            size--;
        }
        else {element= tail.element;
            tail=tail.previous;
            tail.next=null;
            size--;
        }
        return element;

    }
    public T elementFirst(){
        T element=null;
        if(size==0){
            throw new NoSuchElementException();
        }
        else element=head.element;
        return element;
    }

    public T elementLast(){
        T element=null;
        if(size==0){
            throw new NoSuchElementException();
        }
        else element=tail.element;
        return element;
    }

    public T peekFirst(){
        T element=null;
        if(size==0){
            return null;
        }
        else element=head.element;
        return element;
    }

    public T peekLast(){
        T element=null;
        if(size==0){
            return null;
        }
        else element=tail.element;
        return element;
    }

    public static void main(String[] args) {
        DoubleDeque<String> doubleDeque=new DoubleDeque();
        doubleDeque.addLastElement("first");
        doubleDeque.addLastElement("second");
        doubleDeque.addLastElement("third");
        doubleDeque.addLastElement("fourth");
        doubleDeque.addLastElement("fifth");
        doubleDeque.addFirstElement("veryfirst");
        System.out.println("size "+doubleDeque.size());
        System.out.println("get 1st: "+doubleDeque.elementFirst()+",new size "+doubleDeque.size());
        System.out.println("get last: "+doubleDeque.elementLast()+",new size "+doubleDeque.size());
        System.out.println("remove 1st: "+doubleDeque.removeFirst()+",new size "+doubleDeque.size());
        System.out.println("remove 1st: "+doubleDeque.removeFirst()+",new size "+doubleDeque.size());
        System.out.println("remove last:  "+doubleDeque.removeLast()+",new size "+doubleDeque.size());
        System.out.println("remove last:  "+doubleDeque.removeLast()+",new size "+doubleDeque.size());
        System.out.println("remove 1st: "+doubleDeque.removeFirst()+",new size "+doubleDeque.size());
        System.out.println("size "+doubleDeque.size());
        System.out.println("peeklast :"+doubleDeque.peekLast()+",new size "+doubleDeque.size());
        System.out.println("peekfirst :"+doubleDeque.peekFirst()+",new size "+doubleDeque.size());
        System.out.println("poll last: "+doubleDeque.pollLast()+",new size "+doubleDeque.size());
        //System.out.println("remove last: "+doubleDeque.removeLast()+",new size "+doubleDeque.size());
        System.out.println("poll last: "+doubleDeque.pollLast()+",new size "+doubleDeque.size());


    }



}

