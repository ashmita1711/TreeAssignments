import java.util.*;

public class BSTDeadEnd {
    public static boolean isDeadEnd(BST root, int min, int max) {
        if (root == null) return false;
        if (min == max) return true;
        return isDeadEnd(root.left, min, root.val - 1) ||
               isDeadEnd(root.right, root.val + 1, max);
    }

    public static void main(String[] args) {
        BST root = null;
        int[] keys = {8, 5, 2, 3, 7, 11, 4};
        for (int key : keys) root = InsertBST.insert(root, key);

        System.out.println("BST has dead end: " + isDeadEnd(root, 1, Integer.MAX_VALUE));
    }
}
