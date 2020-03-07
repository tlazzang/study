package HackerRank;

public class TwoDimensionArray {
	
	public static int solution(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(rangeCheck(i, j, arr.length, arr[0].length)) {
					max = Math.max(max, getHourglassSum(arr, i, j));
				}
			}
		}
		return max;
	}
	
	public static int getHourglassSum(int[][] arr ,int row, int col) {
		int sum = 0;
		for(int i = row; i < row + 3; i++) {
			for(int j = col - 1; j < col + 2; j++) {
				if(i == row + 1 && j == col - 1) continue;
				if(i == row + 1 && j == col + 1) continue;
				sum = sum + arr[i][j];
			}
		}
		return sum;
	}
	
	public static boolean rangeCheck(int row, int col, int rowLen, int colLen) {
		if(col - 1 >= 0 && col + 1 < colLen && row + 2 < rowLen) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = {
				{1, 1, 1, 0, 0, 0},
				{0, 1, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{0, 0, 2, 4, 4, 0},
				{0, 0, 0, 2, 0, 0},
				{0, 0, 1, 2, 4, 0}};

		System.out.println(solution(arr));
	}

}
