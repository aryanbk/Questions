class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        
        
        for(int i=0; i<m; ++i){
            if(board[i][0]=='O')
                q.offer(new int[]{i, 0});
            if(board[i][n-1]=='O')
                q.offer(new int[]{i, n-1});
        }
        
        for(int i=0; i<n; ++i){
            if(board[0][i]=='O')
                q.offer(new int[]{0, i});
            if(board[m-1][i]=='O')
                q.offer(new int[]{m-1, i});
        }
        
        // BFS
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            q.poll();
            
            if(board[i][j] != 'O')
                continue;
            board[i][j] = 'Y';
            
            for(int[] d: dir){
                int x = i + d[0];
                int y = j + d[1];
                if(x>=0 && x<m && y>=0 && y<n && board[x][y] == 'O'){
                    q.offer(new int[]{x, y});
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }
}