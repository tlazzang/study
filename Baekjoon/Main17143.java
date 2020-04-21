import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main17143 {
	public static int R, C, M;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int LEFT = 4;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int answer = 0;
	public static int[][] map;
	public static ArrayList<Shark> sharkList = new ArrayList<>();
	
	public static class Shark{
		int row;
		int col;
		int speed;
		int direction;
		int size;
		
		public Shark(int row, int col, int speed, int direction, int size) {
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}
	
	public static int solution() {
		int fisherCol = -1;
		while(fisherCol < C) {
			fisherCol++;
			grabShark(fisherCol);
			moveShark();
		}
		return answer;
	}
	
	public static void grabShark(int fisherCol) {
		Collections.sort(sharkList , new Comparator<Shark>() {
			@Override
			public int compare(Shark o1, Shark o2) {
				// TODO Auto-generated method stub
				return o1.row - o2.row;
			}
		});
		
		Iterator<Shark> it = sharkList.iterator();
		while(it.hasNext()) {
			Shark s = it.next();
			if(s.col == fisherCol) {
				answer += s.size;
				map[s.row][s.col] = 0;
				it.remove();
				return;
			}
		}
	}
	
	public static void moveShark() {
		ArrayList<Shark> sharkListAfterMove = new ArrayList<>();
		Iterator<Shark> it = sharkList.iterator();
		while(it.hasNext()) {
			Shark s = it.next();
			int row = s.row;
			int col = s.col;
			int cnt;
			if(s.speed == 0) {
				cnt = 0;
			}else if(s.direction == UP || s.direction == DOWN) {
				cnt = s.speed % ((R-1) * 2);
			}else {
				cnt = s.speed % ((C-1) * 2);
			}
			for(int i = 0; i < cnt; i++) {
				switch(s.direction) {
					case UP:{
						if(rangeCheck(row + dr[0], col + dc[0])){
							row = row + dr[0];
							col = col + dc[0];
						}else {
							s.direction = DOWN;
							if(rangeCheck(row + dr[1], col + dc[1])) {
								row = row + dr[1];
								col = col + dc[1];
							}
						}
						break;
					}
					case DOWN:{
						if(rangeCheck(row + dr[1], col + dc[1])){
							row = row + dr[1];
							col = col + dc[1];
						}else {
							s.direction = UP;
							if(rangeCheck(row + dr[0], col + dc[0])) {
								row = row + dr[0];
								col = col + dc[0];
							}
						}
						break;
					}
					case LEFT:{
						if(rangeCheck(row + dr[2], col + dc[2])){
							row = row + dr[2];
							col = col + dc[2];
						}else {
							s.direction = RIGHT;
							if(rangeCheck(row + dr[3], col + dc[3])) {
								row = row + dr[3];
								col = col + dc[3];
							}
						}
						break;
					}
					case RIGHT:{
						if(rangeCheck(row + dr[3], col + dc[3])){
							row = row + dr[3];
							col = col + dc[3];
						}
						else {
							s.direction = LEFT;
							if(rangeCheck(row + dr[2], col + dc[2])) {
								row = row + dr[2];
								col = col + dc[2];
							}
						}
						break;
					}
				
				}
			}
			
			sharkListAfterMove.add(new Shark(row, col, s.speed, s.direction, s.size));
			it.remove();
		}
		Collections.sort(sharkListAfterMove, new Comparator<Shark>() {

			@Override
			public int compare(Shark o1, Shark o2) {
				// TODO Auto-generated method stub
				if(o1.row == o2.row) {
					if(o1.col == o2.col) {
						return o2.size - o1.size;
					}else {
						return o1.col - o2.col;
					}
				}else {
					return o1.row - o2.row;
				}
			}
			
		});
		it = sharkListAfterMove.iterator();
		Shark prev = null;
		while(it.hasNext()) {
			Shark now = it.next();
			if(prev == null) {
				prev = now;
				continue;
			}
			if(now.row == prev.row && now.col == prev.col) {
				it.remove();
			}else {
				prev = now;
			}
		}
		sharkList.addAll(sharkListAfterMove);
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < R && col >= 0 && col < C;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		R = Integer.valueOf(split[0]);
		C = Integer.valueOf(split[1]);
		M = Integer.valueOf(split[2]);
		map = new int[R][C];
		for(int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int r = Integer.valueOf(split[0]);
			int c = Integer.valueOf(split[1]);
			int s = Integer.valueOf(split[2]);
			int d = Integer.valueOf(split[3]);
			int z = Integer.valueOf(split[4]);
			sharkList.add(new Shark(r-1,c-1,s,d,z));	
		}
		
		System.out.println(solution());
	}

}
