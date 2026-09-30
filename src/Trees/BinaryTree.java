package Trees;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        Node left = new Node(2, new Node(4), new Node(5));
        Node right = new Node(3, null, new Node(6));
        Node root = new Node(1, left, right);

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
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // LeetCode #144
    public static void recursivePreorder(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            recursivePreorder(node.left, result);
            recursivePreorder(node.right, result);
        }
    }

    // LeetCode #145
    public static void recursivePostorder(Node node, List<Integer> result) {
        if (node != null) {
            recursivePostorder(node.left, result);
            recursivePostorder(node.right, result);
            result.add(node.value);
        }
    }

    // LeetCode #94
    public static void recursiveInorder(Node node, List<Integer> result) {
        if (node != null) {
            recursiveInorder(node.left, result);
            result.add(node.value);
            recursiveInorder(node.right, result);
        }
    }

    public static void iterativePreorder(Node root, List<Integer> result) {
        if (root == null)
            return;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.poll();
            result.add(node.value);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void iterativeInorder(Node root, List<Integer> result) {
        if (root == null)
            return;

        Deque<Node> stack = new ArrayDeque<>();
        Node node = root;

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

    public static void iterativePostorder(Node root, List<Integer> result) {
        if (root == null)
            return;

        Deque<Node> stack = new ArrayDeque<>();

        Node node = root;
        Node lastVisited = null;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                Node top = stack.peek();
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
}
