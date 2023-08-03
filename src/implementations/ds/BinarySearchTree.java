package implementations.ds;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static class Node {
        private int val;
        private Node right;
        private Node left;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    public static int heightOfTree(Node root) {
        if (root == null) return 0;
        return Math.max(1 + heightOfTree(root.left), 1 + heightOfTree(root.right));
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = insert(null, 3);
        root = insert(root, 7);
        root = insert(root, 1);
        root = insert(root, 10);
        root = insert(root, 6);
        root = insert(root, 2);
        root = insert(root, 5);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println("\nHeight : " + heightOfTree(root));

    }

}
