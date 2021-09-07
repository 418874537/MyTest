package com.分治;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 53. 最大子序和
 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例 1：

 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 输出：6
 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 示例 2：

 输入：nums = [1]
 输出：1
 示例 3：

 输入：nums = [0]
 输出：0
 示例 4：

 输入：nums = [-1]
 输出：-1
 示例 5：

 输入：nums = [-100000]
 输出：-100000


 提示：

 1 <= nums.length <= 3 * 104
 -105 <= nums[i] <= 105


 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */


public class MaximumSubarray {
  //遍历
  public static int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    for (int i = 0 ;i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length;j++){
        sum = sum + nums[j];
        maxSum = Math.max(sum,maxSum);
      }
    }
    return maxSum;
  }
  //动态规划: 对于位置为 i的数, 在前面任意长的连续部分,
  // 和>=0 说明对+i是正增益(保留)
  // 和<0 说明随+i是负增益(舍弃),从i重新开始算接下来的连续数组
  //[-2,1,-3,4] 为例: 临时的和为sum
  // -2 : 小于0,舍弃,记录max = -2 ,sum重置为0,
  // 1: 大于0,保留,sum = 0+1,比较max = 1
  // -3: sum = -2,舍弃, sum = 0
  // 4: sum = 4,max=4
  public static int maxSubArray2(int[] nums) {
    int max = nums[0];
    int sum = 0;
    for (int num : nums) {
      if(sum<0){
        sum = 0;
      }
      sum = sum + num;
      max = Math.max(sum,max);
    }
    return max;
  }
  //分治(把每次小结果都保存起来?
  public static int maxSubArray3(int[] nums) {
    return 0;
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

      int ret = maxSubArray2(nums);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}