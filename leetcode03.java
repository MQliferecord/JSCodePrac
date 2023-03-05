/**
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/

class Solution{
    public int calcuLen(String s){
        if(s.length()<=1){
            return s.length();
        }
        int anslen = 1;
        int le = 0;
        int ri = le;
        Map<Character,Integer> map = new HashMap<>();
        while(ri<s.length()){
            if(map.containsKey(s.charAt(ri))&&map.get(s.charAt(ri))>=le){
                le = map.get(s.charAt(ri))+1;
            }
            map.put(s.charAt(ri),ri);
            anslen = Math.max(anslen,ri-le+1);
            ri++;
        }
        return anslen;  
    }
}