package com.strings;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 5. 最长回文子串
 给你一个字符串 s，找到 s 中最长的回文子串。

 示例 1：

 输入：s = "babad"
           dabab
 输出："bab"
 解释："aba" 同样是符合题意的答案。
 示例 2：

 输入：s = "cbbd"
 输出："bb"
 示例 3：

 输入：s = "a"
 输出："a"
 示例 4：

 输入：s = "ac"
 输出："a"


 提示：

 1 <= s.length <= 1000
 s 仅由数字和英文字母（大写和/或小写）组成
 */

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {

    char[] chars = s.toCharArray();
    String max = chars[0]+"";
    for (int i = 0;i< chars.length;i++){
      //每个元素作为最中间的数(回文串长度是奇数):
      int head = i;
      int end =i;
      while(head>=0 && end<chars.length && chars[head] == chars[end] ){
        head--;
        end++;
      }
      max = end -head > max.length()? s.substring(head+1,end):max;
      //每个元素作为最中间的左边的数(回文串长度是偶数):
      head = i;
      end =i+1;
      while(head>=0 && end<chars.length && chars[head] == chars[end]){
        head--;
        end++;
      }
      max = end -head > max.length()? s.substring(head+1,end):max;
    }
    return max;
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

      String ret = new LongestPalindromicSubstring().longestPalindrome(s);

      String out = (ret);

      System.out.print(out);
    }
  }
}