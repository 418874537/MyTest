package com.回溯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 40. 组合总和 II
 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 注意：解集不能包含重复的组合。

 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 输出:
 [
 [1,1,6],
 [1,2,5],
 [1,7],
 [2,6]
 ]
 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 输出:
 [
 [1,2,2],
 [5]
 ]


 提示:

 1 <= candidates.length <= 100
 1 <= candidates[i] <= 50
 1 <= target <= 30
 */

public class CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    LinkedList<List<Integer>> lists = new LinkedList<>();
    backTrack(lists,new LinkedList<Integer>(),candidates,target,0,new HashSet<Integer>());
    return lists;
  }
  //先排序,当candidates[i] == candidates[i-1]时跳过
  private void backTrack(LinkedList<List<Integer>> lists, LinkedList<Integer> path, int[] candidates, int target,int head, HashSet<Integer> useNum) {
    if(target == 0){
      lists.add(new ArrayList<>(path));
      return;
    }
    if(target < 0){
      return;
    }
    if(head > candidates.length-1 ){
     return;
    }
    for(int i = head;i<candidates.length;i++){
      if(i>head && candidates[i] == candidates[i-1]){
        continue;
      }
      path.add(candidates[i]);
      backTrack(lists,path,candidates,target - candidates[i],i+1,useNum);
      path.removeLast();
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

      List<List<Integer>> ret = new CombinationSumII().combinationSum2(candidates, target);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}