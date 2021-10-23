//https://leetcode.com/problems/maximum-erasure-value/
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumErasureValue{

    public int maximumUniqueSubarray(int[] nums) {
        int curMaxSum = nums[0];
        int curSum = curMaxSum;
        int curStart = 0;
        Set<Integer> set = new HashSet<Integer>();
        set.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            while(set.contains(nums[i])){
                set.remove(nums[curStart]);
                curSum -= nums[curStart];
                curStart++;
            }
            set.add(nums[i]);
            curSum += nums[i];
            curMaxSum = Math.max(curMaxSum, curSum);
        }
        return curMaxSum;
    }

    public static void main(String[] args) {
        MaximumErasureValue t = new MaximumErasureValue();
        int[] nums = {5,2,1,2,5,2,1,2,5};
        System.out.println(t.maximumUniqueSubarray(nums));
    }
}  