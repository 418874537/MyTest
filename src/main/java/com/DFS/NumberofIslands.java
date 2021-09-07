package com.DFS;

import java.util.HashSet;

/**
 200. 岛屿数量
 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

 此外，你可以假设该网格的四条边均被水包围。

 示例 1：

 输入：grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 输出：1
 示例 2：

 输入：grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 输出：3


 提示：

 m == grid.length
 n == grid[i].length
 1 <= m, n <= 300
 grid[i][j] 的值为 '0' 或 '1'
 */
public class NumberofIslands {
  //DFS 每次搜索都把结果存储.
  public static int numIslands(char[][] grid) {
    int count = 0;
    HashSet<Integer> useSet = new HashSet<>();
    for(int i = 0 ;i < grid.length; i++){
      for (int j = 0; j < grid[0].length ; j++){
        if(grid[i][j] == '1'){
          if(useSet.contains(grid[0].length*i+j)){
            continue;
          }
          HashSet<Integer> hashSet = new HashSet<Integer>();
          NumberofIslandsDfs(hashSet,grid,i,j);
          useSet.addAll(hashSet);
          count++;

        }
      }
    }

    return count;
  }

  //
  private static void NumberofIslandsDfs( HashSet<Integer> hashSet, char[][] grid,int i,int j) {
    if(i == -1 || i == grid.length) {
      return;
    }
    if(j == -1 || j == grid[0].length){
      return;
    }
    if(grid[i][j] == '0'){
      return;
    }
    if(hashSet.contains(i*grid[0].length+j)){
      return;
    }
    hashSet.add(i*grid[0].length+j);

    NumberofIslandsDfs(hashSet,grid,i+1,j);
    NumberofIslandsDfs(hashSet,grid,i-1,j);
    NumberofIslandsDfs(hashSet,grid,i,j+1);
    NumberofIslandsDfs(hashSet,grid,i,j-1);
  }
  //DFS: 每次搜索都把1变为0,返回搜索的次数
  public static int numIslands2(char[][] grid) {
    int count = 0;
    for(int i = 0 ;i < grid.length; i++){
      for (int j = 0; j < grid[0].length ; j++){
        if(grid[i][j] == '1'){
          NumberofIslandsDfs(grid,i,j);
          count++;
        }
      }
    }
//    }

    return count;
  }
  //碰到边界或0返回,否则把1置为0
  private static void NumberofIslandsDfs( char[][] grid,int i,int j) {
    if(i == -1 || i == grid.length|| j == -1 || j == grid[0].length||grid[i][j] == '0') {
      return;
    }else{
      grid[i][j] = '0';
      NumberofIslandsDfs(grid,i+1,j);
      NumberofIslandsDfs(grid,i-1,j);
      NumberofIslandsDfs(grid,i,j+1);
      NumberofIslandsDfs(grid,i,j-1);
    }

  }
  public static void main(String[] args) {
    char[][] chars = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};
    System.out.println(numIslands2(chars));
  }
}
