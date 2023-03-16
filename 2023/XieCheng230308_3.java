/**
 * 携程230307场开发岗位笔试卷题3：
 * ACM模式：
 * 
游游准备开车出游，她的车非常特殊，油越多则最高速度越快，即最高速度和油量是成正比的。
另外，行驶过程中油是不会消耗的。
已知游游的车初始的最高速度为vo,当游游花费了t时间加油时，车的最高 速度会变成v0+t* x. 
游游开车的总里程为y,假设游游始终以最高速度行驶(即忽略加速时间)，游游想知道，自己最少花费多少时间可以完成出游?
结果是一个浮点数，代表最终花费的总时间。如果你的答案和标准答案的相对误差不超过10e-6，则认为答案正确。
v x y都是输入的常数
输出最小时间
v大于0 小于10e9
x y大于1 小于 10e9
 */
import java.util.Scanner;

/**
 * Description:
 * date: 2023/03/08 上午 9:25
 * 解题思路是：
 * （1）求出解题的理想数学公式-经典 1/t+t = Ans-->其他的变量都是定值
 * （2）求极值，求导--> 得到变式 1-(1/t)^2 = 0 为极值点 于是可以求出数学的解析式
 * （3）最后注意一下 t == 0 的一些边界条件！
 *
 * @author Quan
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int v0 = in.nextInt(), x = in.nextInt(), y = in.nextInt();

        double ans =  2 * Math.sqrt(y / x) - (v0 / x * 1.0);
        System.out.println(ans);
    }
}

// 0 1 2
// 2.8284271247461903




