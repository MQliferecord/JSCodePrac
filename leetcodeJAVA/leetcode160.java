/**
 * 给你两个单链表的头节点 headA 和 headB 
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map = new HashMap<>();
        while(headA!=null){
            map.put(headA,headA.val);
            headA = headA.next;
        }
        while(headB!=null){
            if(map.containsKey(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return headA;
    }
}