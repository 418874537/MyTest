package com.strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description:
 * @Author: mayingjie@sensorsdata.com
 * @Date: 2021/8/4
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
    StringBuffer result = new StringBuffer();
    if(numRows == 1) return s;
    HashMap<Integer, Character[]> map = new HashMap<>();
    numRows = numRows -1;
    int width = numRows * (s.length() / numRows / 2 + 1);
    for (int i = 0;i<=numRows;i++){
      map.put(i,new Character[width]);
    }
    char[] chars = s.toCharArray();
    Integer yu = 0;
    Integer lie = 0;
    for (int i = 0;i<chars.length;i++) {
      yu = i%numRows;
      lie = i/numRows;
      if(lie %2 ==0){
        map.get(yu)[lie/2 * numRows] = chars[i];
      }else   {
        map.get(numRows-yu)[lie/2 * numRows+yu] = chars[i];
      }
    }
    map.entrySet().forEach(integerMapEntry -> {

      for (Character character : integerMapEntry.getValue()) {
        if(character!=null){
          System.out.print(character);
          result.append(character);
        }else {
          System.out.print("*");
        }
      }
      System.out.println();
    });
    return result.toString();
  }
}
