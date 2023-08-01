package implementations.ds;

public class LinkedList {

    public static class Node {
        private int val;
        private Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node insert(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node itr = head;
            while (itr.next != null) {
                itr = itr.next;
            }
            itr.next = newNode;
        }
        print(head);
        return head;
    }

    public static Node insertAtIndex(Node head, int val, int index) {
        if (head == null) {
            return insert(null, val);
        }
        Node newNode = new Node(val);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node itr = head;
            while (index > 1) {
                if (itr.next == null) {
                    System.out.println("Can't insert at given index !");
                    return head;
                }
                itr = itr.next;
                index--;
            }
            if (itr.next != null) {
                newNode.next = itr.next;
            }
            itr.next = newNode;
        }
        return head;
    }

    public static Node deleteAtIndex(Node head, int index) {
        if (head == null) {
            System.out.println("Linked List Is Empty !");
            return null;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node itr = head;
            while (index > 1) {
                itr = itr.next;
                index--;
            }
            if (itr.next.next == null) {
                itr.next = null;
            } else {
                itr.next = itr.next.next;
            }
        }
        return head;
    }

    public static Node reverse(Node head) {
        if (head == null) {
            System.out.println("Linked List Empty !");
            return null;
        } else {
            Node prev = head;
            Node curr = prev.next;
            prev.next = null;
            head = curr;
            while (head.next != null) {
                head = head.next;
                curr.next = prev;
                prev = curr;
                curr = head;
            }
            head.next = prev;
        }
        return head;
    }

    public static Node rotate(Node head) {
        if (head == null) {
            System.out.println("Linked List Empty !");
            return null;
        } else {
            Node itr = head;
            while (itr.next.next != null) {
                itr = itr.next;
            }
            Node last = itr.next;
            itr.next = null;
            last.next = head;
            head = last;
        }
        return head;
    }

    public static void print(Node head) {
        Node itr = head;
        while (itr != null) {
            System.out.print(itr.val + " ");
            itr = itr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 3);
        head = insert(head, 7);
        head = insert(head, 1);
        head = insert(head, 10);
        head = insert(head, 6);
        head = insert(head, 2);
        head = insert(head, 5);
        head = insertAtIndex(head, 9, 7);
        print(head);
        head = deleteAtIndex(head, 7);
        print(head);
        head = reverse(head);
        print(head);
        head = rotate(head);
        print(head);
        head = rotate(head);
        print(head);
    }

}
