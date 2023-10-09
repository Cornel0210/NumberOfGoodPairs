package check;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{6,5,1,5,7,7,9,1,5,7,1,6,10,9,7,4,1,8,7,1,1,8,6,4,7,4,10,5,3,9,10,1,9,5,5,4,1,7,4,2,9,2,6,6,4,2,10,3,5,3,6,4,7,4,6,4,4,6,3,4,10,1,10,6,10,4,9,6,6,4,8,6,9,5,4};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(numIdenticalPairs(new int[]{6,5,1,5,7,7,9,1,5,7,1,6,10,9,7,4,1,8,7,1,1,8,6,4,7,4,10,5,3,9,10,1,9,5,5,4,1,7,4,2,9,2,6,6,4,2,10,3,5,3,6,4,7,4,6,4,4,6,3,4,10,1,10,6,10,4,9,6,6,4,8,6,9,5,4}));

    }
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencies.computeIfPresent(nums[i], (k,v)-> ++v);
            frequencies.putIfAbsent(nums[i], 1);
        }
        int count = 0;
        for (Integer freq : frequencies.values()){
            if (freq >=2){
                count+=getPairs(freq);
            }
        }
        return count;
    }

    private static int getPairs(int frequency){
        int sum=0;
        for (int i = 1; i < frequency; i++) {
            sum+=i;
        }
        return sum;
    }
}
