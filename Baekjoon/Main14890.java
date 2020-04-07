import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main14890 {
	
	public static class Pair{
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
		public boolean equals(Object obj){
			if(obj instanceof Pair){
				Pair p = (Pair)obj;
				return this.row == p.row && this.col == p.col;
			}
			return false;
		}
	}
	public static int solution(int[][] N, int L) {
		int answer = 0;
		boolean[][] isThereStep = new boolean[N.length][N.length];
		Queue<Pair> tmp = new LinkedList<>();
		System.out.println("------row-------");
		for(int i = 0; i < N.length; i++) {
			tmp.clear();
			boolean canGo = true;
			for(int j = 0; j < N.length - 1; j++) {
				if(N[i][j] > N[i][j+1]) {
					if(N[i][j] - N[i][j+1] != 1) {
						canGo = false;
						break;
					}
					int height = N[i][j+1];
					for(int k = j + 1; k <= j + L; k++) {
						if(!rangeCheck(i,k,N) || height != N[i][k] || isThereStep[i][k]) {
							canGo = false;
							break;
						}
						Pair p = new Pair(i, k);
						for(Pair pair : tmp) {
							if(pair.equals(p)) {
								canGo = false;
							}
						}
						tmp.add(p);
					}
				}else if(N[i][j] < N[i][j+1]) {
					if(N[i][j+1] - N[i][j] != 1) {
						canGo = false;
						break;
					}
					int height = N[i][j];
					for(int k = j; k >= j - L + 1; k--) {
						if(!rangeCheck(i,k,N) || height != N[i][k] || isThereStep[i][k]) {
							canGo = false;
							break;
						}
						Pair p = new Pair(i, k);
						for(Pair pair : tmp) {
							if(pair.equals(p)) {
								canGo = false;
							}
						}
						tmp.add(p);
					}
				}else {
					continue;
				}
			}
			if(canGo) {
				System.out.println(i);
				answer++;
				while(!tmp.isEmpty()) {
					Pair p = tmp.poll();
					isThereStep[p.row][p.col] = true;
				}
			}
		}
		
		isThereStep = new boolean[N.length][N.length];
		System.out.println("-----col-------");
		for(int i = 0; i < N.length; i++) {
			tmp.clear();
			boolean canGo = true;
			for(int j = 0; j < N.length - 1; j++) {
				if(N[j][i] > N[j+1][i]) {
					if(N[j][i] - N[j+1][i] != 1) {
						canGo = false;
						break;
					}
					int height = N[j+1][i];
					for(int k = j + 1; k <= j + L; k++) {
						if(!rangeCheck(k,i,N) || height != N[k][i] || isThereStep[k][i]) {
							canGo = false;
							break;
						}
				
						Pair p = new Pair(k, i);
						for(Pair pair : tmp) {
							if(pair.equals(p)) {
								canGo = false;
							}
						}
						tmp.add(p);
					}
				}else if(N[j][i] < N[j+1][i]) {
					if(N[j+1][i] - N[j][i] != 1) {
						canGo = false;
						break;
					}
					int height = N[j][i];
					for(int k = j; k >= j - L + 1; k--) {
						if(!rangeCheck(k,i,N) || height != N[k][i] || isThereStep[k][i]) {
							canGo = false;
							break;
						}
						
						Pair p = new Pair(k, i);
						for(Pair pair : tmp) {
							if(pair.equals(p)) {
								canGo = false;
							}
						}
						tmp.add(p);
					}
				}else {
					continue;
				}
			}
			if(canGo) {
				System.out.println(i);
				answer++;
				while(!tmp.isEmpty()) {
					Pair p = tmp.poll();
					isThereStep[p.row][p.col] = true;
				}
			}
		}

		return answer;
	}
	
	public static boolean rangeCheck(int row, int col, int[][] N) {
		return row >= 0 && row < N.length && col >= 0 && col < N[0].length;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line.split(" ")[0]);
		int L = Integer.parseInt(line.split(" ")[1]);
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.valueOf(split[j]);
			}
		}
//		solution(arr,L);
		System.out.println(solution(arr, L));
	}

}
