package com.DFS;

import com.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 938. 二叉搜索树的范围和
 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。

 示例 1：


 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 输出：32
 示例 2：


 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 输出：23


 提示：

 树中节点数目在范围 [1, 2 * 104] 内
 1 <= Node.val <= 105
 1 <= low <= high <= 105
 所有 Node.val 互不相同
 */

public class RangeSumofBST {
  public static int rangeSumBST(TreeNode root, int low, int high) {
    int[] ints = {0};
    rangeSumBSTDFS(ints,root,low,high);
    return ints[0];
  }

  private static void rangeSumBSTDFS(int[] sum, TreeNode root, int low, int high) {
    if(root == null){
      return;
    }
    //二叉搜索树:左子树一定不大于节点,右子树一定不小于节点
    //所以当大于high时,只需遍历左子树,反之亦然
    if(root.val>high){
      rangeSumBSTDFS(sum,root.left,low,high);
      return;
    }
    if(root.val<low){
      rangeSumBSTDFS(sum,root.right,low,high);
      return;
    }else{
//      integers.add(root.val);
      sum[0] = sum[0]+root.val;
//      System.out.println(sum);
      rangeSumBSTDFS(sum,root.right,low,high);
      rangeSumBSTDFS(sum,root.left,low,high);
    }

  }

  public static int rangeSumBST2(TreeNode root, int low, int high) {
    if(root == null){
      return 0;
    }
    //di
    int left = rangeSumBST2(root.left, low, high);
    int right = rangeSumBST2(root.right, low, high);
    //gui
    if(root.val>high){
      return left;
    }
    if(root.val<low){
      return right;
    }else{
      return root.val+ left + right;
    }
  }

  public static TreeNode stringToTreeNode(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(Integer.parseInt(item));
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while(!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int leftNumber = Integer.parseInt(item);
        node.left = new TreeNode(leftNumber);
        nodeQueue.add(node.left);
      }

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int rightNumber = Integer.parseInt(item);
        node.right = new TreeNode(rightNumber);
        nodeQueue.add(node.right);
      }
    }
    return root;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      TreeNode root = stringToTreeNode(line);
      line = in.readLine();
      int low = Integer.parseInt(line);
      line = in.readLine();
      int high = Integer.parseInt(line);

      int ret = rangeSumBST(root, low, high);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}