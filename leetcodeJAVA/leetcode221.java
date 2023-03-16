/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        //动态规划
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLen = 0;
        //初始化dp
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(matrix[i][j] == '1'){
                    if(i==0||j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    }
                }
                maxLen = Math.max(dp[i][j],maxLen);
            }
        }
        return maxLen*maxLen;
    }
}