package com.回溯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 78. 子集
 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

 示例 1：

 输入：nums = [1,2,3]
 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 示例 2：

 输入：nums = [0]
 输出：[[],[0]]


 提示：

 1 <= nums.length <= 10
 -10 <= nums[i] <= 10
 nums 中的所有元素 互不相同
 */

public class Subsets {
  //回溯:
  public static List<List<Integer>> subsets(int[] nums) {
    ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
    ArrayList<Integer> integers = new ArrayList<Integer>();
    subsetsBack(nums,lists,new ArrayList<Integer>(),0,-1);
    return lists;
  }
  //每次的缓存集合都放入结果集中
  //lenth: 缓存集合的长度
  //addNumPoint: 每次迭代中添加元素的指针
  //退出条件: 长度等于nums
  //每次的迭代中,指针向后移动一次,同时把指针下所有的长度也迭代完成: 即 1开头的迭代完成->2开头的迭代完成->3开头的>...
  //..这种应该算DFS???? 深度优先算法
  private static void subsetsBack(int[] nums, ArrayList<List<Integer>> lists,ArrayList<Integer> cache,int lenth,int addNumPoint) {
    lists.add(cache);
    if(lenth == nums.length){
      return ;
    }
    while (addNumPoint<nums.length-1){
      addNumPoint++;
      ArrayList<Integer> integers = new ArrayList<>(cache);
      integers.add(nums[addNumPoint]);
      subsetsBack(nums,lists,integers,lenth+1,addNumPoint);
    }
  }
  //扩展法
  public static List<List<Integer>> subsets2(int[] nums) {
    ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
    lists.add(new ArrayList<Integer>());
    for (int num : nums) {
      ArrayList<List<Integer>> addList = new ArrayList<>();
      for (List<Integer> list : lists) {
        List<Integer> cache = new ArrayList<>(list);
        cache.add(num);
        addList.add(cache);
      }
      lists.addAll(addList);
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

      List<List<Integer>> ret = subsets2(nums);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}