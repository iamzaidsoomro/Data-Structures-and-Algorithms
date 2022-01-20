/*
    A linked list is a linear data structure, in which the elements are not stored at contiguous memory 
    locations.
*/
package Linked_List;

/*
    LinkedList class that contains all the basic methods and fields for making and manipulating a
    Linked List Data Structure.
*/
class LinkedList {
    /*
     * Node class contains the structure for each element in a Linked List
     */
    private class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    /*
     * Basic Fields in a Linked List
     */
    private Node head;
    private Node tail;
    private int count = 0;
    private int limit = -1;

    public LinkedList() {

    }

    /*
     * Constructor for creating static Linked List
     */
    public LinkedList(int limit) {
        if (limit < 0)
            System.out.println("Limit should be a postive integer");
        else
            this.limit = limit;
    }

    // addLast() method to add node at the end of the list
    public void addLast(int data) {
        var temp = new Node(data);
        if (isFull())
            System.out.println("List is full");
        else if (isEmpty()) {
            head = tail = temp;
            count++;
        } else {
            tail.next = temp;
            tail = temp;
            count++;
        }
    }

    // removeLast() method to remove node from the end of the list
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Item doesn't exists");
        } else {
            var temp = head;
            while (temp.next != null) {
                temp = temp.next;
                if (temp.next.next == null) {
                    temp.next = null;
                }
            }
            tail = temp;
            count--;
        }
    }

    // addFirst() method for adding element at the start of list
    public void addFirst(int data) {
        var temp = new Node(data);
        if (isFull())
            System.out.println("List is full");
        else if (isEmpty()) {
            head = tail = temp;
            count++;
        } else {
            temp.next = head;
            head = temp;
            count++;
        }
    }

    // removeFirst() method for removing element from the start of the list
    public void removeFirst() {
        if (isEmpty())
            System.out.println("List is empty");
        else {
            head = head.next;
            count--;
        }
    }

    // print() method to print all the elements in a list
    public void print() {
        var temp = head;
        for (int i = 0; i < count; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /*
     * contains method to check if the element is in the list or not, the method
     * returns a boolean value
     */
    public boolean contains(int item) {
        var obj = head;
        for (int i = 0; i < count; i++) {
            if (obj.data == item) {
                return true;
            }
            obj = obj.next;
        }
        return false;
    }

    // indexOf() method returns the index of an specific element in the list
    public int indexOf(int item) {
        var temp = head;
        for (int i = 0; i < count; i++) {
            if (temp.data == item) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    // find largest() method to find the largest element in the linked list
    public int findHighest() {
        int highest = 0;
        var temp = head;
        for (int i = 0; i < count; i++) {
            if (temp.data >= highest) {
                highest = temp.data;
            }
            temp = temp.next;
        }
        return highest;
    }

    // link to another linkedlist
    public void linkTo(LinkedList l) {
        this.tail.next = l.head;
        this.count += l.count;
    }

    // getCount() method returns the number of elements in the list
    public int getCount() {
        return count;
    }

    // getSize() method returns the size of the list if it is static
    public int getSize() {
        return limit;
    }

    // isEmpty() method to check if the list is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    // isFull() method to check if the list is full or not
    public boolean isFull() {
        return count == limit;
    }
}