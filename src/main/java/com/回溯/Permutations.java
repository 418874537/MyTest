package com.回溯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 46. 全排列
 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 示例 1：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 示例 2：

 输入：nums = [0,1]
 输出：[[0,1],[1,0]]
 示例 3：

 输入：nums = [1]
 输出：[[1]]


 提示：

 1 <= nums.length <= 6
 -10 <= nums[i] <= 10
 nums 中的所有整数 互不相同
 */

public class Permutations {
  public static List<List<Integer>> permute(int[] nums) {
    ArrayList<List<Integer>> lists = new ArrayList<>();
    permuteBackTrack(lists,new LinkedList<Integer>(),nums,new HashSet<Integer>());
    return lists;
  }

  private static void permuteBackTrack(ArrayList<List<Integer>> lists, LinkedList<Integer> integers, int[] nums,
      HashSet userIndex) {
    if(integers.size() == nums.length){
      lists.add(new ArrayList<>(integers));
      return;
    }
    for (int i = 0 ;i<nums.length;i++) {
      if(userIndex.contains(i)){
        continue;
      }
      integers.add(nums[i]);
      userIndex.add(i);
      permuteBackTrack(lists,integers,nums,userIndex);
      integers.removeLast();
      userIndex.remove(i);
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

      List<List<Integer>> ret = permute(nums);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}