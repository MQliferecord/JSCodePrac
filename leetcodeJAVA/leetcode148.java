/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 
 */

class Solution {
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        int cnt = 0;
        //Map<Integer,ListNode> map = new HashMap<>();
        while(p!=null){
            /**
            if(map.containsKey(p.val)){
                
            }else{
                map.put(p.val,p);
                
            }*/
            p = p.next;
            cnt++;
        }
        ListNode q = head;
        int[] arr = new int[cnt];
        int count=0;
        while(q!=null){
            arr[count++] = q.val;
            q = q.next;
        }
        Arrays.sort(arr);
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        for(int i =0;i<arr.length;i++){
            //node.next = map.get(arr[i]);
            //node = node.next;
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        node.next = null;
        return newHead.next;
    }
}