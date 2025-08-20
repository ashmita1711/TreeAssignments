public class ChildrenSumProperty {
    public static boolean isChildrenSum(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        int leftVal = (root.left != null) ? root.left.val : 0;
        int rightVal = (root.right != null) ? root.right.val : 0;

        return (root.val == leftVal + rightVal) &&
               isChildrenSum(root.left) &&
               isChildrenSum(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);

        System.out.println("Children Sum Property: " + isChildrenSum(root));
    }
}
