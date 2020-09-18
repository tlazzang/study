import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1789 {
	
	public static long solution(long S) {
		long answer = 0;
		long sum = 0;
		long idx = 0;
		while(sum <= S) {
			sum += ++idx;
		}
		return idx - 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.valueOf(br.readLine());
		System.out.println(solution(S));
	}

}
