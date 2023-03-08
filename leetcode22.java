/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs(ans,n,n,"");
        return ans;
    }
    public void dfs(List<String> ans,int le,int ri,String tmp){
        if(le == 0&&ri==0){
            ans.add(new String(tmp));
            return;
        }
        if(le == 0){
            dfs(ans,le,ri-1,tmp+")");
            return;
        }
        if(le>ri){
            return;
        }
        dfs(ans,le-1,ri,tmp+"(");
        dfs(ans,le,ri-1,tmp+")");
    }
}