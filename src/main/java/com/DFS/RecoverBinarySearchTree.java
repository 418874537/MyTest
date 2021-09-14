package com.DFS;

import static com.DFS.ValidateBinarySearchTree.traval;

import com.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 99. 恢复二叉搜索树
 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。

 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？

 示例 1：
    1
  3   n
 n 2
 输入：root = [1,3,null,null,2]
 输出：[3,1,null,null,2]
 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 示例 2：

 输入：root = [3,1,4,null,null,2]
 输出：[2,1,4,null,null,3]
 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
   3
 1   4
n n 2
 提示：
12435
 树上节点的数目在范围 [2, 1000] 内
 -231 <= Node.val <= 231 - 1
 */

public class RecoverBinarySearchTree {
  public void recoverTree(TreeNode root) {
    //中序遍历？升序交换？
    LinkedList<TreeNode> trval = trval(root);
    //交换：大于后一位的数  和 小于 前一位的数
    TreeNode before = null;
    TreeNode after = null;
    int findBefore = 0;
    while(findBefore<trval.size()-1) {
      if(trval.get(findBefore).val > trval.get(findBefore+1).val){
        before = trval.get(findBefore);
        break;
      }
      findBefore++;
    }
    int findAfter = trval.size()-1;
    while(findAfter>0) {
      if(trval.get(findAfter).val < trval.get(findAfter-1).val){
        after = trval.get(findAfter);
        break;
      }
      findAfter--;
    }
    int temp = before.val;
    before.val = after.val;
    after.val = temp;
  }

  private LinkedList<TreeNode> trval(TreeNode root) {
    LinkedList<TreeNode> ret = new LinkedList<>();
    if(root == null){
      return ret;
    }
    ret.addAll(trval(root.left));
    ret.add(root);
    ret.addAll(trval(root.right));
    return ret;
  }
  public void recoverTree2(TreeNode root) {
    //中序遍历中找出错误的元素
    TreeNode before = null;
    TreeNode after = null;
    List<TreeNode> ret = traval2(root,before,after);
    //如果当前加入的比末尾的小，说明末尾的有可能是被交换过的
    // 13 9 56 4 ： 5比9小，9就是before ，并且只会是第一个满足条件的是，后面的 6不算了
    // 13 9 4 :
    //如果当前加入的比末尾的小，说明当前的元素有可能是被交换过的
    //取最后一个满足条件的，即：before看第一个满足条件的， after看最后一个满足条件的。
    for(int i = 0 ;i < ret.size() ; i++){
      if(i>0 && ret.get(i-1).val > ret.get(i).val){
        if(before == null){
          before = ret.get(i-1);
        }
        after = ret.get(i);
      }
    }
    int temp = before.val;
    before.val = after.val;
    after.val = temp;
  }

  private List<TreeNode> traval2(TreeNode root, TreeNode before, TreeNode after) {
    LinkedList<TreeNode> ret = new LinkedList<>();
    if(root == null){
      return ret;
    }
    List<TreeNode> l = traval2(root.left, before, after);
    List<TreeNode> r = traval2(root.right, before, after);

    ret.addAll(l);
    ret.add(root);
    ret.addAll(r);

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

      new RecoverBinarySearchTree().recoverTree2(root);
      String out = treeNodeToString(root);

      System.out.print(out);
    }
  }
}