import java.util.ArrayList;

/**
 * Created by Anton on 16.11.2017.
 */
public class Heap<T> {


    private ArrayList<Comparable> list = new ArrayList<Comparable>();


    public void add(Comparable<T> element) {


        list.add(element);
        int position = list.size() - 1;
        int parent = (position - 1) / 2;
        while (position > 0 && list.get(position).compareTo(list.get(parent)) < 0) {
            Comparable temp = list.get(position);
            list.set(position, list.get(parent));
            list.set(parent, temp);
            position = parent;
            parent = (position - 1) / 2;
        }
    }

    public void heapify(int i) {

        int leftch;
        int rightch;
        int min;


        while (true) {
            min = i;
            leftch = 2 * i + 1;
            rightch = 2 * i + 2;


            if (leftch < list.size() && list.get(leftch).compareTo(list.get(min)) < 0) {

                min = leftch;
            }
            if (rightch < list.size() && list.get(rightch).compareTo(list.get(min)) < 0) {

                min = rightch;
            }
            if (min == i) {
                break;
            }
            Comparable temp = list.get(min);
            list.set(min, list.get(i));
            list.set(i, temp);
            i = min;
        }

    }

    public Comparable getMin() {
        if (list.size() > 0) {
            Comparable result = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            heapify(0);

            return result;
        } else return null;
    }


    public static void main(String[] args) {

        Heap<Integer> heap = new Heap();

        for (int i = 0; i <10 ; i++) {
            heap.add((int)(Math.random()*99));
        }


        for (int i = 0; i <11 ; i++) {
            System.out.println(heap.getMin());
        }


    }


}
