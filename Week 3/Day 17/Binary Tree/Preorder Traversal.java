class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
        preorderTraversalHelper(root, result);
        return result;
    }

    private void preorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        preorderTraversalHelper(node.left, result);
        preorderTraversalHelper(node.right, result);
    }
}
