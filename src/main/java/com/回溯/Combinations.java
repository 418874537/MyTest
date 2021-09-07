package com.回溯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 77. 组合
 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

 你可以按 任何顺序 返回答案。

 示例 1：

 输入：n = 4, k = 2
 输出：
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 示例 2：

 输入：n = 1, k = 1
 输出：[[1]]


 提示：

 1 <= n <= 20
 1 <= k <= n
 */

public class Combinations {
  public static List<List<Integer>> combine(int n, int k) {
    ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
    combineBack(lists,new LinkedList<Integer>(),n,k,1);
    return lists;
  }
  //回溯: 类似于78.子类, 优化: 用LinkedList存贮遍历路径结果, integers.add(i); integers.removeLast();不用新建对象了.
  //每次保存使用 new ArrayList<>(integers)
  private static void combineBack(ArrayList<List<Integer>> lists, LinkedList<Integer> integers, int n, int k,int j) {
    if(integers.size() == k ){
      lists.add(new ArrayList<>(integers));
      return;
    }
    for(int i = j;i <= n;i++){
//      ArrayList<Integer> list = new ArrayList<>(integers);
      integers.add(i);
      combineBack(lists,integers,n,k,i+1);
      integers.removeLast();
    }
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
      int n = Integer.parseInt(line);
      line = in.readLine();
      int k = Integer.parseInt(line);

      List<List<Integer>> ret = combine(n, k);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}