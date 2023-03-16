/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
*/

class Solution{
    public void flatten(TreeNode root){
        if(root==null){
            return root;
        }
        List<Integer> lis = new LinkedList<>();
        preorder(root,lis);
        TreeNode tmp = root;
        for(int i =1;i<lis.size();i++){
            tmp.left = null;
            tmp.right = new TreeNode(lis.get(i));
            tmp = tmp.right;
        }
    }
    public void preorder(TreeNode root,List<Integer> lis){
        if(root==null){
            return;
        }
        lis.add(root.val);
        preorder(root.left,lis);
        preorder(root.right,lis);
    }
}