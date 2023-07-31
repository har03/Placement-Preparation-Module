class Solution {
    public int widthOfBinaryTree(TreeNode root) {
  if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> positionQueue = new LinkedList<>();
        queue.offer(root);
        positionQueue.offer(0);
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftmost = 0;
            int rightmost = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int position = positionQueue.poll();

                if (i == 0) {
                    leftmost = position;
                }

                if (i == size - 1) {
                    rightmost = position;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    positionQueue.offer(2 * position);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    positionQueue.offer(2 * position + 1);
                }
            }

            maxWidth = Math.max(maxWidth, rightmost - leftmost + 1);
        }

        return maxWidth;
    }

}
