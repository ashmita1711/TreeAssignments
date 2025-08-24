public class DeleteBST {
    public static BST deleteNode(BST root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            // Case 1 & 2: 0 or 1 child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Case 3: 2 children → find inorder successor
            BST succ = minValueNode(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }
        return root;
    }

    public static BST minValueNode(BST node) {
        BST curr = node;
        while (curr.left != null) curr = curr.left;
        return curr;
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
        for (int key : keys) root = InsertBST.insert(root, key);

        root = deleteNode(root, 20);
        root = deleteNode(root, 30);
        root = deleteNode(root, 50);

        System.out.print("Inorder after deletions: ");
        inorder(root);
    }
}
