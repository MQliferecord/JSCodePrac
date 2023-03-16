/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */

class Solution{
    public boolean isValidBST(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        int[] arr = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        for(int i =0;i<arr.length-1;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[i]>=arr[j]){
                    return false;
                }
            }
        }
        return true;
    }
    public void inorder(TreeNode node,List<Integer> ans){
        if(node==null){
            return;
        }
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);
    }
}