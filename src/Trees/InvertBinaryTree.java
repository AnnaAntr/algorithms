package Trees;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);

        recursivePreorder(root);

        invert(root);
        System.out.println();

        recursivePreorder(root);
    }

    public static void invert(TreeNode node) {
        if (node == null)
            return;

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        invert(node.left);
        invert(node.right);
    }

    public static void recursivePreorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            recursivePreorder(node.left);
            recursivePreorder(node.right);
        }
    }
}
