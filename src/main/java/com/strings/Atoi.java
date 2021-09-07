package com.strings;

/**
 * @Description:
 * @Author: mayingjie@sensorsdata.com
 * @Date: 2021/7/27
 */
public class Atoi {
  /*
  myAtoi(string s) 的算法如下：

读入字符串并丢弃无用的前导空格
检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
返回整数作为最终结果。
注意：

本题中的空白字符只包括空格字符 ' ' 。
除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
   */
  public static void main(String[] args) {
    String s =   "  +0 123";
    int i1 = myAtoi(s);
    System.out.println(i1);

  }

  public static int myAtoi(String s) {
    String replaceS = subBlank(s);
    char[] chars = replaceS.toCharArray();
    int result = 0;
    char sign = '+';
    StringBuffer sb = new StringBuffer();
    if(chars.length>1){
      if(chars[0]=='-' ||chars[0]=='+'){
        sign = chars[0];
        if(!('0'<=chars[1] && chars[1]<='9')){
          return result;
        }
        for (int i = 1;i<chars.length;i++){
          if(!('0'<=chars[i]&&chars[i]<='9')){
            break;
          }
          sb.append(chars[i]);
        }
      }else if(!('0'<=chars[0] && chars[0]<='9')){
        return result;
      }else {
        for (int i = 0;i<chars.length;i++){
          if(!('0'<=chars[i]&&chars[i]<='9')){
            break;
          }
          sb.append(chars[i]);
        }
      }
      String ss = subZero(sb.toString());
      String s1 =sign+ ss;

      if(ss.length()>12){
        result = sign=='-'? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }else {
        Long aLong = Long.valueOf(s1);
        if(aLong>Integer.MAX_VALUE){
          result = Integer.MAX_VALUE;
        }else if(aLong<Integer.MIN_VALUE){
          result = Integer.MIN_VALUE;
        }else {
          result = aLong.intValue();
        }
      }
    }else if(chars.length!=0){
      if('0'<=chars[0] && chars[0]<='9'){
        return Integer.valueOf(chars[0]+"");
      }
    }
    return result;
  }

  private static String subZero(String toString) {
    char[] chars = toString.toCharArray();
    int index = -1;
    for(int i=0;i<chars.length;i++){
      if(chars[i]!='0'){
        index = i;
        break;
      }
    }

    String substring = index == -1 ?"0":toString.substring(index);
    System.out.println("sub:"+substring);
    return substring;
  }

  private static String subBlank(String toString) {
    char[] chars = toString.toCharArray();
    int index = -1;
    for(int i=0;i<chars.length;i++){
      if(chars[i]!=' '){
        index = i;
        break;
      }
    }

    String substring = index == -1 ?"":toString.substring(index);
    System.out.println("sub:"+substring);
    return substring;
  }
}
