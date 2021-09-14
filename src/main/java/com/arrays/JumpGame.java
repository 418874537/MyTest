package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 55. 跳跃游戏
 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个下标。



 示例 1：

 输入：nums = [2,3,1,1,4]
 输出：true
 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 示例 2：

 输入：nums = [3,2,1,0,4]
 输出：false
 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


 提示：

 1 <= nums.length <= 3 * 104
 0 <= nums[i] <= 105
 */

public class JumpGame {
  //倒序遍历: 从最后的位置往回跳,看是否能回到0位置.
  //lastIndex: 当前的位置与上次可以到达的位置的距离 小于等于 nums[i],说明该位置也是可以到达的.
  public boolean canJump(int[] nums) {
    int lastIndex = nums.length-1;
    for(int i = nums.length-1;i>=0;i--){
      if(lastIndex -i <= nums[i]){
        lastIndex = i;
      }
    }
    return lastIndex==0;
  }
  //正序遍历: 贪心算法,维护最远可以到达的位置
  public boolean canJump2(int[] nums) {
    int maxIndex = nums[0];
    for(int i = 0; i<nums.length ; i++){
      //如果当前位置小于最远位置,说明往后不能再到达了.
      if(maxIndex >= i){
        maxIndex = Math.max(maxIndex,i+nums[i]);
      }else{
        return false;
      }
      //最远位置提前判断可以提前退出循环
      if(maxIndex>=nums.length-1){
        return true;
      }
    }
    return maxIndex >= nums.length-1;
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

  public static String booleanToString(boolean input) {
    return input ? "True" : "False";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[] nums = stringToIntegerArray(line);

      boolean ret = new JumpGame().canJump2(nums);

      String out = booleanToString(ret);

      System.out.print(out);
    }
  }
}