/**
 * 斐波那契数列但是试例中有个50，得到的结果超出了int能够表达的范围，必须使用long
 */

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Main main = new Main();
        System.out.println(main.Result(n));
    }
    public long Result(int n){
        if(n<2){
            return 1;
        }
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}