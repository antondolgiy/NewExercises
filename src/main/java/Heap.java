import java.util.ArrayList;

/**
 * Created by Anton on 16.11.2017.
 */
public class Heap {
    private ArrayList<Node> list = new ArrayList<Node>();


    class Node {
        Comparable element;
        int position;
        int leftchild;
        int rightchild;
        int parent;

        Node(Comparable element) {
            this.element = element;
            position = list.size();
            leftchild = 2 * position + 1;
            rightchild = 2 * position + 2;
            parent = (position - 1) / 2;
        }

        @Override
        public String toString() {
            return element + "(" + position+")";
        }


    }

    public void add(Comparable element) {
        Node node = new Node(element);

        list.add(node);

        if (node.position > 0) {
            while (node.parent >= 0 && node.element.compareTo(list.get(node.parent).element) < 0) {
                Comparable temp = node.element;
                node.element = list.get(node.parent).element;
                list.get(node.parent).element = temp;
                node = list.get(node.parent);

            }

        }

    }

    public Comparable getRootElement() {
        return list.get(0).element;
    }


    public static void main(String[] args) {

        Heap heap = new Heap();

        heap.add("uu");
        System.out.println(heap.list);
        heap.add("zz");
        System.out.println(heap.list);
        heap.add("ff");
        System.out.println(heap.list);
        heap.add("yy");
        System.out.println(heap.list);
        heap.add("kk");
        System.out.println(heap.list);
        heap.add("gg");
        System.out.println(heap.list);
        heap.add("dd");
        System.out.println(heap.list);
        heap.add("cc");
        System.out.println(heap.list);
        heap.add("aa");
        System.out.println(heap.list);
        heap.add("bb");
        System.out.println(heap.list);
        heap.add("dd");
        System.out.println(heap.list);
        heap.add("jj");
        System.out.println(heap.list);
        System.out.println(heap.list);
        System.out.println(heap.getRootElement());
    }


}
