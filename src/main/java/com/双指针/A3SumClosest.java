package com.双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 16. 最接近的三数之和
 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。



 示例：

 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。


 提示：

 3 <= nums.length <= 10^3
 -10^3 <= nums[i] <= 10^3
 -10^4 <= target <= 10^4
 */
public class A3SumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int close = 0;
    int minDistAbs = -1;
    for(int i = 0;i<nums.length;i++){
      int j = i+1;
      int k = nums.length-1;
      while(j<k){
        int sum = nums[i]+nums[j]+nums[k];
        int distAbs = (target - sum)>0? target-sum : sum-target;
        if(minDistAbs <0 ||distAbs < minDistAbs){
          minDistAbs = distAbs;
          close = sum;
        }
        if(sum == target){
          return sum;
        }
        if(sum < target){
          j++;
        }
        if(sum > target){
          k--;
        }
      }
    }
    return close;
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
      line = in.readLine();
      int target = Integer.parseInt(line);

      int ret = new A3SumClosest().threeSumClosest(nums, target);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}