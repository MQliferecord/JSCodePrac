class ListNode{
    constructor(val,next){
        this.val = (this.val===undefined? 0:val)
        this.next = (this.next === undefined? null:next)
    }
    val(){
        return this.val
    }
    next(){
        return this.next
    }
}

const sum = function(l1,l2){
    let p = new ListNode()
    let ans = p
    let cur = 0
    while(l1&&l2){
        let tmp = l1.val+l2.val+cur
        cur = parseInt(tmp/10)
        tmpval = parseInt(tmp%10)
        p.next = new ListNode(tmpval)
        p = p.next
        l1 = l1.next
        l2 = l2.next
    }
    while(l1){
        let tmp = l1.val+cur
        cur = parseInt(tmp/10)
        tmpval = parseInt(tmp%10)
        p.next = new ListNode(tmpval)
        p = p.next
        l1 = l1.next
    }
    while(l2){
        let tmp = l2.val+cur
        cur = parseInt(tmp/10)
        tmpval = parseInt(tmp%10)
        p.next = new ListNode(tmpval)
        p = p.next
        l2 = l2.next
    }
    if(cur == 1){
        p.next = new ListNode(cur)
        p = p.next
    }
    return ans.next
}