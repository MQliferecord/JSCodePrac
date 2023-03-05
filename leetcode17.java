/**
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：
输入：digits = ""
输出：[]
示例 3：
输入：digits = "2"
输出：["a","b","c"]
*/


class Solution{
    public List<String> Result(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        String[] tmp = new String[digits.length()];
        for(int i = 0;i<digits.length();i++){
            tmp[i] = map.get(digits.charAt(i));
        }
        List<String> ans = new LinkedList<>();
        if(digits.length() == 0){
            return ans;
        }
        dfs(ans,tmp,tmp.length,"");
        return ans;
    }
    public void dfs(List<String> ans,String[] tmp,int target,String s){
        if(target == 0){
            ans.add(new String(s));
            return;
        }
        for(int i =0;i<tmp[tmp.length-target].length();i++){
            dfs(ans,tmp,target-1,s+tmp[tmp.length-target].charAt(i));
        }
    }
}