/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
*/

public boolean exist(char[][] board, String word) {
    for(int i =0;i<board.length;i++){
        for(int j =0;j<board[0].length;j++){
            if(isExist(board,word,i,j,0)){
                return true;
            }
        }
    }
    return false;
}
public boolean isExist(char[][] board,String word,int i,int j,int index){
    if(index>=word.length()){
        return true;
    }
    if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(index)){
        return false;
    }
    board[i][j] += 256;
    boolean result = isExist(board,word,i-1,j,index+1)||isExist(board,word,i+1,j,index+1)||isExist(board,word,i,j-1,index+1)||isExist(board,word,i,j+1,index+1);
    board[i][j] -= 256;
    return result;
}