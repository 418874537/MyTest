package review.d0908;

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
    LinkedList<List<Integer>> lists = new LinkedList<>();
    backTrack(lists,new LinkedList<>(),n,k);
    return lists;
  }

  private static void backTrack(LinkedList<List<Integer>> lists, LinkedList<Integer> integers, int n, int k) {
    if(integers.size()==k){
      lists.add(new ArrayList<>(integers));
    }
    for(int i = n;i>=1;i--){
      integers.add(i);
      backTrack(lists,integers,i-1,k);
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