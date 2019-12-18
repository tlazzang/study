
public class Problem64 {
    static int m;
    static int n;
    public static int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int up = i - 1 >= 0 ? grid[i-1][j] : Integer.MAX_VALUE;
                int down = j - 1 >= 0 ? grid[i][j-1] : Integer.MAX_VALUE;
                grid[i][j] = grid[i][j] + Math.min(up, down);
            }
        }
        return grid[m-1][n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1,}};
		System.out.println(minPathSum(grid));
	}
}
