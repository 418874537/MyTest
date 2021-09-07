package review;

import java.util.HashMap;
import java.util.Scanner;

/**
 6. Z 字形变换
 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

 P   A   H   N
 A P L S I I G
 Y   I   R
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);


 示例 1：

 输入：s = "PAYPALISHIRING", numRows = 3
 输出："PAHNAPLSIIGYIR"
 示例 2：
 输入：s = "PAYPALISHIRING", numRows = 4
 输出："PINALSIGYAHRPI"
 解释：
 P     I    N
 A   L S  I G
 Y A   H R
 P     I

 P       H
 A     S I
 Y   I   R
 P L     I G
 A       N

 示例 3：

 输入：s = "A", numRows = 1
 输出："A"


 提示：

 1 <= s.length <= 1000
 s 由英文字母（小写和大写）、',' 和 '.' 组成
 1 <= numRows <= 1000
 */

/*
3:
0   4   8    12
1 3 5 7 9 11 13 15
2   6   10   14

4:
0     6     12
1   5 7  11 13
2 4   8 10  14
3     9     15

5:
0       8
1     7 9      15
2   6   10  14width
3 5     1113
4       12
 */
public class Zconvert {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = "";
    int b = 0;
    // 注意 hasNext 和 hasNextLine 的区别
    // 注意 while 处理多个 case
    while (in.hasNextLine()){
      String s = in.nextLine();
      if (s.equals("0")) {
        break;
      }
      System.out.println(Integer.parseInt(s)/2);
    }

//    String a = convert("12345678912345678", 4);

  }

  public static String convert(String s, int numRows) {

    return null;
  }
}
