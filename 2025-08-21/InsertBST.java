class BST {
    int val;
    BST left, right;
    BST(int x) { val = x; }
}

public class InsertBST {
    public static BST insert(BST root, int key) {
        if (root == null) return new BST(key);
        if (key < root.val)
            root.left = insert(root.left, key);
        else if (key > root.val)
            root.right = insert(root.right, key);
        return root;
    }

    public static void inorder(BST root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BST root = null;
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for (int key : keys) root = insert(root, key);

        System.out.print("Inorder after insertion: ");
        inorder(root);
    }
}
