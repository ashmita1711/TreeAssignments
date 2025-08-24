public class KthElementBST {
    static int count = 0;

    public static void kthSmallest(BST root, int k) {
        if (root == null) return;
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            System.out.println(k + "th Smallest: " + root.val);
            return;
        }
        kthSmallest(root.right, k);
    }

    public static void kthLargest(BST root, int k) {
        if (root == null) return;
        kthLargest(root.right, k);
        count++;
        if (count == k) {
            System.out.println(k + "th Largest: " + root.val);
            return;
        }
        kthLargest(root.left, k);
    }

    public static void main(String[] args) {
        BST root = null;
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for (int key : keys) root = InsertBST.insert(root, key);

        count = 0;
        kthSmallest(root, 3);

        count = 0;
        kthLargest(root, 2);
    }
}
