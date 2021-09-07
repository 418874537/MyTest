package com.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 20. 有效的括号
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。

 示例 1：

 输入：s = "()"
 输出：true
 示例 2：

 输入：s = "()[]{}"
 输出：true
 示例 3：

 输入：s = "(]"
 输出：false
 示例 4：

 输入：s = "([)]"
 输出：false
 示例 5：

 输入：s = "{[]}"
 输出：true

 提示：

 1 <= s.length <= 104
 s 仅由括号 '()[]{}' 组成
 */

public class ValidParentheses {
  public static  boolean isValid(String s) {
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack();
    for (char aChar : chars) {
      if(aChar == '(' || aChar == '[' || aChar == '{'){
        stack.push(aChar);
      }
      if(stack.isEmpty()){
        return false;
      }
      if(aChar == ')' && !stack.pop().equals('(')){
        return false;
      }
      if(aChar == ']' && !stack.pop().equals('[')){
        return false;
      }
      if(aChar == '}' && !stack.pop().equals('{')){
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static String stringToString(String input) {
    if (input == null) {
      return "null";
    }
    return  input;
  }

  public static String booleanToString(boolean input) {
    return input ? "True" : "False";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      String s = stringToString(line);

      boolean ret = isValid(s);

      String out = booleanToString(ret);

      System.out.print(out);
    }
  }
}