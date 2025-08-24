import java.util.*;

public class TwoSumBST {
    public static boolean findPair(BST root, int sum, Set<Integer> set) {
        if (root == null) return false;
        if (findPair(root.left, sum, set)) return true;

        if (set.contains(sum - root.val)) {
            System.out.println("Pair Found: (" + root.val + ", " + (sum - root.val) + ")");
            return true;
        }
        set.add(root.val);

        return findPair(root.right, sum, set);
    }

    public static void main(String[] args) {
        BST root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        for (int key : keys) root = InsertBST.insert(root, key);

        int target = 33;
        if (!findPair(root, target, new HashSet<>()))
            System.out.println("No pair found");
    }
}
