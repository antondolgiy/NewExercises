import java.util.NoSuchElementException;

/**
 * Created by Anton on 03.11.2017.
 */

 public class SpecialList<T> {
        int size=0;
        private Node head=null;
        private Node tail=null;

        class Node{
            private T element;
            Node next=null;
            Node previous=null;
            public Node(T element){
                this.element=element;
            }

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

        public void addElement(T element){

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

        public static SpecialList reverseList(SpecialList list){
            SpecialList list1 =new SpecialList();
            while (list.size>0){
                list1.addElement(list.removeLast());
            }

            return list1;
        }

        private   void printAllNodeElement(Node node){
            if(node.previous==null) System.out.println(node.element);
            if(node.next!=null){
                System.out.println(node.next.element);
                
                printAllNodeElement(node.next);
            }



        }

        private   void SwapAllNodeElement(Node node){

            if(node.next!=null){
                Node shadow=node.previous;
                if(shadow==null){

                    tail=node;}
                else {
                    if(shadow!=null){
                        Node temp=null;
                        temp=shadow.next;
                        shadow.next=shadow.previous;
                        shadow.previous=temp;
                    }

                }
                node=node.next;
                SwapAllNodeElement(node);
            }
            else {
                Node shadow=node.previous;
                Node temp=null;
                temp=shadow.next;
                shadow.next=shadow.previous;
                shadow.previous=temp;
                node.next=shadow;
                node.previous=null;
                head=node;

            }
        }

        public void printAllvalues(){
            printAllNodeElement(head);
        }
        public void swapAll(){
            SwapAllNodeElement(head);

        }









        public static void main(String[] args) {
            SpecialList<String> list=new SpecialList<String>();
            list.addElement("aa");
            list.addElement("bb");
            list.addElement("cc");
            list.addElement("dd");

            list.printAllvalues();
            System.out.println("************");

            list.swapAll();

            System.out.println("************");

            list.printAllvalues();

        }



    }


