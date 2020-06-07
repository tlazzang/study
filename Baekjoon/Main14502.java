package BFS;

public class Main14502 {
	
	boolean[][] visited = new boolean[2][2];
	int[][] map;
	int[][] tmpMap;
	
	public void selectWall(int[][] map, int row, int col, int cnt) {
		tmpMap[row][col] = 1;
		visited[row][col] = true;
		if(cnt == 3) {
			for(int i = 0; i < tmpMap.length; i++) {
				for(int j = 0; j < tmpMap.length; j++) {
					System.out.print(tmpMap[i][j] + " ");
				}
				System.out.println();
			}
			tmpMap[row][col] = 0;
			return;
		}
		for(int i = row; i < map.length; i++) {
			for(int j = col; j < map[0].length; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					selectWall(map, i, j, cnt+1);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {{0,0}, {0,0}};
		Main14502 m = new Main14502();
		m.map = map;
		m.tmpMap = new int[map.length][map.length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				m.selectWall(map, i, j, 1);
			}
		}
	}

}
