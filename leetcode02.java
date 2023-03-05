/**
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
*/
public class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
    
}

class Solution{
    public ListNode sum(ListNode l1,ListNode l2){
        ListNode p = new ListNode(0);
        ListNode ans = p;
        int cur = 0;
        while(l1!=null&&l2!=null){
            int tmp = l1.val+l2.val+cur;
            cur = tmp/10;
            int les = tmp%10;
            p.next = new ListNode(les);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int tmp = l1.val+cur;
            cur = tmp/10;
            int les = tmp%10;
            p.next = new ListNode(les);
            p = p.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int tmp = l2.val+cur;
            cur = tmp/10;
            int les = tmp%10;
            p.next = new ListNode(les);
            p = p.next;
            l2 = l2.next;
        }
        if(cur == 1){
            p.next = new ListNode(cur);
            p = p.next; 
        }
        return ans.next;
    }
}

