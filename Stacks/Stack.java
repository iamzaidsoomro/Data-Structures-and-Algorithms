/*
    Stack is an abstract data structure that follows LIFO rule, means Last In First Out.
    In this data structure, the Last item is inserted first, and at the time of removing, 
    the first item is removed. The best real life example for this is the stack of books, 
    stake of plates etc.
*/
package Stacks;

class Stack {
    /*
     * This is the Node class that is a blueprint for the item in the stack,
     * The class contains two fields, data for holding integer value, and Node
     * variable for storing address to next node.
     */
    public static void main(String[] args) {
        var obj = new Stack();
        obj.push(5);
        obj.push(3);
        obj.push(7);
    }

    private class Node {
        private int data;
        private Node next;

        /*
         * The contructor will ask value at the creation of the node for avoiding errors
         */
        private Node(int data) {
            this.data = data;
        }
    }

    /*
     * An empty constructor for dynamic stack
     */
    public Stack() {
    }

    /*
     * Constructor will take the maximum size for the stack at the time of creation,
     * this will allow programmer to limit the size of items in a single stack
     */
    public Stack(int qty) {
        if (qty < 0)
            System.out.println("Limit should be a postive integer");
        else
            this.qty = qty;
    }

    /*
     * These four fields are contained by Stack class for storing meta data about a
     * single stack
     * qty: for storing the maximum size of items in a single stack
     * count: for storing current number of items in a single stack
     * head: for storing top element of a stack
     * tail: for storing the bottom element of a stack
     */
    private int qty = -1;
    private int count = 0;
    private Node head;
    private Node tail;

    /*
     * push() method will add a new node at the top of the stack, if the stack is
     * empty, will also add at the tail position, and if the stack is static and
     * full, it will show message "The stack is full"
     */
    public void push(int data) {
        var temp = new Node(data);
        if (isEmpty()) {
            head = tail = temp;
            count++;
        } else if (isFull())
            System.out.println("The Stack is full!");
        else {
            temp.next = head;
            head = head.next;
            head = temp;
            count++;
        }
    }

    /*
     * pop() method will remove the top element from the stack, and if the stack is
     * empty, it will show message "Stack is empty"
     */
    public void pop() {
        if (isEmpty())
            System.out.println("Stack is empty");
        else {
            head = head.next;
            count--;
        }
    }

    /*
     * peek() method will return the data of the top element, if it exists,
     * otherwise it will show "Stack is empty" message
     */
    public int peek() {
        return head.data;
    }

    /*
     * print() method will print the data of the stack
     */
    public void print() {
        var temp = head;
        if (isEmpty())
            System.out.println("Stack is empty");
        else {
            for (int i = 0; i < count; i++) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    /*
     * getSize() method will return the current number of elements in a single stack
     */
    public int getSize() {
        return this.count;
    }

    /*
     * isEmpty() method will return boolean after checking if the stack is empty or
     * not
     */
    public boolean isEmpty() {
        return tail == null;
    }

    /*
     * isFull() method will return boolean after checking if the stack is static and
     * is full or not
     */
    public boolean isFull() {
        return this.count == this.qty;
    }
}
