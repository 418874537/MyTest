package com.双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 15. 三数之和
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 示例 1：

 输入：nums = [-1,0,1,2,-1,-4]
 输出：[[-1,-1,2],[-1,0,1]]
 示例 2：

 输入：nums = []
 输出：[]
 示例 3：

 输入：nums = [0]
 输出：[]


 提示：

 0 <= nums.length <= 3000
 -105 <= nums[i] <= 105
 */

public class A3Sum {
  public List<List<Integer>> threeSum(int[] nums) {
    LinkedList<List<Integer>> lists = new LinkedList<>();
    if(nums.length<3){
      return lists;
    }
    Arrays.sort(nums);
    for(int i = 0; i<nums.length-2; i++){
      if(i>0 && nums[i] == nums[i-1]){
        continue;
      }
      int head = i+1;
      int end = nums.length-1;
      while(head < end){
       int sum =  nums[i]+nums[head]+ nums[end];
       if(sum == 0){
         lists.add(Arrays.asList(nums[i],nums[head],nums[end]));
         end--;
         head++;
         while(head<end && nums[end]==nums[end+1]){
           end--;
         }
         while(head<end && nums[head]==nums[head-1]){
           head++;
         }
       }else if(sum > 0){
         end--;
       }else{
         head++;

       }
      }
    }


    return lists;
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

  public static String integerArrayListToString(List<Integer> nums, int length) {
    if (length == 0) {
      return "[]";
    }

    String result = "";
    for(int index = 0; index < length; index++) {
      Integer number = nums.get(index);
      result += Integer.toString(number) + ", ";
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static String integerArrayListToString(List<Integer> nums) {
    return integerArrayListToString(nums, nums.size());
  }

  public static String int2dListToString(List<List<Integer>> nums) {
    StringBuilder sb = new StringBuilder("[");
    for (List<Integer> list: nums) {
      sb.append(integerArrayListToString(list));
      sb.append(",");
    }

    sb.setCharAt(sb.length() - 1, ']');
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[] nums = stringToIntegerArray(line);

      List<List<Integer>> ret = new A3Sum().threeSum(nums);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}