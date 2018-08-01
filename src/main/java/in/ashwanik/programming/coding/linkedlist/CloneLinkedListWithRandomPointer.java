package in.ashwanik.programming.coding.linkedlist;

public class CloneLinkedListWithRandomPointer {

    public static class Node {
        public int data;
        public Node next;
        public Node random;

        public Node(int data) {
            this.data = data;
        }
    }


    public Node cloned(Node head) {

        Node clonedHead = null;

        if (head == null) {
            return head;
        }
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = new Node(current.data);
            current.next.next = next;
            current = next;
        }

        current = head;

        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        clonedHead = head.next;
        while (current != null) {
            Node temp = current.next;
            current.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            current = current.next;
        }
        return clonedHead;
    }
}
