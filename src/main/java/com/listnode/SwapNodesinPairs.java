package com.listnode;

import com.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 24. 两两交换链表中的节点
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



 示例 1：


 输入：head = [1,2,3,4]
 输出：[2,1,4,3]
 示例 2：
1,2,3,4,5,6
 输入：head = []
 输出：[]
 示例 3：

 输入：head = [1]
 输出：[1]


 提示：

 链表中节点的数目在范围 [0, 100] 内
 0 <= Node.val <= 100


 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 */

public class SwapNodesinPairs {
  public ListNode swapPairs(ListNode head) {
//    if(head == null || head.next ==null){
//      return head;
//    }
    ListNode preHead = new ListNode(0,head);
    ListNode pre = preHead;
    while(pre.next!=null && pre.next.next!=null){
      ListNode first = pre.next;
      ListNode second = pre.next.next;
      first.next = second.next;
      second.next = first;
      pre.next = second;

      pre = pre.next.next;
    }
    return preHead.next;
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

      ListNode ret = new SwapNodesinPairs().swapPairs(head);

      String out = listNodeToString(ret);

      System.out.print(out);
    }
  }
}