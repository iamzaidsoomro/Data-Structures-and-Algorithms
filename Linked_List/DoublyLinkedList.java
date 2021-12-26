/*
 * Doubly Linked List is a variation of Linked list in which navigation is possible in both ways, 
 * either forward and backward easily as compared to Single Linked List.
 */
package Linked_List;

/*
 * Doubly Linked List class that contains a private node class and basic methods
 * needed for the manipulation of a doubly linked list
 */
class DoublyLinkedList {
    /*
     * private Node class that stores all the properties of an element in the list
     */
    private class Node {
        private int data, index = 0;
        private Node next, previous;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int length = 0, limit;

    public DoublyLinkedList() {
        limit = -1;
    }

    /*
     * Constructor for creating static Doubly Linked List
     */
    public DoublyLinkedList(int limit) {
        if (limit < 0) {
            System.out.println("Limit can't be negative");
        } else {
            this.limit = limit;
        }
    }

    // addFirst() method to add node at the start of the list
    public void addFirst(int data) {
        var temp = new Node(data);
        if (isEmpty()) {
            temp.index = 0;
            head = tail = temp;
            ++length;
        } else if (isFull()) {
            System.out.println("List is full");
        } else {
            temp.next = head;
            head.previous = temp;
            head = temp;
            ++length;
            temp = head.next;
            for (int i = 0; i < (length - 1); i++) {
                ++temp.index;
                temp = temp.next;
            }
        }
    }

    // removeFirst() method to remove node from the start of the list
    public void removeFirst() {
        var temp = head;
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else {
            if (length == 1) {
                tail = head = null;
                length = 0;
            } else {
                head = head.next;
                --length;
                for (int i = 0; i < (length); i++) {
                    --temp.index;
                    temp = temp.next;
                }
            }
        }
    }

    // addLast() method to add node at the end of the list
    public void addLast(int data) {
        var temp = new Node(data);
        if (isEmpty()) {
            temp.index = 0;
            head = tail = temp;
            ++length;
        } else if (isFull()) {
            System.out.println("List is full");
        } else {
            temp.index = tail.index + 1;
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
            ++length;
        }
    }

    // removeLast() method to remove node from the end of the list
    public void removeLast() {
        var temp = tail;
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else {
            if (length == 1) {
                tail = head = null;
                length = 0;
            } else {
                tail.previous.next = null;
                --length;
            }
        }
    }

    // addAt() method to add node at an specific index of the list
    public void addAt(int index, int data) {
        Node temp = head, new_item = new Node(data);
        boolean added = false;
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else if (length == 1) {
            tail = head = null;
            length = 0;
        } else {
            for (int i = 0; i < length; i++) {
                if (temp.index == index) {
                    new_item.previous = temp;
                    new_item.next = temp.next;
                    temp.next.previous = new_item;
                    temp.next = new_item;
                    ++length;
                    added = true;
                }
                if (!added) {
                    temp = temp.next;
                } else {
                    temp.index = temp.previous.index + 1;
                    temp = temp.next;
                }
            }
        }
    }

    // removeAt() method to remove node from an specific index of the list
    public void removeAt(int index) {
        var temp = head;
        boolean found = false;
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else if (length == 1) {
            tail = head = null;
            length = 0;
        } else {
            for (int i = 0; i < length; i++) {
                if (temp.index == index) {
                    temp.previous.next = temp.next;
                    --length;
                    found = true;
                }
                temp = temp.next;
                if (found) {
                    --temp.index;
                }
            }
        }
    }

    // replaceAt() method to replace an item in the list
    public void replaceAt(int index, int data) {
        Node temp = head, new_item = new Node(data);
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else if (length == 1) {
            tail = head = null;
            length = 0;
        } else {
            for (int i = 0; i < length; i++) {
                if (temp.index == index) {
                    new_item.previous = temp.previous;
                    new_item.next = temp.next;
                    temp.previous.next = new_item;
                    temp.next.previous = new_item;
                    new_item.index = temp.index;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    // printProperties() method to print the index, data, and address of the items
    // in tabular form
    public void printProperties() {
        var temp = head;
        System.out.println("Index\t|\tData\t|\tAddress\n---------------------------------------------------\n");
        for (int i = 0; i < length; i++) {
            System.out.println(temp.index + "\t|\t" + temp.data + "\t|\t" + temp);
            temp = temp.next;
        }
        System.out.println();
    }

    // printForward() method for printing elements in the forward direction
    public void printForward() {
        var temp = head;
        for (int i = 0; i < length; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // printBackward for printing elements in the backward direction
    public void printBackward() {
        var temp = tail;
        for (int i = 0; i < length; i++) {
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
        System.out.println();
    }

    // indexOf() method to find the index of an specific element in the list
    public int indexOf(int data) {
        var temp = head;
        for (int i = 0; i < length; i++) {
            if (data == temp.data)
                return temp.index;
            temp = temp.next;
        }
        return -1;
    }

    // isFull() method for checking if the list is full or not
    public boolean isFull() {
        return limit == length;
    }

    // isEmpty() method for checking if the list is empty or not
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    // getLength() method for getting the length of the list
    public int getLength() {
        return length;
    }
}