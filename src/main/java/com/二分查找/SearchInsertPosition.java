package com.二分查找;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 35. 搜索插入位置
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 请必须使用时间复杂度为 O(log n) 的算法。

 示例 1:

 输入: nums = [1,3,5,6], target = 5
 输出: 2
 示例 2:

 输入: nums = [1,3,5,6], target = 2
 输出: 1
 示例 3:

 输入: nums = [1,3,5,6], target = 7
 输出: 4
 示例 4:

 输入: nums = [1,3,5,6], target = 0
 输出: 0
 示例 5:

 输入: nums = [1], target = 0
 输出: 0

 提示:

 1 <= nums.length <= 104
 -104 <= nums[i] <= 104
 nums 为无重复元素的升序排列数组
 -104 <= target <= 104
 */

public class SearchInsertPosition {
  public static int searchInsert(int[] nums, int target) {
    if (target<nums[0]){
      return 0;
    }
    if (target>nums[nums.length-1]){
      return nums.length;
    }
    int i = 0;
    int head = 0;
    int end = nums.length-1;
    while(head<=end){
      i = head + (end-head)/2;
      if(nums[i] == target){
        return i;
      }else if(nums[i] < target){
        head = i+1;
      }else {
        end = i-1;
      }
    }
    return target<nums[i] ? i:i+1;
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

      int ret =searchInsert(nums, target);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}