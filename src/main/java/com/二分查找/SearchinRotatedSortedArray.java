package com.二分查找;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 33. 搜索旋转排序数组
 整数数组 nums 按升序排列，数组中的值 互不相同 。

 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

 示例 1：

 输入：nums = [4,5,6,7,0,1,2], target = 0
 输出：4
 示例 2：
 5,6,7,0,1,2,3
 7

 输入：nums = [4,5,6,7,0,1,2], target = 3
 输出：-1
 示例 3：

 输入：nums = [1], target = 0
 输出：-1


 提示：

 1 <= nums.length <= 5000
 -10^4 <= nums[i] <= 10^4
 nums 中的每个值都 独一无二
 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 -10^4 <= target <= 10^4


 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 */

public class SearchinRotatedSortedArray {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;
    if(target == nums[left]){
      return left;
    }
    if(target == nums[right]){
      return right;
    }
    if(target < nums[left] && target > nums[right]){
      return -1;
    }
    //target处于左边较大的递增数列上
    if(target >= nums[0]){
      while(left <= right){
        int i = left +(right - left)/2;
        //i的情况:
        //1 处于左边较大的递增数列上
        //注意:  这里的判断条件要和上文相同..> nums[0]
        if(nums[i] >= nums[0]){
          if(nums[i] == target){
            return i;
          }else if (nums[i] < target){
            left = i+1;
          }else if (nums[i] > target){
            right = i-1;
          }
        }
        //2 处于右边较小的递增数列上
        else{
          right = i-1;
        }
      }
      return -1;
    }
    //target处于右边较小的递增数列上
    else{
      while(left <= right){
        int i = left +(right - left)/2;
        //i的情况:
        //1 处于左边较大的递增数列上
        if(nums[i] >= nums[0]){
          left = i+1;
        }
        //2 处于右边较小的递增数列上
        else{
          if(nums[i] == target){
            return i;
          }else if (nums[i] < target){
            left = i+1;
          }else if (nums[i] > target){
            right = i-1;
          }
        }
      }
      return -1;
    }

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

      int ret = new SearchinRotatedSortedArray().search(nums, target);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}