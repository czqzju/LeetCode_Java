//https://leetcode.com/problems/zigzag-conversion/
package leetcode;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int patternLen = numRows + (numRows - 2), index;
        String res = "";
        boolean newRow;
        int curDist = 0;

        for (int row = 0; row < numRows; row++){
            index = row;
            newRow = true;
            while(index < s.length()){
                res += s.charAt(index);
                if (row == 0 || row == numRows - 1) {
                    index += patternLen;
                }
                else if (newRow) {
                    curDist = patternLen - row * 2;
                    index += curDist;
                    newRow = false;
                }
                else{
                    curDist = patternLen - curDist;
                    index += curDist;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ZigZagConversion t = new ZigZagConversion();
        System.out.println(t.convert("A", 1));
    }
}
