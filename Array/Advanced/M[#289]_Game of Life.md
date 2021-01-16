## 289. Game of Life
https://leetcode.com/problems/game-of-life/description/


1. O(N) extra space

```java
class Solution {
    int m,n;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1},{1,1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int lives = count(board,i,j);
                if(board[i][j] == 1 && lives < 2){
                    ans[i][j] = 0;
                }
                else if(board[i][j] == 1 && (lives == 2 || lives == 3) ){
                    ans[i][j] = 1;
                }
                else if(board[i][j] == 1 && lives > 3)ans[i][j] = 0;
                else if(board[i][j] == 0 && lives == 3) ans[i][j] = 1;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] = ans[i][j];
            }
        }
    }
    private int count(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >=0 && y >=0 && x < m && y < n && board[x][y] == 1){
                count+=1;
            }
        }
        return count;

    }
}
```

2. O(1) space

在原board上改变value，最后对2取余即可。

```java
class Solution {
    int[][] dirs ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int lives = 0;
                for(int[] dir : dirs){
                    if(dir[0]+i <0 || dir[0]+i>=board.length || dir[1]+j<0 || dir[1]+j>=board[0].length)continue;
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(board[x][y] == 1 || board[x][y] == 2)lives++;
                }
                if(board[i][j] == 0 && lives ==3) board[i][j] = 3; // dead to live
                if(board[i][j] == 1 && (lives<2 || lives>3))board[i][j] = 2; // live to dead
                if(board[i][j] == 1 && (lives==2 || lives ==3))board[i][j] = 1; //keep live
            }
        }
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j]%=2;
            }
        }
    }
}
```