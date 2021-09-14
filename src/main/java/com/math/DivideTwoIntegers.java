package com.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 29. 两数相除
 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

 返回被除数 dividend 除以除数 divisor 得到的商。

 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2



 示例 1:

 输入: dividend = 10, divisor = 3
 输出: 3
 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 示例 2:

 输入: dividend = 7, divisor = -3
 输出: -2
 解释: 7/-3 = truncate(-2.33333..) = -2


 提示：

 被除数和除数均为 32 位有符号整数。2147483647
 除数不为 0。
 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */


public class DivideTwoIntegers {
  public int divide(int dividend, int divisor) {
    if(dividend == Integer.MIN_VALUE && divisor == -1){
      return Integer.MAX_VALUE;
    }
    if(divisor == 1){
      return dividend;
    }
    if(divisor == -1){
      return -dividend;
    }
    int count = 0;
    boolean isNegative = false;
    if(dividend >= 0 && divisor < 0){
      dividend = -dividend;
      isNegative = true;
    }else if(dividend <= 0 && divisor > 0){
      divisor = -divisor;
      isNegative = true;
    }else if(dividend >= 0 && divisor > 0){
      dividend = -dividend;
      divisor = -divisor;
    }
    while(dividend <= divisor){
      dividend = dividend - divisor;
      count++;
    }
    return isNegative? -count:count;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int dividend = Integer.parseInt(line);
      line = in.readLine();
      int divisor = Integer.parseInt(line);

      int ret = new DivideTwoIntegers().divide(dividend, divisor);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}