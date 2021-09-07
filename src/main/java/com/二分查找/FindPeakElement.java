package com.二分查找;

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
  //老实比较
  public static int findPeakElement(int[] nums) {
    boolean overLeft = false;
    boolean overRight = false;
    for(int i = 0; i < nums.length; i++) {
      if(i == 0){
        overLeft =  true;
      }else {
        overLeft = nums[i]>nums[i-1];
      }
      if(i == nums.length -1){
        overRight = true;
      }else{
        overRight = nums[i]>nums[i+1];
      }
      if(overLeft && overRight){
        return i;
      }
    }
    return -1;
  }
  //遍历(只比较右边
  public static int findPeakElement2(int[] nums) {
    for(int i = 0; i < nums.length-1; i++) {
      if(nums[i]>nums[i+1]){
        return i;
      }
    }
    return nums.length-1;
  }
  //二分查找(右侧大>上坡,峰值在右;左侧大>下坡,峰值在左
  public static int findPeakElement3(int[] nums) {
    int head = 0;
    int end = nums.length-1;
    int i = 0;
    while(head<end){
      i = head+(end-head)/2;
      /**
      为什么这里head移到i+1,end只移到i:
       移动head时,i+1是更大的数,是有可能是峰值的数
       移动end时,i是更大的数
       所以在上坡时,移到右边,下坡时,移到左边.
       这样判断条件也要改为head<end 而不是head<=end,因为有end=i的情况下,end会一直不移动出现死循环
       */
      if( nums[i]<nums[i+1]){
        head = i+1;
      } else{
        end = i;
      }
//      System.out.println(nums[i]);
    }
    return head;

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

      int ret = findPeakElement3(nums);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}