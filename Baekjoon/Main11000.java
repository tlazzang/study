import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main11000 {
	
	public static class Class implements Comparable<Class>{
		int start;
		int end;
		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Class o) {
			// TODO Auto-generated method stub
			return this.start - o.start;
		}
	}
	
	public static class ClassRoom implements Comparable<ClassRoom>{
		int end;
		public ClassRoom(int end) {
			this.end = end;
		}
		@Override
		public int compareTo(ClassRoom o) {
			// TODO Auto-generated method stub
			return this.end - o.end;
		}
	}
	
	public static ArrayList<Class> classList = new ArrayList<>();
	public static PriorityQueue<ClassRoom> pq = new PriorityQueue<>();

	public static int solution() {
		int answer = 0;
		Collections.sort(classList);
		for(Class c : classList) {
			if(pq.isEmpty()) {
				answer++;
				pq.add(new ClassRoom(c.end));
			}else {
				if(pq.peek().end > c.start) {
					answer++;
					pq.add(new ClassRoom(c.end));
				}else {
					ClassRoom cr = pq.poll();
					cr.end = c.end;
					pq.add(cr);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		for(int i = 0 ; i < N; i++) {
			String[] split = br.readLine().split(" ");
			int start = Integer.valueOf(split[0]);
			int end = Integer.valueOf(split[1]);
			classList.add(new Class(start, end));
		}
		System.out.println(solution());
	}

}
