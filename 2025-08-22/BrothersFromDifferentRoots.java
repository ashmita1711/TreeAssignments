import java.util.*;

public class BrothersFromDifferentRoots {
    public static void inorder(BST root, Set<Integer> set) {
        if (root == null) return;
        inorder(root.left, set);
        set.add(root.val);
        inorder(root.right, set);
    }

    public static int countPairs(BST root1, BST root2, int x) {
        Set<Integer> set = new HashSet<>();
        inorder(root1, set);

        return countMatches(root2, set, x);
    }

    public static int countMatches(BST root, Set<Integer> set, int x) {
        if (root == null) return 0;
        int count = 0;
        if (set.contains(x - root.val)) count++;
        count += countMatches(root.left, set, x);
        count += countMatches(root.right, set, x);
        return count;
    }

    public static void main(String[] args) {
        BST root1 = null, root2 = null;
        int[] keys1 = {5, 3, 7, 2, 4, 6, 8};
        int[] keys2 = {10, 6, 15, 3, 8, 11, 18};

        for (int k : keys1) root1 = InsertBST.insert(root1, k);
        for (int k : keys2) root2 = InsertBST.insert(root2, k);

        int x = 16;
        System.out.println("Pairs with sum " + x + ": " + countPairs(root1, root2, x));
    }
}
