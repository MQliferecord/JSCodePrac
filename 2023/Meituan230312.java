/**
 * 给出若干区间，求最多重叠的区间[L,R]重叠了几个子区间N，以及L-R的长度。
 * 比如输入：
 * [[1,3],[2,5],[4,7]]
 */

import java.util.Scanner;
public class Main {
    private int MaxLen = 1e5 + 10;
    public int from[MaxLen];
    public int to[MaxLen];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<x;i++){
            from[i] = in.nextInt();
        }
        for(int i = 0;i<x;i++){
            to[i] = in.nextInt();
        }
        for(int i = 0;i<x;i++){
            map.
        }
        System.out.println(str);
    }
}