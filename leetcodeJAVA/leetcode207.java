/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 
先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
示例 1：
输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
示例 2：
输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。



--------------！！！！关键就是判断有没有环！！！！------------------
这题目就不是人读的。
 * 
 */

class Solution{
    public boolean canFinish(int numCourses,int[][] prerequisites){
        //用来存储所有课程
        Map<Integer,Integer> clsMap = new HashMap<>();
        for(int i =0;i<numCourses;i++){
            clsMap.put(i,0);
        }
        //依赖关系，以来当前的课程的后续
        Map<Integer,List<Integer>> preMap = new HashMap<>();

        for(int i = 0;i<prerequisites.length;i++){
            //当前课程
            int cur = prerequisites[i][0];
            //需要修的先修课
            int pre = prerequisites[i][1];
            //表示cur需要的先修课，如果clsMap.get(cur) == 0那么就不需要先修课
            clsMap.put(cur,clsMap.get(cur)+1);
            if(!preMap.containsKey(pre)){
                preMap.put(pre,new ArrayList<>());
            }
            preMap.get(pre).add(cur);
        }

        //bfs
        Queue<Integer> queue = new ArrayDeque<>();
        //第一批，完全不需要先修课的课程放入queue中
        for(int i = 0;i<numCourses;i++){
            if(clsMap.get(i) == 0){
                queue.push(i);
            }
        }

        while(!queue.isEmpty()){
            int cls = queue.poll();
            //查看该课程是否有后续课程，如果有，这门课学完后，这些后续课减少要求
            if(!preMap.containsKey(cls)){
                continue;
            }
            List<Integer> tmp = preMap.get(cls);
            for(int i = 0;i<tmp.size();i++){
                clsMap.put(tmp.get(i),clsMap.get(tmp.get(i))-1);
                //-------------------判断有无环的关键代码----------------
                //因为有环，所以有环的点是永远无法没有先修课，进入到queue中
                if(clsMap.get(tmp.get(i)) == 0){
                    queue.push(tmp.get(i));
                }
            }
        }
        for(int i = 0;i<numCourses;i++){
            if(clsMap.get(i)!=0){
                return false;
            }
        }
        return true;
    }
}