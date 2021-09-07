package com.分治;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 169. 多数元素
 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于  n/2  的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 示例 1：

 输入：[3,2,3]
 输出：3
 示例 2：

 输入：[2,2,1,1,1,2,2]
 输出：2


 进阶：

 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */


public class MajorityElement {
  public static int majorityElement(int[] nums) {
    PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue(new Comparator<Map.Entry<Integer, Integer>>() {

      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue()-o1.getValue();
      }
    });
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num : nums) {
      if(map.get(num)==null){
        map.put(num,1);
      }else{
        map.put(num,map.get(num)+1);
      }
    }
    priorityQueue.addAll(map.entrySet());
    return priorityQueue.peek().getKey();
  }
  //排序
  public static int majorityElement2(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
  }
  //分治
  public static int majorityElement3(int[] nums) {
    return majorityElementInPart(nums,0,nums.length-1);
  }
  public static int majorityElementInPart(int[] nums,int head,int end) {
    if(head == end){
      return nums[head];
    }
    int leftMajor = majorityElementInPart(nums, head, head + (end - head) / 2);
    int rightMajor = majorityElementInPart(nums, head + (end - head) / 2 + 1, end);

    if(leftMajor == rightMajor){
      return leftMajor;
    }
    int leftCount = 0;
    int rightCount = 0;
    for (int i = head; i <=end;i++){
      if(nums[i] == leftMajor){
        leftCount++;
      }
      if(nums[i] == rightMajor){
        rightCount++;
      }
    }
    return leftCount>=rightCount ? leftMajor: rightMajor;
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

      int ret = majorityElement3(nums);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}