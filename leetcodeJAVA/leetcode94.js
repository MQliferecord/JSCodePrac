/**
 * 二叉树中序遍历
 * @param {*} root 
 * @returns 
 */

let inorderTraversal = function (root){
    const ret = []
    const inorder = (node,ret)=>{
        if(!root){
            return
        }
        inorder(node.left,ret);
        ret.push(root.val);
        inorder(node.right,ret);
    }
    inorder(root);
    return ret;
}