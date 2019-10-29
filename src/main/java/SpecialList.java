import java.util.NoSuchElementException;

/**
 * Created by Anton on 03.11.2017.
 */

public class SpecialList<T> {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    class Node {
        private T element;
        Node next = null;
        Node previous = null;

        public Node(T element) {

            this.element = element;
        }

    }

    public int size(){
        return size;
    }

    public T removeLast() {
        T element = null;
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            element = tail.element;
            head = null;
            tail = null;
            size--;
        } else {
            element = tail.element;
            tail = tail.previous;
            tail.next = null;
            size--;
        }
        return element;


    }

    public void addElement(T element) {

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

    private void printAllNodeElement(Node node) {
        if (node.previous == null) System.out.println(node.element);
        if (node.next != null) {
            System.out.println(node.next.element);

            printAllNodeElement(node.next);
        }


    }

    private void ReverseAllNodeElement(Node node) {
        if (node.next != null) {
            Node shadow = node.previous;
            if (shadow == null) {
                tail = node;
            } else {
                if (shadow != null) {
                    Node temp = node;
                    shadow.next = shadow.previous;
                    shadow.previous = temp;
                }

            }
            node = node.next;
            ReverseAllNodeElement(node);
        } else {
            Node shadow = node.previous;
            shadow.next = shadow.previous;
            shadow.previous = node;
            node.next = shadow;
            node.previous = null;
            head = node;
        }
    }

    public void printAllvalues() {

        printAllNodeElement(head);
    }

    public void reverse() {
        ReverseAllNodeElement(head);

    }


    public static void main(String[] args) {
        SpecialList<String> list = new SpecialList<String>();
        list.addElement("aa");
        list.addElement("bb");
        list.addElement("cc");
        list.addElement("dd");

        list.printAllvalues();
        System.out.println("************");

        list.reverse();

        System.out.println("************");

        list.printAllvalues();

    }


}


