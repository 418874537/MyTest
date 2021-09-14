package com.回溯;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 47. 全排列 II
 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

 示例 1：

 输入：nums = [1,1,2]
 输出：
 [[1,1,2],
 [1,2,1],
 [2,1,1]]
 示例 2：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


 提示：

 1 <= nums.length <= 8
 -10 <= nums[i] <= 10
 */

public class PermutationsII {
  public List<List<Integer>> permuteUnique(int[] nums) {
    ArrayList<List<Integer>> lists = new ArrayList<>();
    Arrays.sort(nums);
    backTack(lists,nums,new LinkedList<>(),0);
    return lists;
  }

  private void backTack(ArrayList<List<Integer>> lists, int[] nums, LinkedList<Integer> path, int index) {
    if(path.size() == nums.length){
//      System.out.println(path);
      lists.add(new ArrayList<>(path).stream().map(i->nums[i]).collect(Collectors.toList()));
      return;
    }
    for(int i = 0;i<nums.length; i++){
      //去除自身重复
      if(path.contains(i)){
        continue;
      }
      //这里有2个判断:
      //1. 当前的数字相比之前是重复的
      //2. 满足条件1时, 那之前的重复的数字必须已经被加入到path中了->即 [满足顺序] ,若不满足,则跳过.
      if(i>0 && nums[i] == nums[i-1] && !path.contains(i-1) ){
        continue;
      }
      path.add(i);
      backTack(lists,nums,path,index+1);
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
      int[] nums = stringToIntegerArray(line);

      List<List<Integer>> ret = new PermutationsII().permuteUnique(nums);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}