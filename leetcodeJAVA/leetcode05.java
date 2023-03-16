/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
*/

class Solution{
    public String Result(String s){
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for(int i = 0;i<s.length();i++){
            dp[i][i] = true;
        }
        char[] c = s.toCharArray();
        for(int L = 2;L<=s.length();L++){
            for(int i = 0;i<s.length();i++){
                int j = L+i-1;
                if(j>=s.length()){
                    continue;
                }
                if(c[i]!=c[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}