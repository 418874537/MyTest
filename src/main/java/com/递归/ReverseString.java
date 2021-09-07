package com.递归;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 344. 反转字符串
 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。



 示例 1：

 输入：["h","e","l","l","o"]
 输出：["o","l","l","e","h"]
 示例 2：

 输入：["H","a","n","n","a","h"]
 输出：["h","a","n","n","a","H"]
 */
public class ReverseString {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      String s = line;
      char[] chars = s.toCharArray();
      reverseString(chars);
      String out = String.valueOf(chars);
      System.out.print(out);
    }
  }
  public static void reverseString(char[] s) {
    reverse(s,0);
  }
  public static void reverse(char[] s,int i) {
    if(i> s.length-1-i){
      return;
    }
    reverse(s,i+1);
    char c = s[i];
    s[i] = s[s.length-1-i];
    s[s.length-1-i] = c;
  }
}
