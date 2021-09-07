package com.listnode;

import com.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 206. 反转链表
 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


 示例 1：


 输入：head = [1,2,3,4,5]
 输出：[5,4,3,2,1]
 示例 2：


 输入：head = [1,2]
 输出：[2,1]
 示例 3：

 输入：head = []
 输出：[]


 提示：

 链表中节点的数目范围是 [0, 5000]
 -5000 <= Node.val <= 5000


 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class ReverseList {

  //两次遍历
  public static ListNode reverseList(ListNode head) {
    ArrayList<ListNode> listNodes = new ArrayList<>();
    while (head!=null){
      listNodes.add(head);
      head = head.next;
    }
    ListNode result = new ListNode(0);
    ListNode tail = result;
    Collections.reverse(listNodes);
    for (ListNode listNode : listNodes) {
      tail.next = new ListNode(listNode.val);
      tail = tail.next;
    }
    return result.next;
  }

  //迭代
  public static ListNode reverseList2(ListNode head) {
    ListNode now = head;
    ListNode pre = null;
    while (now!=null){
      //暂存next
      ListNode next = now.next;
      //反转当前指针
      now.next = pre;
      //移动now,pre
      pre = now;
      now = next;
    }
    return pre;
  }

  //递归
  public static ListNode reverseList3(ListNode head) {
    //终止条件
    if(head == null || head.next == null){
      return head;
    }
    //递
    ListNode listNode = reverseList3(head.next);
    //归
    //每次递归里, 第一个节点与后面的节点互换位置
    head.next.next = head;
    //这里不置为空的话,就会无限循环栈溢出
    head.next = null;
    return listNode;
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

  public static ListNode stringToListNode(String input) {
    // Generate array from the input
    int[] nodeValues = stringToIntegerArray(input);

    // Now convert that list into linked list
    ListNode dummyRoot = new ListNode(0);
    ListNode ptr = dummyRoot;
    for(int item : nodeValues) {
      ptr.next = new ListNode(item);
      ptr = ptr.next;
    }
    return dummyRoot.next;
  }

  public static String listNodeToString(ListNode node) {
    if (node == null) {
      return "[]";
    }

    String result = "";
    while (node != null) {
      result += Integer.toString(node.val) + ", ";
      node = node.next;
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      ListNode head = stringToListNode(line);

      ListNode ret = reverseList3(head);

      String out = listNodeToString(ret);

      System.out.print(out);
    }
  }
}