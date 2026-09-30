package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public static void main(String[] args) {
        Node left = new Node(2, new Node(4), new Node(5));
        Node right = new Node(3, null, new Node(6));
        Node root = new Node(1, left, right);

//        System.out.println(preorderTraversal(root));
//        System.out.println(postorderTraversal(root));


        List<Integer> result = new ArrayList<>();
        recursivePreorder(root, result);
        System.out.println(result);

        result.clear();
        recursivePostorder(root, result);
        System.out.println(result);

        result.clear();
        recursiveInorder(root, result);
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
}
