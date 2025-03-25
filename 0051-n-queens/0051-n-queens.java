class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row,'.');
        }
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>(); //r-c;
        Set<Integer> diagonal2 = new HashSet<>(); //r+c;
        backtrack(0,n,board,columns,diagonal1,diagonal2,result);
        return result;
    }
    public void backtrack(int row,int n,char[][] board,Set<Integer> columns,
                    Set<Integer> diagonal1,Set<Integer> diagonal2,List<List<String>> result){
                        if(row == n){
                            result.add(construct(board));
                            return;
                        }
                        for(int col=0;col<n;col++){
                            if(columns.contains(col) || diagonal1.contains(row-col) ||
                               diagonal2.contains(row+col)){
                                continue;
                            }
                            board[row][col] = 'Q';
                            columns.add(col);
                            diagonal1.add(row-col);
                            diagonal2.add(row+col);
                            backtrack(row+1,n,board,columns,diagonal1,diagonal2,result);
                            board[row][col] = '.';
                            columns.remove(col);
                            diagonal1.remove(row-col);
                            diagonal2.remove(row+col);
                        }
                    }
    private List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] row : board){
            result.add(new String(row));
        }
        return result;
    }
}