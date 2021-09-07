package com.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 496. 下一个更大元素 I
 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。

 nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 如果不存在，对应位置输出 -1 。

 示例 1:

 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 输出: [-1,3,-1]
 解释:
 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 示例 2:

 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 输出: [3,-1]
 解释:
 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 输入: nums1 = [5,2], nums2 = [5,2,1,3,4].
 输出: [-1,3]
 提示：

 1 <= nums1.length <= nums2.length <= 1000
 0 <= nums1[i], nums2[i] <= 104
 nums1和nums2中所有整数 互不相同
 nums1 中的所有整数同样出现在 nums2 中


 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 */

public class NextGreaterElement {
  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Queue<Integer> queue = new LinkedList();
    HashMap<Integer,Integer> map = new HashMap();
    for (int j=0;j<nums1.length;j++) {
      map.put(nums1[j],j);
    }
    Stack<Integer> stack = new Stack();
    for (int i : nums2) {
      while(!stack.isEmpty() && stack.peek()<i){
        nums1[map.get(stack.peek())] = i;
        stack.pop();
      }
      if(map.get(i)!=null){
        stack.push(i);
      }
    }
    while(!stack.isEmpty()){
      nums1[map.get(stack.peek())] = -1;
      stack.pop();
    }
    return nums1;

  }

  public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
    HashMap<Integer,Integer> map = new HashMap();
    Stack<Integer> stack = new Stack();
    for (int i : nums2) {
      while(!stack.isEmpty() && stack.peek()<i){
        map.put(stack.peek(),i);
        stack.pop();
      }
      stack.push(i);
    }
    while(!stack.isEmpty()){
      map.put(stack.peek(),-1);
      stack.pop();
    }
    for (int i=0;i<nums1.length;i++) {
      nums1[i] = map.get(nums1[i]);
    }
    return nums1;

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
      int[] nums1 = stringToIntegerArray(line);
      line = in.readLine();
      int[] nums2 = stringToIntegerArray(line);

      int[] ret = nextGreaterElement2(nums1, nums2);

      String out = integerArrayToString(ret);

      System.out.print(out);
    }
  }
}