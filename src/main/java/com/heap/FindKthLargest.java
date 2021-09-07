package com.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 215. 数组中的第K个最大元素
 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4


 提示：

 1 <= k <= nums.length <= 104
 -104 <= nums[i] <= 104
 */

public class FindKthLargest {
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());
    integers.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    int result = 0;
    for (int i = 0; i<k; i++){
      result = integers.poll();
    }
    return result;
  }

  public static int findKthLargest2(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
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
      line = in.readLine();
      int k = Integer.parseInt(line);

      int ret = findKthLargest(nums, k);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}