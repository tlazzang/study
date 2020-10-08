
public class Problem289 {
	
	public static int[] dr = {-1,1,0,0,-1,-1,1,1};
	public static int[] dc = {0,0,-1,1,-1,1,-1,1};
	
    public static void gameOfLife(int[][] board) {
        int[][] next = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		int numOfLiveNeighbors = 0;
    			for(int k = 0; k < 8; k++) {
    				int nextRow = i + dr[k];
    				int nextCol = j + dc[k];
    				if(rangeCheck(nextRow, nextCol, board) && board[nextRow][nextCol] == 1) {
    					numOfLiveNeighbors++;
    				}
    			}
        		if(board[i][j] == 0) {
        			if(numOfLiveNeighbors == 3) {
        				next[i][j] = 1;
        			}
        		}else if(board[i][j] == 1) {
        			if(numOfLiveNeighbors < 2) {
        				next[i][j] = 0;
        			}else if(numOfLiveNeighbors <= 3) {
        				next[i][j] = 1;
        			}else {
        				next[i][j] = 0;
        			}
        		}
        	}
        }
        
        for(int i = 0; i < next.length; i++) {
        	for(int j = 0; j < next[0].length; j++) {
        		System.out.print(next[i][j]+" ");
        	}
        	System.out.println();
        }
    }
    
    public static boolean rangeCheck(int row, int col, int[][] board) {
    	return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {
		                 {0,1,0},
		                 {0,0,1},
		                 {1,1,1},
		                 {0,0,0}};
		gameOfLife(board);
	}

}
