public class CountNodesInRange {
    public static int countNodes(BST root, int low, int high) {
        if (root == null) return 0;
        if (root.val >= low && root.val <= high)
            return 1 + countNodes(root.left, low, high) + countNodes(root.right, low, high);
        else if (root.val < low)
            return countNodes(root.right, low, high);
        else
            return countNodes(root.left, low, high);
    }

    public static void main(String[] args) {
        BST root = null;
        int[] keys = {10, 5, 50, 1, 40, 100};
        for (int key : keys) root = InsertBST.insert(root, key);

        System.out.println("Count in range [5, 45]: " + countNodes(root, 5, 45));
    }
}
