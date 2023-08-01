package implementations.ds;

public class DoublyLinkedList {

    public static class Node {
        private int val;
        private Node next;
        private Node prev;

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
            newNode.prev = itr;
        }
        print(head);
        return head;
    }

    public static Node insertAtIndex(Node head, int val, int index) {
        if (head == null) return insert(null, val);
        Node newNode = new Node(val);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node itr = head;
            while (index > 1) {
                if (itr.next == null) {
                    System.out.println("Can't Insert at Given Index !");
                    return head;
                }
                itr = itr.next;
                index--;
            }
            if (itr.next == null) {
                itr.next = newNode;
                newNode.prev = itr;
            } else {
                newNode.next = itr.next;
                newNode.prev = itr;
                itr.next.prev = newNode;
                itr.next = newNode;
            }
        }
        return head;
    }

    public static Node deleteAtIndex(Node head, int index) {
        if (head == null) {
            System.out.println("List is Empty !");
            return null;
        } else if (index == 0) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        } else {
            Node itr = head;
            while (index > 0) {
                itr = itr.next;
                if (itr == null) {
                    System.out.println("Can't Delete Given Index !");
                    return head;
                }
                index--;
            }
            if (itr.next == null) {
                itr.prev.next = null;
                itr.prev = null;
            } else {
                itr.prev.next = itr.next;
                itr.next.prev = itr.prev;
            }
        }
        return head;
    }

    public static Node rotate(Node head) {
        Node itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }
        itr.prev.next = null;
        itr.prev = null;
        itr.next = head;
        head.prev = itr;
        head = itr;
        return head;
    }

    public static int lengthOfList(Node head) {
        if (head == null) return 0;
        return 1 + lengthOfList(head.next);
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
        head = rotate(head);
        print(head);
        head = rotate(head);
        print(head);
        System.out.println("Length Of List : " + lengthOfList(head));
    }

}
