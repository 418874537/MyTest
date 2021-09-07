package com.treenode;

import com.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 144. 二叉树的前序遍历
 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 示例 1：


 输入：root = [1,null,2,3]
 输出：[1,2,3]
 示例 2：

 输入：root = []
 输出：[]
 示例 3：

 输入：root = [1]
 输出：[1]
 示例 4：


 输入：root = [1,2]
 输出：[1,2]
 示例 5：


 输入：root = [1,null,2]
 输出：[1,2]
 提示：

 树中节点数目在范围 [0, 100] 内
 -100 <= Node.val <= 100
 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */

public class PreorderTraversal {
  public static List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> integers = new ArrayList<Integer>();
    //终止条件
    if(root == null){
      return integers;
    }
    //递
    List<Integer> lefts = preorderTraversal(root.left);
    List<Integer> rights = preorderTraversal(root.right);
    //归
    integers.add(root.val);
    integers.addAll(lefts);
    integers.addAll(rights);
    return integers;
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

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      TreeNode root = stringToTreeNode(line);

      List<Integer> ret = preorderTraversal(root);

      String out = integerArrayListToString(ret);

      System.out.print(out);
    }
  }
}