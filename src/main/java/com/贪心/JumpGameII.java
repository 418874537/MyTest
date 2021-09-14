package com.贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 45. 跳跃游戏 II
 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 假设你总是可以到达数组的最后一个位置。

 示例 1:

 输入: nums = [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 示例 2:

 输入: nums = [2,3,0,1,4]
 输出: 2


 提示:

 1 <= nums.length <= 104
 0 <= nums[i] <= 1000
 通过次数193,635提交次数453,084
 */

public class JumpGameII {
  public int jump(int[] nums) {
    if(nums.length == 1){
      return 0;
    }
    int maxDist = nums[0];
    int count = 0;
    //使距离最远的起跳起点
    int jumpIndex = 0;
    //每次起跳,都找出起跳范围内i+nums[i]最大的 作为这次的目标
    //注意 这里用了个新的变量head来作为for循环的条件,jumpIndex作为[最优的目标点]在循环中会动态变化
    while(true){
      int head = jumpIndex;
      count++;
      if(maxDist >= nums.length-1){
        return count;
      }
      for(int i = head+1 ; i<= head+nums[head] ;i++){
        if(i==nums.length){
          break;
        }
        if(maxDist< i+nums[i]){
          maxDist = i+nums[i];
          jumpIndex = i;
        }
      }
      System.out.println("jumpIndex:"+jumpIndex);
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

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[] nums = stringToIntegerArray(line);

      int ret = new JumpGameII().jump(nums);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}