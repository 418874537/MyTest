package com.二分查找;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 34. 在排序数组中查找元素的第一个和最后一个位置
 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 如果数组中不存在目标值 target，返回 [-1, -1]。

 进阶：

 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？


 示例 1：

 输入：nums = [5,7,7,8,8,10], target = 8
 输出：[3,4]
 示例 2：

 输入：nums = [5,7,7,8,8,10], target = 6
 输出：[-1,-1]
 示例 3：

 输入：nums = [], target = 0
 输出：[-1,-1]


 提示：

 0 <= nums.length <= 105
 -109 <= nums[i] <= 109
 nums 是一个非递减数组
 -109 <= target <= 109
 */

public class FindFirstandLastPositionofElementinSortedArray {
  public int[] searchRange(int[] nums, int target) {
    int head = 0;
    int end = nums.length-1;
    while (head <= end) {
      int i = head+(end-head)/2;
      if(nums[i] == target){
        //找到匹配的数后,向前向后移动指针寻找
        //注意这里最后的指针落点是[相邻的不同元素],所以最后要返回+1和-1
        int n1 = i;
        int n2 = i;
        while(n1 >= 0 && nums[n1]==target){
          n1--;
        }
        while(n2 <= nums.length-1 &&nums[n2]==target){
          n2++;
        }
        return new int[] {n1+1,n2-1};
      }else if(nums[i] < target){
        head = i+1;
      }else if (nums[i] > target){
        end = i-1;
      }
    }
    return new int[] {-1,-1};
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

  public static String integerArrayToString(int[] nums, int length) {
    if (length == 0) {
      return "[]";
    }

    String result = "";
    for(int index = 0; index < length; index++) {
      int number = nums[index];
      result += Integer.toString(number) + ", ";
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static String integerArrayToString(int[] nums) {
    return integerArrayToString(nums, nums.length);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[] nums = stringToIntegerArray(line);
      line = in.readLine();
      int target = Integer.parseInt(line);

      int[] ret = new FindFirstandLastPositionofElementinSortedArray().searchRange(nums, target);

      String out = integerArrayToString(ret);

      System.out.print(out);
    }
  }
}