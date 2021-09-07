package com.滑动窗口;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 209. 长度最小的子数组
 给定一个含有 n 个正整数的数组和一个正整数 target 。

 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 如果不存在符合条件的子数组，返回 0 。
 示例 1：

 输入：target = 7, nums = [2,3,1,2,4,3]
 输出：2
 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 示例 2：

 输入：target = 4, nums = [1,4,4]
 输出：1
 示例 3：

 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 输出：0
 提示：

 1 <= target <= 109
 1 <= nums.length <= 105
 1 <= nums[i] <= 105


 进阶：

 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */


public class MinimumSizeSubarraySum {
  public static int minSubArrayLen(int target, int[] nums) {
    for (int i = 0; i < nums.length; i++){
      int head = 0;
      int end = i;
      int sum = 0;
      for(int j = head;j<=end;j++){
        sum = sum+nums[j];
      }
      if(sum>=target){
        return end-head+1;
      }
      while(end<nums.length-1){
        sum = sum - nums[head] + nums[end+1];
        if(sum>=target){
          return end-head+1;
        }
        head++;
        end++;
      }
    }

    return 0;
  }
  //滑动窗口
  public static int minSubArrayLen2(int target, int[] nums) {
    int head = 0;
    int end = 0;
    int sum = nums[0];
    int minLength = nums.length+1;
    while(end<nums.length && head<=end){
//      System.out.println(sum);
      if(sum>=target){
        int lenth = end - head +1;
        if(lenth<minLength){
          minLength = lenth;
        }
        sum = sum - nums[head];
        head++;
      } else {
        end++;
        if(end<nums.length){
          sum = sum + nums[end];
        }
      }
    }
    return minLength == nums.length+1? 0:minLength;
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
      int target = Integer.parseInt(line);
      line = in.readLine();
      int[] nums = stringToIntegerArray(line);

      int ret = minSubArrayLen2(target, nums);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}