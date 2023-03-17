/**
 * 题目要求输入一个x,输出一个字符串，这个字符串只能由"r"/"e"/"d"三个字母组成
 * 并且这个字符串的回文子串数量等于x
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String str = "";
        int num = Math.min(x,100000);
        int[] ans = new int[num];
        for(int i = 0;i<num;i++){
            ans[i] = i*(i+1)/2;
        }
        for(int i =1;i<ans.length;i++){
            if(ans[i]>=x){
                int tmp = ans[i-1];
                while(tmp>0){
                    str += "r";
                    tmp--;
                }
                int cnt = ans[i]-ans[i-1];
                while(cnt>0){
                    if(cnt%3==1) {
                        str += "e";
                    }else if(cnt%3==2){
                        str+="d";
                    }
                    cnt--;
                }
                break;
            }
        }
        System.out.println(str);
    }
}