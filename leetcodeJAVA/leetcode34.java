/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：
输入：nums = [], target = 0
输出：[-1,-1]
 */
public int[] searchRange(int[] nums, int target) {
    int[] ans = new int[2];
    int le = 0;
    int ri = nums.length-1;
    int tarNum = -1;
    while(le<=ri){
        int mid = (ri-le)/2+le;
        if(nums[mid] == target){
            tarNum = mid;
            break;
        }else if(nums[mid]>target){
            while(mid>0){
                if(nums[mid]!=nums[mid-1]){
                    break;
                }
                mid--;
            }
            ri = mid-1;
        }else{
            //nums[mid]<target
            while(mid<nums.length-1){
                if(nums[mid] != nums[mid+1]){
                    break;
                }
                mid++;
            }
            le = mid+1;
        }
    }
    if(tarNum == -1){
        ans[0] = -1;
        ans[1] = -1;
        return ans;
    }
    le = tarNum-1;
    ri = tarNum+1;
    while(le>=0){
        if(nums[le] != target){
            break;
        }
        le--;
    }
    while(ri<=nums.length-1){
        if(nums[ri] != target){
            break;
        }
        ri++;
    }
    ans[0] = le+1;
    ans[1] = ri-1;
    return ans;
}