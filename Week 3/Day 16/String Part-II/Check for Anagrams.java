lass Solution {
    public boolean isAnagram(String s, String t) {
     if (s.length() != t.length()) {
            return false;
        }
        int[] charFrequency = new int[26]; 
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            charFrequency[c - 'a']--;
            if (charFrequency[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
