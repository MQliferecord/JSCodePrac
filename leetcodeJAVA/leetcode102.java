/**
 * 二叉树的层序遍历
 */

class Solution{
    public List<List<Integer>> levelTraversal(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();4
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i =0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                tmp.add(node.val);
            }
            ans.add(tmp);
        }
        return ans;
    }
}