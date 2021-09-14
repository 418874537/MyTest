package review.d0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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
    LinkedList<String> strings = new LinkedList<>();
    backTrack(strings,"",n,n,2*n);
    return strings;
  }

  private static void backTrack(LinkedList<String> strings, String path, int leftOfLeft, int leftOfRight,int size) {
    if(path.length() == size){
      if(leftOfLeft == leftOfRight){
        strings.add(path);
      }
      return;
    }
    if(leftOfLeft>leftOfRight){
      return;
    }
//    if(leftOfLeft == 0){
//      for(int i=0;i<leftOfRight;i++){
//        path = path+")";
//      }
//      strings.add(path);
//      return;
//    }
    backTrack(strings, path+"(",leftOfLeft-1,leftOfRight,size);
    backTrack(strings, path+")",leftOfLeft,leftOfRight-1,size);
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