import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution1 {

    // 暴力法
    private static int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    // 两次遍历哈希表，以空间换时间
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // 一次遍历哈希表，边插边判断
    private static int[] twoSum3(int[] nums, int target) {
        // HashMap存在索引，可以直接定位到键值对
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                // 一直往后遍历，直到发现前面存在一个数和先的数加起来为target，所以把i放在后面
                return new int[] {map.get(complement), i};
            }
            // 必须要放在后面，否则，当两个数字相同，作为key时，会覆盖value的值
            // 例：[3, 3] 6
            // 就会出现第一次遍历，map是(3, 0)，第二次遍历，map是(3, 1)
            // 若放在后面，则不会覆盖，因为当发现相同的第二个数字满足target时，直接return了，不会覆盖；若不满足，覆盖就覆盖也没事儿
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        long start = System.currentTimeMillis();
        int[] res = twoSum3(nums, 6);
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        System.out.println(Arrays.toString(res));
    }
}
