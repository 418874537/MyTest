package com.DFS;

import com.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 98. 验证二叉搜索树
 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

 有效 二叉搜索树定义如下：

 节点的左子树只包含 小于 当前节点的数。
 节点的右子树只包含 大于 当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。


 示例 1：


 输入：root = [2,1,3]
 输出：true
 示例 2：


 输入：root = [5,1,4,null,null,3,6]
 输出：false
 解释：根节点的值是 5 ，但是右子节点的值是 4 。

    5
  4  6
n n 3 7
 提示：

 树中节点数目范围在[1, 104] 内
 -231 <= Node.val <= 231 - 1
 */

public class ValidateBinarySearchTree {
  //中序遍历后必定是升序排列,否则为false
  public static boolean isValidBST(TreeNode root) {
    List<Integer> traval = traval(root);
    for (int i = 1;i<traval.size();i++ ) {
      if(traval.get(i)<=traval.get(i-1)){
        return false;
      }
    }
    return true;
  }
  public static List<Integer> traval(TreeNode root) {
    ArrayList<Integer> integers = new ArrayList<>();
    if(root == null){
      return integers;
    }

    integers.addAll(traval(root.left));
    integers.add(root.val);
    integers.addAll(traval(root.right));
    return integers;
  }
  //递归 左边的所有数字都要小于当前节点的数。
  //注意边界值: 使用long来做边界
  public static boolean isValidBST2(TreeNode root) {
    return isValidInRange(root,Long.MIN_VALUE,Long.MAX_VALUE);
  }

  private static boolean isValidInRange(TreeNode root, long min, long max) {
    if(root == null ){
      return true;
    }
    if(root.val <=min || root.val >=max){
      return false;
    }
    boolean left = isValidInRange(root.left, min, root.val);
    boolean right = isValidInRange(root.right, root.val, max);
    return left && right;
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

      boolean ret = isValidBST2(root);

      String out = booleanToString(ret);

      System.out.print(out);
    }
  }
}