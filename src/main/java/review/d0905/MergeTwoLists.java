package review.d0905;

import com.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 21. 合并两个有序链表
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例 1：


 输入：l1 = [1,2,4], l2 = [1,3,4]
 输出：[1,1,2,3,4,4]
 示例 2：

 输入：l1 = [], l2 = []
 输出：[]
 示例 3：

 输入：l1 = [], l2 = [0]
 输出：[0]


 提示：

 两个链表的节点数目范围是 [0, 50]
 -100 <= Node.val <= 100
 l1 和 l2 均按 非递减顺序 排列

 */
class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(3, new ListNode(5,new ListNode(8))));
        ListNode listNode2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        System.out.println(mergeTwoLists(listNode1,listNode2));
    }
    //循环
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<Integer> integers = new ArrayList<>();
        while(l1!=null){
            integers.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            integers.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(integers);
        ListNode head = new ListNode(0);
        ListNode next = head;
        for (Integer integer : integers) {
            ListNode listNode = new ListNode(integer);
            next.next = listNode;
            next = next.next;
        }
        return head.next;
    }
}

