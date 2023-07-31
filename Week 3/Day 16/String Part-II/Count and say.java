class Solution {
    public String countAndSay(int n) {
      if (n == 1) {
            return "1";
        }
        String prevTerm = countAndSay(n - 1);
        StringBuilder currentTerm = new StringBuilder();

        int i = 0;
        while (i < prevTerm.length()) {
            char digit = prevTerm.charAt(i);
            int count = 1;
            while (i + 1 < prevTerm.length() && prevTerm.charAt(i + 1) == digit) {
                count++;
                i++;
            }
            currentTerm.append(count).append(digit);
            i++;
        }
        return currentTerm.toString();
    }
}
