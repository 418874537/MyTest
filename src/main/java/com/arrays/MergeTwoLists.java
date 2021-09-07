package com.arrays;

import com.ListNode;

/**
 * Definition for singly-linked list.
 * public class java.arrays.java.ListNode {
 *     int val;
 *     java.arrays.java.ListNode next;
 *     java.arrays.java.ListNode() {}
 *     java.arrays.java.ListNode(int val) { this.val = val; }
 *     java.arrays.java.ListNode(int val, java.arrays.java.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(3, new ListNode(5,new ListNode(8))));
        ListNode listNode2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        System.out.println(mergeTwoLists2(listNode1,listNode2));
    }
    //循环
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 !=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            temp.next = l1;
        }
        if(l2!=null){
            temp.next = l2;
        }

        return head.next;
    }

    //递归
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l2.next,l1);
            return l2;
        }
    }
}

