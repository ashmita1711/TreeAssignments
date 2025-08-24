import java.util.*;

public class MergeBST {
    public static void inorder(BST root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static BST sortedArrayToBST(List<Integer> list, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        BST node = new BST(list.get(mid));
        node.left = sortedArrayToBST(list, l, mid - 1);
        node.right = sortedArrayToBST(list, mid + 1, r);
        return node;
    }

    public static BST merge(BST root1, BST root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        inorder(root1, a);
        inorder(root2, b);

        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) merged.add(a.get(i++));
            else merged.add(b.get(j++));
        }
        while (i < a.size()) merged.add(a.get(i++));
        while (j < b.size()) merged.add(b.get(j++));

        return sortedArrayToBST(merged, 0, merged.size() - 1);
    }

    public static void main(String[] args) {
        BST root1 = null, root2 = null;
        root1 = InsertBST.insert(root1, 30);
        root1 = InsertBST.insert(root1, 20);
        root1 = InsertBST.insert(root1, 40);

        root2 = InsertBST.insert(root2, 10);
        root2 = InsertBST.insert(root2, 25);
        root2 = InsertBST.insert(root2, 35);

        BST mergedRoot = merge(root1, root2);
        System.out.print("Inorder of merged BST: ");
        DeleteBST.inorder(mergedRoot);
    }
}
