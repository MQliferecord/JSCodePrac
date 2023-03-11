/**
迷宫寻路
给定一个包含非负整数的 M x N 迷宫，请找出一条从左上角到右下角的路径，使得路径上的数字总和最小。
每次只能向下或者向右移动一步。
时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 256M，其他语言512M
输入描述：
第一行包含两个整数M和N，以空格隔开，1≤N≤10，1≤N≤10。
接下来的M行中，每行包含N个数字 。
输出描述：
找出总和最小的路径，输出路径上的数字总和。
示例1
输入例子：
3 3
1 3 1
1 5 1
4 2 1
输出例子：
7
 */

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] arr = new int[M][N];
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                arr[i][j] = in.nextInt();
            }
        }
        int[][] dp = new int[M][N];
        dp[0][0] = arr[0][0];
        for(int i =1;i<M;i++){
            dp[i][0] = dp[i-1][0]+arr[i][0];
        }
        for(int j = 1;j<N;j++){
            dp[0][j] = dp[0][j-1]+arr[0][j];
        }
        for(int i =1;i<M;i++){
            for(int j =1;j<N;j++){
                dp[i][j] = Math.min(dp[i-1][j]+arr[i][j],dp[i][j-1]+arr[i][j]);
            }
        }
        System.out.println(dp[M-1][N-1]);
    }
}