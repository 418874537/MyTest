package com.BFS;

import com.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 102. 二叉树的层序遍历
 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



 示例：
 二叉树：[3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层序遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
 */

public class BinaryTreeLevelOrderTraversal {

  //BFS?
  //queue: 用于存储每一层的队列,queueCount:每次做poll的次数（队列的长度）
  //首先要对root判空，否则把root加入队列
  //每次循环中，把队列长度重置。 再依次poll出该长度的结点，每次poll就把改节点的左右子节点加入队列。
  //当队列长度再次为0时说明该层没有数字了。
  public static List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root!=null){
      queue.add(root);
    }
    while (!queue.isEmpty()){
      int queueCount = queue.size();
      LinkedList<Integer> integers = new LinkedList<>();
      while(queueCount>0){
        TreeNode poll = queue.poll();
        integers.add(poll.val);
        queueCount--;
        if(poll.left != null){
          queue.add(poll.left);
        }
        if(poll.right !=null){
          queue.add(poll.right);
        }
      }
      result.add(integers);
    }
    return result;
  }
  public static List<List<Integer>> levelOrder2(TreeNode root) {
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    ArrayList<List<Integer>> result = new ArrayList<>();
    if(root!=null){
      queue.addLast(root);
    }
    while (!queue.isEmpty()){
      int size = queue.size();
      List<Integer> level = new LinkedList<>();
      for(int i = 0;i<size;i++){
        TreeNode first = queue.removeFirst();
        level.add(first.val);
        if(first.left!=null){
          queue.addLast(first.left);
        }
        if(first.right!=null){
          queue.addLast(first.right);
        }
      }
      result.add(level);
    }
    return result;
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

      List<List<Integer>> ret = levelOrder2(root);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}