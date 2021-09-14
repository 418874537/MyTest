package com.回溯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 39. 组合总和
 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。

 candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。

 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。

 示例 1：

 输入: candidates = [2,3,6,7], target = 7
 输出: [[7],[2,2,3]]
 示例 2：

 输入: candidates = [2,3,5], target = 8
 输出: [[2,2,2,2],[2,3,3],[3,5]]
 示例 3：

 输入: candidates = [2], target = 1
 输出: []
 示例 4：

 输入: candidates = [1], target = 1
 输出: [[1]]
 示例 5：

 输入: candidates = [1], target = 2
 输出: [[1,1]]


 提示：

 1 <= candidates.length <= 30
 1 <= candidates[i] <= 200
 candidate 中的每个元素都是独一无二的。
 1 <= target <= 500
 */

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    LinkedList<List<Integer>> res = new LinkedList<>();
    backTrack(res,new LinkedList<Integer>(),candidates,target,0);
    return res;
  }

  private void backTrack(LinkedList<List<Integer>> lists, LinkedList<Integer> integers, int[] candidates, int target,int head) {
    if(0 > target){
      return;
    }
    if(0 == target){
      lists.add(new ArrayList<>(integers));
    }
    for(int i = head;i<candidates.length;i++){
      integers.add(candidates[i]);
      backTrack(lists,integers,candidates,target-candidates[i],i);
      integers.removeLast();
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
      int[] candidates = stringToIntegerArray(line);
      line = in.readLine();
      int target = Integer.parseInt(line);

      List<List<Integer>> ret = new CombinationSum().combinationSum(candidates, target);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}