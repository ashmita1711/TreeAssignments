import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int x) { val = x; }
}

public class BinaryTreeToBST {
    static int index = 0;

    public static void storeInorder(Node root, List<Integer> list) {
        if (root == null) return;
        storeInorder(root.left, list);
        list.add(root.val);
        storeInorder(root.right, list);
    }

    public static void arrayToBST(List<Integer> list, Node root) {
        if (root == null) return;
        arrayToBST(list, root.left);
        root.val = list.get(index++);
        arrayToBST(list, root.right);
    }

    public static void binaryTreeToBST(Node root) {
        List<Integer> list = new ArrayList<>();
        storeInorder(root, list);
        Collections.sort(list);
        index = 0;
        arrayToBST(list, root);
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        System.out.print("Inorder of Original Tree: ");
        inorder(root);

        binaryTreeToBST(root);

        System.out.print("\nInorder of Converted BST: ");
        inorder(root);
    }
}
