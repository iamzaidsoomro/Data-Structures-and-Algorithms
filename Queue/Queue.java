/*
    Queue is an abstract data structure, somewhat similar to Stacks. Unlike stacks, a queue 
    is open at both its ends. One end is always used to insert data (enqueue) and the other 
    is used to remove data (dequeue). Queue follows First-In-First-Out methodology (FIFO), 
    i.e., the data item stored first will be accessed first.
*/
/*
    This is the main Queue class that contains a private Node class and 2 constructors and 4 variables.
    Two are instance variables of Node class and other two are limit (for storing max capacity) and 
    count (for storing current number of items)
 */
class Queue {
    private class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private int limit = -1;
    private int count = 0;
    private Node head;
    private Node tail;

    /*
     * Empty constructor for non-static queue
     */
    public Queue() {

    }

    /*
     * Constructor to set limit of Queue to make it static
     */
    public Queue(int limit) {
        this.limit = limit;
    }

    /*
     * enqueue() method for adding elements in the queue
     */
    public void enqueue(int data) {
        var temp = new Node(data);
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            head = tail = temp;
            count++;
        } else {
            temp.next = head;
            head = temp;
            count++;
        }
    }

    /*
     * dequeue() method for removing elements from the queue
     */
    public void dequeue() {
        if (isEmpty())
            System.out.println("Queue is empty");
        else {
            var temp = head;
            if (count == 1) {
                head = null;
            } else {
                for (int i = 0; i < (count - 2); i++) {
                    temp = temp.next;
                }
                temp.next = null;
            }
            count--;
        }
    }

    /*
     * peek() method for checking the first element in the queue
     */
    public int peek() {
        if (isEmpty()) {
            System.out.print("Queue is empty, exited with value: ");
            return -1;
        } else {
            var temp = head;
            for (int i = 0; i < (count - 1); i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    /*
     * count() method for checking the number of elements in the queue
     */
    public int getCount() {
        return count;
    }

    /*
     * isFull() method for checking if the queue is full or not
     */
    public boolean isFull() {
        return limit == count;
    }

    /*
     * isEmpty() method for checking if the queue is empty or not
     */
    public boolean isEmpty() {
        return head == null;
    }
}