package Linked_List;

class CircularLinkedList {

    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int length, limit;

    public CircularLinkedList() {
        length = 0;
        limit = -1;
    }

    public CircularLinkedList(int limit) {
        if (limit >= 0) {
            this.limit = limit;
            this.length = 0;
        } else {
            System.out.println("WARNING! Limit can't be negative");
        }
    }

    public void addLast(int data) {
        var temp = new Node(data);
        if (isEmpty()) {
            head = tail = temp;
            length++;
        } else if (isFull()) {
            System.out.println("List is full");
        } else {
            tail.next = temp;
            tail = temp;
            tail.next = head;
            length++;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Item doesn't exists");
        } else {
            var temp = head;
            while (temp.next != head) {
                temp = temp.next;
                if (temp.next.next == head) {
                    temp.next = head;
                }
            }
            tail = temp;
            length--;
        }
    }

    public void addFirst(int data) {
        var temp = head;
        if (isEmpty()) {
            head = tail = temp;
            length++;
        } else if (isFull()) {
            System.out.println("List is full");
        } else {
            tail.next = temp;
            temp.next = head;
            head = temp;
            length++;
        }
    }

    public void removeFirst() {
        if (isEmpty())
            System.out.println("The list is empty");
        else {
            head = head.next;
            tail.next = head;
            length--;
        }
    }

    public void print() {
        var temp = head;
        for (int i = 0; i < length; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void linkTo(CircularLinkedList l) {
        this.tail.next = l.head;
        l.tail.next = this.head;
        this.tail = l.tail;
        this.length += l.length;
    }

    public boolean isFull() {
        return limit == length;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
