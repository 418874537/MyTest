package com.二分查找;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 704. 二分查找
 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

 示例 1:

 输入: nums = [-1,0,3,5,9,12], target = 9
 输出: 4
 解释: 9 出现在 nums 中并且下标为 4
 示例 2:

 输入: nums = [-1,0,3,5,9,12], target = 2
 输出: -1
 解释: 2 不存在 nums 中因此返回 -1


 提示：

 你可以假设 nums 中的所有元素是不重复的。
 n 将在 [1, 10000]之间。
 nums 的每个元素都将在 [-9999, 9999]之间。
 */

public class BinarySearch {
  public static int search(int[] nums, int target) {
    int i = 0;
    int head = 0;
    int end = nums.length-1;
    while(head<=end){
      i = (end+head)/2;
      if(nums[i] == target){
        return i;
      }
      if(nums[i]<target){
        head = i+1;
      }
      if(nums[i]>target){
        end = i-1;
      }
    }
    return -1;
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

      int ret = search(nums, target);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}