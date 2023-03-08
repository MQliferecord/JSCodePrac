/**
 * 给你一个整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
示例 1：
输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：
输入：nums = [1], target = 1
输出：1
 */

 /**
  * 回溯
  */
class Solution {
    public int cnt = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return cnt;
    }
    /**
    target -- 目标值
    totalNum -- 当前总数
    count -- 已经加的nums数
     */
    public void dfs(int[] nums,int target,int totalNum,int count){
        if(count == nums.length && totalNum==target){
            cnt++;
            return;
        }
        if(count == nums.length && totalNum!=target){
            return;
        }
        dfs(nums,target,totalNum+nums[count],count+1);
        dfs(nums,target,totalNum-nums[count],count+1);
    }
}

/**
 * 动态规划
 */

 class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //1.初始化方程 dp-表示个数 
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
        }
        //target可能为负数
        if(Math.abs(sum)<Math.abs(target)){
            return 0;
        }
        //target的范围是 [-sum,sum],再加上中间的 0
        int[][] dp = new int[nums.length][(2*sum)+1];
        //2.初始化数组
        //首先当只取第一个数的时候，只有 +nums[0] 和 -nums[0] 两种情况 
        //+sum因为数组只能取正数，所以把范围调整到 -sum,+sum
        if(nums[0]==0){
            dp[0][sum] = 2;
        }else{
            dp[0][sum+nums[0]] = 1;
            dp[0][sum-nums[0]] = 1;
        }
        //3.状态转移方程
        for(int i =1;i<nums.length;i++){
            for(int j = -sum;j<=sum;j++){
                if(j>sum-nums[i]){
                    //不存在j+nums[i]的情况
                    dp[i][j+sum] = dp[i-1][j-nums[i]+sum]+0;
                }else if(j<-sum+nums[i]){
                    //不存在j-nums[i]的情况
                    dp[i][j+sum] = dp[i-1][j+nums[i]+sum]+0;
                }else{
                    dp[i][j+sum] = dp[i-1][j+nums[i]+sum]+dp[i-1][j-nums[i]+sum];
                }
            }
        }
        return dp[nums.length-1][target+sum];
    }
}