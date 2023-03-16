/**
 * 二叉树的中序遍历
 */

 class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        inorder(ans,root);
        return ans;
    }
    public void inorder(List<Integer> ans,TreeNode root){
        if(root == null){
            return;
        }
        inorder(ans,root.left);
        ans.add(root.val);
        inorder(ans,root.right);
    }
 }