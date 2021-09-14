package com.arrays;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 4. 寻找两个正序数组的中位数
 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

 示例 1：

 输入：nums1 = [1,3], nums2 = [2]
 输出：2.00000
 解释：合并数组 = [1,2,3] ，中位数 2
 示例 2：
1,3,5,8,9
 1,2,3,12
 112234689
 输入：nums1 = [1,2], nums2 = [3,4]
 输出：2.50000
 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 示例 3：

 输入：nums1 = [0,0], nums2 = [0,0]
 输出：0.00000
 示例 4：

 输入：nums1 = [], nums2 = [1]
 输出：1.00000
 示例 5：

 输入：nums1 = [2], nums2 = []
 输出：2.00000


 提示：

 nums1.length == m
 nums2.length == n
 0 <= m <= 1000
 0 <= n <= 1000
 1 <= m + n <= 2000
 -106 <= nums1[i], nums2[i] <= 106


 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */

public class MedianofTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    LinkedList<Integer> integers = new LinkedList<>();
    double d = 0.0;
    for (int i : nums1) {
      integers.add(i);
    }
    for (int i : nums2) {
      integers.add(i);
    }
    Collections.sort(integers);
    if(integers.size()%2 == 0){
      d = (double)(integers.get(integers.size()/2-1)+ integers.get(integers.size()/2))/2;
    }else{
      d = (double)integers.get(integers.size()/2);
    }
    return d;
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

  public static String doubleToString(Double input) {
    return new DecimalFormat("0.00000").format(input);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[] nums1 = stringToIntegerArray(line);
      line = in.readLine();
      int[] nums2 = stringToIntegerArray(line);

      double ret = new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2);

      String out = doubleToString(ret);

      System.out.print(out);
    }
  }
}