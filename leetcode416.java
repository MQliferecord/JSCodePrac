/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。
请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 */


class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length<2){
            return false;
        }
        int sum = 0;
        int maxVal = 0; 
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            maxVal = Math.max(maxVal,nums[i]);
        }
        if(sum%2 != 0||(maxVal>sum/2)){
            return false;
        }

        int target = sum/2;
        boolean[][] dp = new boolean[nums.length][target+1];
/**
其中dp[i][j]表示从数组的[0,i]下标范围内选取若干个正整数（可以是0个），是否存在一种方案使得被选取的正整数的和等于j,初始时候，dp中的所有元素都是false。
 */
        for(int i = 0;i<nums.length;i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i =1;i<nums.length;i++){
            for(int j = 0;j<=target;j++){
                if(nums[i]<=j){
                    /** 
                    包含选和不选的两种情况。
                    */
                    dp[i][j] = dp[i-1][j-nums[i]]||dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}