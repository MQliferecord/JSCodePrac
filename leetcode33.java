/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target 
如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：
输入：nums = [1], target = 0
输出：-1
 */

class Solution{
    public int search(int[] nums, int target) {
        int ans = searchResult(nums,0,nums.length-1,target);
        return ans;
    }
    public int searchResult(int[] nums,int le,int ri,int target){
        if(ri<le){
            return -1;
        }
        int mid = (ri-le)/2+le;
        if(nums[mid]>nums[ri]){
            //456 7 123 --- 234 5 671
            if(nums[mid]<target){
                //456 7 891  target==9
                return searchResult(nums,mid+1,ri,target);
            }else if(nums[mid] == target){
                //456 7 891  target==7
                return mid;
            }else{
                //nums[mid]>target
                //456 7 891  target==1 -- 456 7 891  target==5
                if(nums[le]>target||nums[le]<nums[ri]){
                    //456 7 891  target==1
                    return searchResult(nums,mid+1,ri,target);
                }else{
                    //456 7 891  target==5
                    return searchResult(nums,le,mid-1,target);
                }
            }
        }else if(nums[mid]<nums[ri]){
            //567 1 234和123 4 567
            if(nums[mid] == target){
                //567 1 234 target==1
                return mid;
            }else if(nums[mid]<target){
                //567 1 234 target==5 -- 567 1 234 target==3
                if(nums[le]>target||nums[le]<nums[ri]){
                    return searchResult(nums,mid+1,ri,target);
                }else{
                    return searchResult(nums,le,mid-1,target);
                }
            }else{
                //nums[mid]>target
                //51 2 34 target==5
                return searchResult(nums,le,mid-1,target);
            }
        }else{
            ////nums[mid]==nums[ri]
            if(nums[mid] == target){
                return mid;
            }
            return -1;
        }
    }
}