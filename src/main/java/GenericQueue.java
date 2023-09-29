public class GenericQueue<T> extends GenericList<T> {
    private Node<T> tail;

    public GenericQueue(T initialData) {
        super(); // Call the constructor of the base class (GenericList<T>)
        // Initialize the head and tail with the initial node containing data
        head = new Node<>(initialData);
        tail = head;
        length = 1;
    }

    public void add(T data) {
        // Add a new node with the data to the back of the queue
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public T delete() {
        // Delete and return the value of the last node in the list (queue)
        if (head == null) {
            return null; // The queue is empty
        }
        if (head == tail) {
            // Only one element in the queue
            T data = head.data;
            head = null;
            tail = null;
            length = 0;
            return data;
        } else {
            Node<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            T data = tail.data;
            tail = current;
            tail.next = null;
            length--;
            return data;
        }
    }

    public void enqueue(T data) {
        // Enqueue by adding to the back of the queue
        add(data);
    }

    public T dequeue() {
        // Dequeue by deleting from the front of the queue
        return delete();
    }

    public void add(T data, int code) {
        // Overloaded add method to add data and set code
        add(data);
        tail.code = code;
    }
}
