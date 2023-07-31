class Solution {
    public void flatten(TreeNode root) {
      if (root == null) {
            return;
        }

        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode leftTail = flattenHelper(node.left);
        TreeNode rightTail = flattenHelper(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail != null ? rightTail : (leftTail != null ? leftTail : node);
    }
}
