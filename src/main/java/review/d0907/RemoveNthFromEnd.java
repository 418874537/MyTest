package review.d0907;

import com.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveNthFromEnd {
  /*
19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？
示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]


提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */

  /*
  双指针
   */
  public static ListNode removeNthFromEnd2(ListNode head, int n) {
    LinkedList<ListNode> listNodes = new LinkedList<ListNode>();
    ListNode tail = head;
    while(tail!=null){
      listNodes.add(tail);
      tail = tail.next;
    }
    if(n<listNodes.size()){
      listNodes.get(listNodes.size()-n-1).next = listNodes.get(listNodes.size()-n-1).next.next;
    }else{
      head = head.next;
    }

    return head;
  }
  public static void main(String[] args) {
    ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//    ListNode listNode = new ListNode(1);
//    ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(removeNthFromEnd2(listNode,5));
  }
}