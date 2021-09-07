package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 485. 最大连续 1 的个数
 给定一个二进制数组， 计算其中最大连续 1 的个数。
 示例：
 输入：[1,1,0,1,1,1]
 输出：3
 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.

 提示：
 输入的数组只包含 0 和 1 。
 输入数组的长度是正整数，且不超过 10,000。
 */


public class FindMaxConsecutiveOnes {
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

      int ret = findMaxConsecutiveOnes(nums);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
  public static int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int max = 0;
    for (int num : nums) {
      max = max <count? count:max;
      count = num==0 ? 0: count+1;
    }
    return max <count? count:max;
  }
}