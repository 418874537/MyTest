package review.d0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 162. 寻找峰值
 峰值元素是指其值大于左右相邻值的元素。

 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

 你可以假设 nums[-1] = nums[n] = -∞ 。
 示例 1：

 输入：nums = [1,2,3,1]
 输出：2
 解释：3 是峰值元素，你的函数应该返回其索引 2。
 示例 2：

 输入：nums = [1,2,1,3,5,6,4]
 输出：1 或 5
 解释：你的函数可以返回索引 1，其峰值元素为 2；
 或者返回索引 5， 其峰值元素为 6。
 提示：

 1 <= nums.length <= 1000
 -231 <= nums[i] <= 231 - 1
 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？
 */

public class FindPeakElement {

  public static int findPeakElement(int[] nums) {
    for (int i = 0;i<nums.length-1; i++) {
      if(nums[i]>nums[i+1]){
        return i;
      }
    }
    return nums.length-1;
  }
  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for(int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[] nums = stringToIntegerArray(line);

      int ret = findPeakElement(nums);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}