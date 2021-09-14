package com.DFS;

import com.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 112. 路径总和
 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

 叶子节点 是指没有子节点的节点。



 示例 1：


 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 输出：true
 示例 2：


 输入：root = [1,2,3], targetSum = 5
 输出：false
 示例 3：

 输入：root = [1,2], targetSum = 0
 输出：false


 提示：

 树中节点的数目在范围 [0, 5000] 内
 -1000 <= Node.val <= 1000
 -1000 <= targetSum <= 1000
 */

public class PathSum {
  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if(root == null){
      return false;
    }
    return DFS(root,targetSum);

  }

  private static boolean DFS( TreeNode root, int targetSum) {
    //退出条件: 是叶子节点->左右都为null
    if(root == null){
      return false;
    }
    if(root.left == null && root.right == null){
      return targetSum == root.val;
    }

    boolean l = DFS(root.left, targetSum - root.val);
    boolean r = DFS(root.right, targetSum - root.val);

    return l||r;
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

  public static String booleanToString(boolean input) {
    return input ? "True" : "False";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      TreeNode root = stringToTreeNode(line);
      line = in.readLine();
      int targetSum = Integer.parseInt(line);

      boolean ret = hasPathSum(root, targetSum);

      String out = booleanToString(ret);

      System.out.print(out);
    }
  }
}