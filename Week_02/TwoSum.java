import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 *
 * @author Q
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] sums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(sums, target)));
        System.out.println(Arrays.toString(twoSumPlus(sums, target)));
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    /**
     * 一遍哈希法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumPlus(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.containsKey(dif)) {
                return new int[]{map.get(dif), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
