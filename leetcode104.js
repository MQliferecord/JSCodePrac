/**
 * 二叉树的层序遍历
 */

let levelTraversal = function(root){
    const ret = []
    if(!root){
        return ret;
    }
    let queue = []
    queue.push(root)
    while(queue.length){
        let n = queue.length
        let tmp = []
        for(let i =0;i<n;i++){
            let node = queue.shift()
            if(node.left!=null){
                queue.push(node.left)
            }
            if(node.right!=null){
                queue.push(node.right)
            }
            tmp.push(node.val)
        }
        ret.push(tmp)
    }
    return ret
}