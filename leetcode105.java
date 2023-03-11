/**
 * 给定两个整数数组 preorder 和 inorder 
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
 */

class Solution{
    public Map<Integer,Integer> indexMap;
    public TreeNode BuildTree(int[] preorder,int[] inorder){
        int n = preorder.length;
        indexMap = new HashMap<>();
        for(int i = 0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode myBuildTree(int[] preorder,int[] inorder,int pl,int pr,int il,int ir){
        if(il>ir){
            return null;
        }
        int proot = pl;
        int iroot = indexMap.get(preorder[proot]);
        TreeNode root = new TreeNode(preorder[proot]);
        int leLen = iroot-il;
        TreeNode leftNode = myBuildTree(preorder,inorder,pl+1,pl+leLen,il,iroot-1);
        TreeNode rightNode = myBuildTree(preorder,inorder,pl+leLen+1,pr,iroot+1,ir);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}