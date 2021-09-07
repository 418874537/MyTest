package com.双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 881. 救生艇
 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。

 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。

 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。

 示例 1：

 输入：people = [1,2], limit = 3
 输出：1
 解释：1 艘船载 (1, 2)
 示例 2：

 输入：people = [3,2,2,1], limit = 3
 输出：3
 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 示例 3：

 输入：people = [3,5,3,4], limit = 5
 输出：4
 解释：4 艘船分别载 (3), (3), (4), (5)
 提示：

 1 <= people.length <= 50000
 1 <= people[i] <= limit <= 30000
 */

public class BoatstoSavePeople {
  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int count = 0;
    int j = 0;
    for(int i = people.length-1; i >=0 ;i--){
      if( i>j && people[i]+people[j]>limit ){
        count++;
      }else if(i>j && people[i]+people[j]<=limit){
        count++;
        j++;
      }else if(i==j){
        count++;
        break;
      }else if(i<j){
        break;
      }
    }
    return count;
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
      int[] people = stringToIntegerArray(line);
      line = in.readLine();
      int limit = Integer.parseInt(line);

      int ret = numRescueBoats(people, limit);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}