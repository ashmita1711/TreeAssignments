import java.util.*;

public class BurnBinaryTree {
    public static TreeNode buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap, int target, TreeNode[] targetNode) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == target) targetNode[0] = node;
            if (node.left != null) {
                parentMap.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                q.add(node.right);
            }
        }
        return root;
    }

    public static int burnTree(TreeNode root, int target) {
        if (root == null) return 0;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode[] targetNode = new TreeNode[1];
        buildParentMap(root, parentMap, target, targetNode);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(targetNode[0]);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(targetNode[0]);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    flag = true;
                    visited.add(node.left);
                    q.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    flag = true;
                    visited.add(node.right);
                    q.add(node.right);
                }
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    flag = true;
                    visited.add(parentMap.get(node));
                    q.add(parentMap.get(node));
                }
            }
            if (flag) time++;
        }
        return time;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int target = 5;
        System.out.println("Minimum time to burn the tree from node " + target + ": " + burnTree(root, target));
    }
}
