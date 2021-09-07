package com.回溯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 22. 括号生成
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 有效括号组合需满足：左括号必须以正确的顺序闭合。

 示例 1：

 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]
 示例 2：

 输入：n = 1
 输出：["()"]

 提示：

 1 <= n <= 8
 */

public class GenerateParentheses {
  public static List<String> generateParenthesis(int n) {
    List<String> strings = new ArrayList<String>();
    HashSet<String> strings1 = new HashSet<>();
    generateParenthesisBack(n, strings,"",0,0);
//    strings.addAll(strings1);
    return strings;
  }
  //回溯: ( 和 ) 数量相等
  public static void generateParenthesisBack(int n, List<String> result ,String s,int leftCount,int rightCount) {
    if(leftCount<rightCount){
      return;
    }
    if(s.length() == n*2){
      if(leftCount == rightCount){
        result.add(s);
      }
      return;
    }
    generateParenthesisBack(n,result,s + "(",leftCount+1,rightCount);
    generateParenthesisBack(n,result,s + ")",leftCount,rightCount+1);
  }
  public static String stringListToString(List<String> stringList) {
    StringBuilder sb = new StringBuilder("[");
    for (String item : stringList) {
      sb.append(item);
      sb.append(",");
    }

    sb.setCharAt(sb.length() - 1, ']');
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int n = Integer.parseInt(line);

      List<String> ret = generateParenthesis(n);

      String out = stringListToString(ret);

      System.out.print(out);
    }
  }
}