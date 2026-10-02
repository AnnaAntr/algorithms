package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTree {
    TreeNode root;

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        TreeNode right = new TreeNode(9, new TreeNode(8), new TreeNode(10));
        TreeNode root = new TreeNode(7, left, right);
        BinarySearchTree tree = new BinarySearchTree(root);

        tree.print();
        System.out.println(tree.findElement(5));

        tree.insertElement(11);
        tree.print();

        tree.deleteElement(8);
        tree.print();

        tree.deleteElement(9);
        tree.print();

        tree.deleteElement(3);
        tree.print();
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public void print() {
        if (root == null)
            return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            System.out.print(node.value + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        System.out.println();
    }

    public TreeNode findElement(int value) {
        if (root == null)
            return null;

        TreeNode node = root;
        while (node != null) {
            if (node.value == value)
                return node;
            else if (node.value > value)
                node = node.left;
            else
                node = node.right;
        }

        return null;
    }

    public void insertElement(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }

        TreeNode node = root;
        TreeNode parent;

        while (true) {
            parent = node;

            if (node.value == value)
                return;

            else if (node.value > value) {
                node = node.left;
                if (node == null) {
                    parent.left = new TreeNode(value);
                    return;
                }
            }

            else {
                node = node.right;
                if (node == null) {
                    parent.right = new TreeNode(value);
                    return;
                }
            }
        }
    }

    public void deleteElement(int value) {
        if (root == null)
            return;

        TreeNode node = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (node.value != value) {
            parent = node;

            if (node.value > value) {
                node = node.left;
                isLeftChild = true;
            }
            else {
                node = node.right;
                isLeftChild = false;
            }
            if (node == null)
                return;
        }

        if (node.left == null && node.right == null) {
            if (node == root) {
                root = null;
                return;
            }

            if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
            node = null;
        }

        else if (node.left == null) {
            if (isLeftChild)
                parent.left = node.right;
            else
                parent.right = node.right;
            node = null;
        }

        else if (node.right == null) {
            if (isLeftChild)
                parent.left = node.left;
            else
                parent.right = node.left;
            node = null;
        }

        else {
            TreeNode minLeftNode = node.right;
            TreeNode minLeftParent = node;

            while (minLeftNode.left != null) {
                minLeftParent = minLeftNode;
                minLeftNode = minLeftNode.left;
            }

            if (isLeftChild)
                parent.left = minLeftNode;
            else
                parent.right = minLeftNode;

            if (minLeftNode != node.right) {
                minLeftNode.left = node.left;
                minLeftNode.right = node.right;
                minLeftParent.left = null;
            }
            else {
                minLeftNode.left = node.left;
            }

            node = null;
        }
    }
}
