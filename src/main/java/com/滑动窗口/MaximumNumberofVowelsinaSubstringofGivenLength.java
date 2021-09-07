package com.滑动窗口;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 1456. 定长子串中元音的最大数目
 给你字符串 s 和整数 k 。

 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。

 英文中的 元音字母 为（a, e, i, o, u）。

 示例 1：

 输入：s = "abciiidef", k = 3
 输出：3
 解释：子字符串 "iii" 包含 3 个元音字母。
 示例 2：

 输入：s = "aeiou", k = 2
 输出：2
 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 示例 3：

 输入：s = "leetcode", k = 3
 输出：2
 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 示例 4：

 输入：s = "rhythms", k = 4
 输出：0
 解释：字符串 s 中不含任何元音字母。
 示例 5：

 输入：s = "tryhard", k = 4
 输出：1
 提示：

 1 <= s.length <= 10^5
 s 由小写英文字母组成
 1 <= k <= s.length
 */

public class MaximumNumberofVowelsinaSubstringofGivenLength {
  public static int maxVowels(String s, int k) {
    int head = 0;
    int end = k-1;
//    List<Character> yuan = Arrays.asList('a', 'e', 'i', 'o', 'u');
    int count = 0;
    char[] chars = s.toCharArray();
    for(int i  = 0; i<= end ;i++){
      if(isMumNumber(chars[i])){
        count++;
      }
    }
    int maxCount = count;
    while(end<s.length()-1){
//      System.out.println(s.substring(head,end));
//      System.out.println(count);
      end++;
      head++;
      if(isMumNumber(chars[end])){
        count++;
      }
      if(isMumNumber(chars[head-1])){
        count--;
      }
      maxCount = Math.max(maxCount, count);
    }
    return maxCount;
  }
  public static boolean isMumNumber(char ch){
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }

  public static String stringToString(String input) {
    if (input == null) {
      return "null";
    }

    return input;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      String s = stringToString(line);
      line = in.readLine();
      int k = Integer.parseInt(line);

      int ret = maxVowels(s, k);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}