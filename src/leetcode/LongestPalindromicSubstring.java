//https://leetcode.com/problems/longest-palindromic-substring/
package leetcode;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
       if (s.length() <= 1) return s;
       
       int len = s.length();

       boolean[][] state = new boolean[len][len];

       int longestPalindromeStart = 0, longestPalindromeLength = 1;

       for (int i = 0; i < len; i++) state[i][i] = true;

       for (int lIndex = len - 1; lIndex >= 0; lIndex--) {
           for (int dist = 1; dist < len - lIndex; dist++) {
                int rIndex = lIndex + dist;
                state[lIndex][rIndex] = dist == 1? s.charAt(lIndex) == s.charAt(rIndex) : (state[lIndex + 1][rIndex - 1] && s.charAt(lIndex) == s.charAt(rIndex));
                if (state[lIndex][rIndex] && rIndex - lIndex + 1 > longestPalindromeLength){
                    longestPalindromeStart = lIndex;
                    longestPalindromeLength = rIndex - lIndex + 1;
                }
            }
       }

       return s.substring(longestPalindromeStart, longestPalindromeStart + longestPalindromeLength);
   }

    public static void main(String[] args) {
        LongestPalindromicSubstring t = new LongestPalindromicSubstring();
    	System.out.println(t.longestPalindrome("ac"));
    }
}