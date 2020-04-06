import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14499 {

	public void solution(int[][] map, int[] move, int i, int j) {
		int[] dice = new int[6]; // 0 = 동, 1 = 서, 2 = 남, 3 = 북, 4 = 위, 5 = 아
		int[] dr = {0, 0, 0, -1, 1};
		int[] dc = {0, 1, -1, 0, 0};
		int nowRow = i;
		int nowCol = j;
		for(int k = 0; k < move.length; k++) {
			int[] tmp = new int[6];
			System.arraycopy(dice, 0, tmp, 0, dice.length);
			int nextRow = nowRow + dr[move[k]];
			int nextCol = nowCol + dc[move[k]];
			if(nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) continue;
			nowRow = nextRow;
			nowCol = nextCol;
			switch(move[k]) {
				case 1:{
					dice[0] = tmp[4];
					dice[1] = tmp[5];
					dice[2] = tmp[2];
					dice[3] = tmp[3];
					dice[4] = tmp[1];
					dice[5] = tmp[0];
					break;
				}
				case 2:{
					dice[0] = tmp[5];
					dice[1] = tmp[4];
					dice[2] = tmp[2];
					dice[3] = tmp[3];
					dice[4] = tmp[0];
					dice[5] = tmp[1];
					break;
				}
				case 4:{
					dice[0] = tmp[0];
					dice[1] = tmp[1];
					dice[2] = tmp[4];
					dice[3] = tmp[5];
					dice[4] = tmp[3];
					dice[5] = tmp[2];
					break;
				}
				case 3:{
					dice[0] = tmp[0];
					dice[1] = tmp[1];
					dice[2] = tmp[5];
					dice[3] = tmp[4];
					dice[4] = tmp[2];
					dice[5] = tmp[3];
					break;
				}
			}
			if(map[nowRow][nowCol] == 0) {
				map[nowRow][nowCol] = dice[5];
			}else {
				dice[5] = map[nowRow][nowCol];
				map[nowRow][nowCol] = 0;
			}
			System.out.println(dice[4]);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Main14499 m = new Main14499();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line.split(" ")[0]);
		int M = Integer.parseInt(line.split(" ")[1]);
		int x = Integer.parseInt(line.split(" ")[2]);
		int y = Integer.parseInt(line.split(" ")[3]);
		int K = Integer.parseInt(line.split(" ")[4]);
		int[][] map = new int[N][M];
		int[] move = new int[K];
		for(int i = 0; i < N; i++) {
			line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}
		line = br.readLine();
		for(int i = 0; i < K; i++) {
			move[i] = Integer.parseInt(line.split(" ")[i]);
		}
		m.solution(map, move, x, y);
	}

}
