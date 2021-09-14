package com.DFS;

import com.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 114. 二叉树展开为链表
 给你二叉树的根结点 root ，请你将它展开为一个单链表：

 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 展开后的单链表应该与二叉树 先序遍历 顺序相同。

 示例 1：

 输入：root = [1,2,5,3,4,null,6]
 输出：[1,null,2,null,3,null,4,null,5,null,6]
 示例 2：

 输入：root = []
 输出：[]
 示例 3：

 输入：root = [0]
 输出：[0]
     1
  2    5
3  4    6


 提示：

 树中结点数在范围 [0, 2000] 内
 -100 <= Node.val <= 100


 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */

public class FlattenBinaryTreetoLinkedList {
  //前序遍历数组
  //迭代数组赋值
  public void flatten(TreeNode root) {
    LinkedList<Integer> list = travalHead(root);
    TreeNode tail = root;
    for(int i = 0 ;i < list.size() ;i++){
      if(i == 0){
        continue;
      }
      TreeNode treeNode = new TreeNode(list.get(i));
      tail.right = treeNode;
      tail.left = null;
      tail = tail.right;
    }
  }

  private LinkedList<Integer> travalHead(TreeNode root) {
    LinkedList<Integer> res = new LinkedList<>();
    if(root == null) {
      return res;
    }
    res.add(root.val);
    res.addAll(travalHead(root.left));
    res.addAll(travalHead(root.right));
    return res;
  }

  /*
     1              1           1
  2    5    ->   2    5  ->       2
3  4    6         3    6          ...
                   4
   */
  //将每个节点的right放到left右边成一条链, 再将left 移动到right上.
  public void flatten2(TreeNode root) {
    if(root == null){
      return;
    }
    //左右都成一条链表
    flatten2(root.left);
    flatten2(root.right);
    //左,右链表
    TreeNode left = root.left;
    if(left == null){
      return;
    }
    //左链表的头指针先存起来
    TreeNode leftHead = root.left;

    //右链表放到左链表后
    while(left.right!=null){
      left = left.right;
    }
    left.right = root.right;

    //将整个左边的链表放到右边,左边置为空
    root.right = leftHead;
    root.left = null;
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

  public static String treeNodeToString(TreeNode root) {
    if (root == null) {
      return "[]";
    }

    String output = "";
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);
    while(!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (node == null) {
        output += "null, ";
        continue;
      }

      output += String.valueOf(node.val) + ", ";
      nodeQueue.add(node.left);
      nodeQueue.add(node.right);
    }
    return "[" + output.substring(0, output.length() - 2) + "]";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      TreeNode root = stringToTreeNode(line);

      new FlattenBinaryTreetoLinkedList().flatten2(root);
      String out = treeNodeToString(root);

      System.out.print(out);
    }
  }
}