import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2493 {
	
	public static class Top{
		int idx;
		int height;
		public Top(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
	
	public static void solution(int[] top) {
		int[] answer = new int[top.length];
		Stack<Top> stack = new Stack<>();
		
		for(int i = 0; i < top.length; i++) {
			while(!stack.isEmpty() && stack.peek().height < top[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				answer[i] = 0;
			}else {
				answer[i] = stack.peek().idx;
			}
			
			stack.push(new Top(i+1, top[i]));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n : answer) {
			sb.append(n+" ");
		}
		
		System.out.println(sb.toString().trim());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] top = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < top.length; i++) {
			top[i] = Integer.valueOf(input[i]);
		}
		
		solution(top);
	}

}
