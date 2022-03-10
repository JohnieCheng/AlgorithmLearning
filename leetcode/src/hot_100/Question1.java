package hot_100;

import utils.PrintUtil;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author Johnie Cheng
 * @version 1.0
 */
public class Question1 {
    public int[] twoSum(int[] nums, int target) {

        // 2ms,41.5M
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];

//        return myAnswer(nums, target);`
//        return answer1(nums, target);
    }

    // 49ms ,41.5M
    private int[] answer1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 50ms ,41.3M
    private int[] myAnswer(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] ints = new Question1().twoSum(new int[]{3, 2, 4}, 6);
        PrintUtil.printIntArray(ints);
    }
}