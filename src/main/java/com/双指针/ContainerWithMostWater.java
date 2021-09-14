package com.双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 11. 盛最多水的容器
 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器。

 示例 1：

 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 示例 2：

 输入：height = [1,1]
 输出：1
 示例 3：

 输入：height = [4,3,2,1,4]
 输出：16
 示例 4：

 输入：height = [1,2,1]
 输出：2


 提示：

 n == height.length
 2 <= n <= 105
 0 <= height[i] <= 104
 */

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int head = 0;
    int end = height.length-1;
    int max = Math.min(height[head],height[end])*(end - head);
    while(head<end){
      if(height[head] <= height[end]){
        head++;
      }else{
        end--;
      }
      max = Math.max(max, Math.min(height[head],height[end])*(end - head));
    }
    return max;
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
      int[] height = stringToIntegerArray(line);

      int ret = new ContainerWithMostWater().maxArea(height);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}