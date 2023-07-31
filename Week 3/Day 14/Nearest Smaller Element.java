public class Solution {
    public int[] prevSmaller(int[] A) {
     int[] G = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }

            G[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(A[i]);
        }

        return G;
    }
