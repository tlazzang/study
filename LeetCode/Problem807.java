
public class Problem807 {
	
	public static int[] maxValueOfRow;
	public static int[] maxValueOfCol;
	
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
    	maxValueOfRow = new int[grid.length];
    	maxValueOfCol = new int[grid[0].length];
        int answer = 0;
        for(int i = 0; i < grid.length; i++) {
        	int max = Integer.MIN_VALUE;
        	for(int j = 0; j < grid[0].length; j++) {
        		max = Math.max(max, grid[i][j]);
        	}
        	maxValueOfRow[i] = max;
        }
        
        for(int j = 0; j < grid[0].length; j++) {
        	int max = Integer.MIN_VALUE;
        	for(int i = 0; i < grid.length; i++) {
        		max = Math.max(max, grid[i][j]);
        	}
        	maxValueOfCol[j] = max;
        }
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		int changeValue = Math.min(maxValueOfRow[i], maxValueOfCol[j]);
        		answer = answer + (changeValue - grid[i][j]);
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		System.out.println(maxIncreaseKeepingSkyline(grid));
	}

}
