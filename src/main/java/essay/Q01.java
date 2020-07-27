package essay;

import utils.EncodeConvert;
import utils.PrintUtils;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 */
public class Q01 {
    /**
     * 方案一：用一个hashmap，key(是当前位置的值对应目标值的差额)，value是当前位置，遍历一次，找到结果
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> other = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i=0;i<nums.length;i++){
            //如果包含
            if(other.containsKey(nums[i])){
                result[0]=other.get(nums[i]);
                result[1]=i;
                break;
            }
            //如果不包含
            other.put((target-nums[i]),i);
        }
        return  result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] split = scanner.nextLine().split(",");
            int[] ints = EncodeConvert.arrayString2Integer(split);
            int i = Integer.parseInt(scanner.nextLine());
            PrintUtils.printArray(twoSum(ints,i));

        }
    }
}
