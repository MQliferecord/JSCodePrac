/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */



public int[][] merge(int[][] intervals) {
    /**
    对起点和终点分别进行排序，将起点和终点一一对应形成一个数组。
    如果没有overlap,返回当前起点和终点
    如果有overlap,判断以下条件
    找出最小的起点
    如果当前终点大于下一个数组的起点的时候，比较当前终点和下一个终点的大小，取为right
    返回满足要求的区间[[left,right]]
     */
    int num = intervals.length;
    int[][] ans = new int[num][2];
    int count = 0;
    Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});

    int le = intervals[0][0];
    int ri = intervals[0][1];

    for(int i = 0;i<num;i++){
        if(intervals[i][0]<=ri){
            //重叠
            ri = Math.max(ri,intervals[i][1]);
        }else{
            //不存在重叠
            int[] tmp = new int[2];
            tmp[0] = le;
            tmp[1] = ri;
            ans[count++] = tmp;
            le = intervals[i][0];
            ri = intervals[i][1];
        }
    }
    int[] tmp = new int[2];
    tmp[0] = le;
    tmp[1] = ri;
    ans[count++] = tmp;
    return Arrays.copyOf(ans,count);
}