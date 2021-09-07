package com.BFS;

import com.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 107. 二叉树的层序遍历 II
 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其自底向上的层序遍历为：

 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BinaryTreeLevelOrderTraversalII {
  public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    ArrayList<List<Integer>> ret = new ArrayList<>();
    ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
    if(root == null){
      return ret;
    }else{
      arrayDeque.add(root);
    }

    while(!arrayDeque.isEmpty()){
      LinkedList<Integer> levelRet = new LinkedList<>();
      int size = arrayDeque.size();
      for (int i = 0; i < size; i++){
        TreeNode first = arrayDeque.removeFirst();
        levelRet.add(first.val);
        if(first.left != null){
          arrayDeque.addLast(first.left);
        }
        if(first.right != null){
          arrayDeque.addLast(first.right);
        }
      }
      ret.add(levelRet);
    }
    Collections.reverse(ret);
    return ret;
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

  public static String integerArrayListToString(List<Integer> nums, int length) {
    if (length == 0) {
      return "[]";
    }

    String result = "";
    for(int index = 0; index < length; index++) {
      Integer number = nums.get(index);
      result += Integer.toString(number) + ", ";
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static String integerArrayListToString(List<Integer> nums) {
    return integerArrayListToString(nums, nums.size());
  }

  public static String int2dListToString(List<List<Integer>> nums) {
    StringBuilder sb = new StringBuilder("[");
    for (List<Integer> list: nums) {
      sb.append(integerArrayListToString(list));
      sb.append(",");
    }

    sb.setCharAt(sb.length() - 1, ']');
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      TreeNode root = stringToTreeNode(line);

      List<List<Integer>> ret = levelOrderBottom(root);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}