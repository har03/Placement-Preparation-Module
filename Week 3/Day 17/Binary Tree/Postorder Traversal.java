class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
   List<Integer> result = new ArrayList<>();
        postorderTraversalHelper(root, result);
        return result;
    }

    private void postorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        postorderTraversalHelper(node.left, result);
        postorderTraversalHelper(node.right, result);
        result.add(node.val);
    }
}
