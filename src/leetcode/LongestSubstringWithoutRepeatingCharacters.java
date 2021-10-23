//https://leetcode.com/problems/longest-palindromic-substring/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.PrimitiveIterator.OfDouble;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacters {
	
    public int lengthOfLongestSubstring(String s) {
    	if (s.length() <= 1) {
    		return s.length();
    	}
    	
        Set<Character> set = s.codePoints().mapToObj(c -> (char) c).collect(Collectors.toCollection(HashSet::new));
        if (set.size() <= 2) {
        	return set.size();
        }
        char[] arr = s.toCharArray();
        int curMaxLen = 0, index;
        String curSubString = "";
        for(Character ch : arr) {
        	index = curSubString.indexOf(ch);
        	if (index == -1) {
        		curSubString += ch;
        		curMaxLen = Math.max(curMaxLen, curSubString.length());
        		if (curMaxLen == set.size()) return curMaxLen;
        	}
        	else {
        		curSubString = index < curSubString.length() - 1? curSubString.substring(index + 1) : "";
        		curSubString += ch;
        	}
        }
        return curMaxLen;
    }
}
