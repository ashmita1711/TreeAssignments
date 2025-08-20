public class NodesAtDistanceK {
    public static void printKDistanceNodeDown(TreeNode root, int k) {
        if (root == null || k < 0) return;
        if (k == 0) {
            System.out.print(root.val + " ");
            return;
        }
        printKDistanceNodeDown(root.left, k - 1);
        printKDistanceNodeDown(root.right, k - 1);
    }

    public static int printNodes(TreeNode root, TreeNode target, int k) {
        if (root == null) return -1;

        if (root == target) {
            printKDistanceNodeDown(root, k);
            return 0;
        }

        int dl = printNodes(root.left, target, k);
        if (dl != -1) {
            if (dl + 1 == k) System.out.print(root.val + " ");
            else printKDistanceNodeDown(root.right, k - dl - 2);
            return 1 + dl;
        }

        int dr = printNodes(root.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k) System.out.print(root.val + " ");
            else printKDistanceNodeDown(root.left, k - dr - 2);
            return 1 + dr;
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        TreeNode target = root.left.right; // node 12
        int k = 2;
        System.out.print("Nodes at distance " + k + ": ");
        printNodes(root, target, k);
    }
}
