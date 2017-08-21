package SinglyLinkedlist;

public class Main {

    // Created to basically test SinglyLinkedList
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(0);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(3, 2);
        System.out.println(list);
        System.out.println();

        list.addFirst("First");
        list.addLast("Last");
        System.out.println(list);

        System.out.println(list);


        list.removeFirst();
        list.removeLast();
        System.out.println(list);


        // Removes the item in the specified index
        list.remove(2);
        System.out.println(list);

        // Removes the first occurrence of the specified object
        list.remove(new Integer(1));
        System.out.println(list);

        list.removeFirst(2);
        System.out.println(list);

        list.removeLast(4);
        System.out.println(list);

        list.removeAll(5);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        
        System.out.println(list);
    }
}