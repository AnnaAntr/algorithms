package Trees;

import java.util.*;

// LeetCode #144  #145  # 94
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);

        List<Integer> result = new ArrayList<>();

        System.out.println("Preorder:");
        recursivePreorder(root, result);
        System.out.println(result);

        result.clear();
        iterativePreorder(root, result);
        System.out.println(result);

        System.out.println("Inorder:");
        result.clear();
        recursiveInorder(root, result);
        System.out.println(result);

        result.clear();
        iterativeInorder(root, result);
        System.out.println(result);

        System.out.println("Postorder:");
        result.clear();
        recursivePostorder(root, result);
        System.out.println(result);

        result.clear();
        iterativePostorder(root, result);
        System.out.println(result);

        System.out.println("Levelorder:");
        result.clear();
        iterativeLevelorder(root, result);
        System.out.println(result);

        System.out.println(height(root));
    }

    public static void recursivePreorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            recursivePreorder(node.left, result);
            recursivePreorder(node.right, result);
        }
    }

    public static void recursivePostorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            recursivePostorder(node.left, result);
            recursivePostorder(node.right, result);
            result.add(node.value);
        }
    }

    public static void recursiveInorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            recursiveInorder(node.left, result);
            result.add(node.value);
            recursiveInorder(node.right, result);
        }
    }

    public static void iterativePreorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            result.add(node.value);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void iterativeInorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                result.add(node.value);
                node = node.right;
            }
        }
    }

    public static void iterativePostorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        TreeNode lastVisited = null;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                TreeNode top = stack.peek();
                if (top.right != null && top.right != lastVisited) {
                    node = top.right;
                }
                else {
                    result.add(top.value);
                    lastVisited = stack.pop();
                }
            }
        }
    }

    public static void iterativeLevelorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.value);

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    public static int height(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
