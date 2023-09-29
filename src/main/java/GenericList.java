import java.util.ArrayList;
import java.util.Iterator;

public abstract class GenericList<T> implements Iterable<T> {
    private Node<T> head; // Initialize a head for the LL
    private int length; // Initialize length to keep track of length of LL
    // Subclass node for linked list
    public class Node<T> {
        private T data;
        private int code;
        private Node<T> next;
        // Node constructor
        public Node(T data, int code) {
            this.data = data;
            this.code = code;
            this.next = null;
        }
    }
    // Print method, checks if not null first, if null prints "empty string", if not iterates through linked list printing the linked list printing data for each node
     public void print() {
         if (head == null) {
             System.out.print("Empty String");
         }
         else {
             Node<T> current = head;
             while(current != null) {
                 System.out.print(current.data);
                 current = current.next;
             }
         }
     }
    // Add method, is abstract due to can be implemented differently depending on the data structure
    public abstract void add(T data);
    // Delete method, is abstract due to can be implemented differently depending on the data structure
    public abstract T delete();
    // DumpList method, creates an ArrayList then loops through the LL and dumps all nodes into the array
    public ArrayList<T> dumpList() {
        ArrayList<T> listDump = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            listDump.add(current.data);
            current = current.next;
        }
        return listDump;
    }
    // Get method, returns the value at the specified index or null if the index is out of bounds
    public T get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    // Set method, replace the element at specified position in the list with the specified element and return the element previously at the specified position. Return null if index is out of bounds
    public T set(int index, T element) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T previousData = current.data;
        current.data = element;
        return previousData;
    }
    // Returns length of LL
    public int getLength() {
        return length;
    }
    // Sets the length of LL
    public void setLength(int length) {
        this.length = length;
    }
    // Returns head of LL
    public Node<T> getHead() {
        return head;
    }
    // Sets the head of LL
    public void setHead(Node<T> head) {
        this.head = head;
    }
}
