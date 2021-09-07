package com;
public class ListNode {
    private volatile static ListNode instance ;
//    public ListNode(){}
    public synchronized static ListNode getInstance(){
      if(instance == null){
        synchronized (ListNode.class){
          if(instance == null){
            instance = new ListNode();
          }

        }
      }
      return instance;
    }

    public int val;
    public ListNode next;

    @Override
    public String toString() {
        return "{" + val + ", next=" + next + '}';
    }

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}