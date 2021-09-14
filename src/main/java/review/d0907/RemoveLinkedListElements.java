package review.d0907;

import com.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 203. 移除链表元素
 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 示例 1：
 输入：head = [1,2,6,3,4,5,6], val = 6
 输出：[1,2,3,4,5]
 示例 2：

 输入：head = [], val = 1
 输出：[]
 示例 3：

 输入：head = [7,7,7,7], val = 7
 输出：[]
 提示：
 列表中的节点数目在范围 [0, 104] 内
 1 <= Node.val <= 50
 0 <= val <= 50
 */
public class RemoveLinkedListElements {
  public static ListNode removeElements(ListNode head, int val) {
    ListNode headBefore = new ListNode(0,head);
    ListNode next = headBefore;
    while( next.next!=null){
      if(next.next.val == val){
        next.next = next.next.next;
      }else{
        next = next.next;
      }
    }
    return headBefore.next;
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
      line = in.readLine();
      int val = Integer.parseInt(line);

      ListNode ret = removeElements(head, val);

      String out = listNodeToString(ret);

      System.out.print(out);
    }
  }
}