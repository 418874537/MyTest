package com.二分查找;

import net.sf.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 74. 搜索二维矩阵
 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

 每行中的整数从左到右按升序排列。
 每行的第一个整数大于前一行的最后一个整数。

 示例 1：

 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 输出：true
 示例 2：

 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 输出：false


 提示：

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 100
 -104 <= matrix[i][j], target <= 104
 */

public class Searcha2DMatrix {
  public static boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix[0].length;
    int lines = matrix.length;
    int head = 0;
    int end = rows*lines-1;
    int i = 0;
    while(head<=end){
      i = head+(end-head)/2;
//      System.out.println("i:"+i);
      int num = matrix[i / rows ][i % rows ];
//      System.out.println("num:"+num);
      if(num == target){
        return true;
      }else if(num < target){
        head = i+1;
      }else {
        end = i -1;
      }
    }
    return false;
  }
  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for(int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static int[][] stringToInt2dArray(String input) {
    JSONArray jsonArray = JSONArray.fromObject(input);
//    JSONArray jsonArray = JsonArray.readFrom(input);
    if (jsonArray.size() == 0) {
      return new int[0][0];
    }

    int[][] arr = new int[jsonArray.size()][];
    for (int i = 0; i < arr.length; i++) {
      JSONArray cols =  JSONArray.fromObject(jsonArray.get(i));
      arr[i] = stringToIntegerArray(cols.toString());
    }
    return arr;
  }

  public static String booleanToString(boolean input) {
    return input ? "True" : "False";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[][] matrix = stringToInt2dArray(line);
      line = in.readLine();
      int target = Integer.parseInt(line);

      boolean ret = searchMatrix(matrix, target);

      String out = booleanToString(ret);

      System.out.print(out);
    }
  }
}