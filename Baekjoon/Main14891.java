import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14891 {
	
	public static int[][] sawTooth;
	public static boolean[] visited;
	public static void rotateClockWise(int[] arr) {
		int last = arr[arr.length - 1];
		for(int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = last;
	}
	
	public static void rotateCounterClockWise(int[] arr) {
		int first = arr[0];
		for(int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = first;
	}
	
	public static void rotate(int[] arr, int idx, boolean isClockWise) {
		visited[idx] = true;
		
		if(idx - 1 >= 0 && arr[6] != sawTooth[idx-1][2] && !visited[idx - 1]) {
			rotate(sawTooth[idx-1], idx-1, !isClockWise);
		}
		if(idx + 1 < 4 && arr[2] != sawTooth[idx+1][6] && !visited[idx + 1]) {
			rotate(sawTooth[idx+1], idx+1, !isClockWise);
		}
		
		if(isClockWise) {
			rotateClockWise(arr);
		}else {
			rotateCounterClockWise(arr);
		}
	}
	
	public static int solution() {
		int answer = 0;
		for(int i = 0; i < 4; i++) {
			if(sawTooth[i][0] == 1) {
				answer = answer + (int)Math.pow(2, i);
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sawTooth = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String[] split = br.readLine().split("");
			for(int j = 0; j < split.length; j++) {
				sawTooth[i][j] = Integer.valueOf(split[j]);
			}
		}
		int N = Integer.valueOf(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			int idx = Integer.valueOf(split[0]) - 1;
			int direction = Integer.valueOf(split[1]);
			visited = new boolean[4];
			rotate(sawTooth[idx], idx, direction == 1);
		}
		System.out.println(solution());
	}

}
