import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main1516 {
	public static int N;
	public static ArrayList<Integer>[] parentList;
	public static int[] numOfChild;
	public static int[] minTime;
	public static int[] value;
	
	public static void solution() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < numOfChild.length; i++) {
			if(numOfChild[i] == 0) {
				queue.add(i);
				minTime[i] = value[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : parentList[now]) {
				numOfChild[next]--;
				minTime[next] = Math.max(minTime[next], minTime[now] + value[next]);
				if(numOfChild[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		for(int time : minTime) {
			System.out.println(time);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		parentList = new ArrayList[N];
		numOfChild = new int[N];
		minTime = new int[N];
		value = new int[N];
		for(int i = 0; i < parentList.length; i++) {
			parentList[i] = new ArrayList<>();
		}
		for(int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			int t = Integer.valueOf(split[0]);
			value[i] = t;
			for(int j = 1; j < split.length; j++) {
				int child = Integer.valueOf(split[j]);
				if(child == -1) break;
				parentList[child-1].add(i);
				numOfChild[i]++;
			}
		}
		
		solution();
		
	}

}
