
public class Problem79 {
	
	public static int[] dr = {-1,1,0,0};
	public static int[] dc = {0,0,-1,1};
	public static boolean[][] visited;
	
    public static boolean exist(char[][] board, String word) {
    	visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(board[i][j] == word.charAt(0)) {
        			if(dfs(i, j, board, word, 1)) {
        				return true;
        			}

        		}
        	}
        }
        return false;
    }
    
    public static boolean dfs(int row, int col, char[][] board, String word, int index) {
    	if(word.length() == index) {
    		return true;
    	}
//    	
//    	if (row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != word.charAt(index) || visited[row][col]) {
//    		  return false;
//    	}
              
    	visited[row][col] = true;
    	
//        boolean finalResult = dfs(row+1, col, board, word, index+1) ||
//        		dfs(row-1, col, board, word, index+1) ||
//        		dfs(row, col+1, board, word, index+1) ||
//        		dfs(row, col-1, board, word, index+1);
    	boolean finalResult = false;
    	for(int i = 0; i < 4; i++) {
    		int nextRow = row + dr[i];
    		int nextCol = col + dc[i];
    		if(rangeCheck(nextRow, nextCol) && board[nextRow][nextCol] == word.charAt(index)) {
    			if(!visited[nextRow][nextCol]) {
    				finalResult = finalResult || dfs(nextRow, nextCol, board, word, index + 1);
    			}
    		}
    	}
    	
    	visited[row][col] = false;
    	
    	return finalResult;
    }
    
    public static boolean rangeCheck(int row, int col) {
    	return row >= 0 && row < visited.length && col >= 0 && col < visited[0].length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board =
			{
					{'A','B','C','E'},
					{'S','F','C','S'},
					{'A','D','E','E'}
			};
		
//		char[][] board =
//			{
//					{'C','A','A'},
//					{'A','A','A'},
//					{'B','C','D'}
//			};
		System.out.println(exist(board, "SEE"));
	}

}
