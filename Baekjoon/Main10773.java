import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
	
	public static Stack<Integer> stack = new Stack<>();
	public static int sum = 0;
	
	public static void solution(int n) {
		if(n != 0) {
			sum += stack.push(n);
		}else {
			sum -= stack.pop();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.valueOf(br.readLine());
		for(int i = 0; i < K; i++) {
			solution(Integer.valueOf(br.readLine()));
		}
		System.out.println(sum);
	}

}
