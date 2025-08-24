import java.util.*;

public class CommonNodesBST {
    public static void inorder(BST root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        BST root1 = null, root2 = null;
        int[] keys1 = {5, 1, 10, 0, 4, 7, 9};
        int[] keys2 = {10, 7, 20, 4, 9};

        for (int k : keys1) root1 = InsertBST.insert(root1, k);
        for (int k : keys2) root2 = InsertBST.insert(root2, k);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        System.out.print("Common Nodes: ");
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).equals(list2.get(j))) {
                System.out.print(list1.get(i) + " ");
                i++; j++;
            } else if (list1.get(i) < list2.get(j)) i++;
            else j++;
        }
    }
}
