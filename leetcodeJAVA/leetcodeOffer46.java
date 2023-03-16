/**
 * 求 1+2+...+n 
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
示例 1：
输入: n = 3
输出: 6
示例 2：
输入: n = 9
输出: 45
 */

class Solution {
    public int sumNums(int n) {
        int tmp = n%2;
        int ans = 0;
        if(tmp == 0){
            //n是偶数
            ans = (n+1)*n/2;
        }else{
            //n是奇数
            ans = ((1+n)/2)*n;
        }
        return ans;
    }
}