import java.util.Queue;
import java.util.LinkedList;

public class DiagonalTraversal {
    public static void diagonalPrint(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            while (node != null) {
                if (node.left != null) q.add(node.left);
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        System.out.print("Diagonal Traversal: ");
        diagonalPrint(root);
    }
}
