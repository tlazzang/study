import java.util.LinkedList;
import java.util.Queue;

public class Problem200 {
	
	public static class Pair{
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static boolean[][] visited;
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
    public int numIslands(char[][] grid) {
    	visited = new boolean[grid.length][grid[0].length];
        int answer = 0;
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(!visited[i][j] && grid[i][j] == '1') {
        			answer++;
        			bfs(new Pair(i,j) , grid);
        		}
        	}
        }
        return answer;
    }
    
    public static void bfs(Pair start, char[][] grid) {
    	Queue<Pair> queue = new LinkedList<>();
    	queue.add(start);
    	visited[start.row][start.col] = true;
    	while(!queue.isEmpty()) {
    		Pair now = queue.poll();
    		for(int i = 0; i < 4; i++) {
    			int nextRow = now.row + dr[i];
    			int nextCol = now.col + dc[i];
    			if(rangeCheck(nextRow, nextCol, grid) && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) {
    				visited[nextRow][nextCol] = true;
    				queue.add(new Pair(nextRow, nextCol));
    			}
    		}
    	}
    }
    
    public static boolean rangeCheck(int row, int col, char[][] board) {
    	return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
