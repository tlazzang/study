import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2075 {
	
	public static int N;
	public static int[][] arr;
	public static int[] top;
	
	public static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
	
//	public static int solution() {
//		Arrays.fill(top, N - 1);
//		int max = Integer.MIN_VALUE;
//		int maxIdx = Integer.MIN_VALUE;
//		for(int i = 0; i < searchIdx; i++) {
//			max = Integer.MIN_VALUE;
//			maxIdx = Integer.MIN_VALUE;
//			for(int j = 0; j < N; j++) {
//				if(top[j] >= 0 && arr[top[j]][j] > max) {
//					max = arr[top[j]][j];
//					maxIdx = j;
//				}
//			}
//			top[maxIdx]--;
//		}
//		return max;
//	}
	
	public static int solution() {
		int answer = 0;
		for(int i = N - 1; i >= 0; i--) {
			for(int j = 0; j < N; j++) {
				pq.offer(arr[i][j]);
			}
			answer = pq.poll();
		}
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		arr = new int[N][N];
		top = new int[N];
		for(int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(solution());
	}

}
