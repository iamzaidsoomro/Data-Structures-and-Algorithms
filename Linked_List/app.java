package Linked_List;

public class app {
    public static void main(String args[]) {

    }
}

class CircularLinkedList {

    private class Node {
        private int data;
        private Node next;
        private int index;

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

}
