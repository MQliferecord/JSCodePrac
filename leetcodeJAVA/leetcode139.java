/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 请你判断是否可以利用字典中出现的单词拼接出 s 。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */


class Solution {
    public boolean flag = false;
    public int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> ans = new HashSet<>();
        memo = new int[s.length()];
        for(int i = 0;i<wordDict.size();i++){
            if(!ans.contains(wordDict.get(i))){
                ans.add(wordDict.get(i));
            }
        }
        result(s,ans,0);
        return flag;
    }
    public void result(String s,Set<String> ans,int begin){
        if(memo[begin] == 0){
            for(int i = begin+1;i<=s.length();i++){
                if(ans.contains(s.substring(begin,i))){
                    int le = i;
                    if(le == s.length()){
                        flag = true;
                        return;
                    }
                    result(s,ans,le);
                }
            }
            memo[begin] = 1;
        }
        return;
    }
}
