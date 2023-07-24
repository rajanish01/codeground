package implementations.ds;

public class Tree {

    public static class Node {
        private final int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public static int printHeight(Node root) {
        if (root == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = printHeight(root.left);
            int rDepth = printHeight(root.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public static Node insertNode(Node root, int num) {
        Node newNode = new Node(num);
        if (root == null) {
            root = newNode;
        } else {
            if (num > root.value) {
                root.right = insertNode(root.right, num);
            } else {
                root.left = insertNode(root.left, num);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root, 8);
        root = insertNode(root, 21);
        root = insertNode(root, 6);
        root = insertNode(root, 3);
        root = insertNode(root, 41);
        root = insertNode(root, 22);
        root = insertNode(root, 30);
        root = insertNode(root, 86);
        root = insertNode(root, 1);
        root = insertNode(root, 94);
        root = insertNode(root, 55);

        System.out.print("PreOrder : \n");
        preOrder(root);
        System.out.println("\nInOrder : ");
        inOrder(root);
        System.out.println("\nPostOrder : ");
        postOrder(root);
        System.out.println("\nHeight : " + printHeight(root));

    }

}
