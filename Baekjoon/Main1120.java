package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1120 {
	
	public static String A, B;

	public static int solution() {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < (B.length() - A.length()) + 1; i++) {
			int diff = 0;
			for(int j = 0; j < A.length(); j++) {
				if(A.charAt(j) != B.charAt(j + i)) {
					diff++;
				}
			}
			min = Math.min(min, diff);
		}
		return min;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		A = split[0];
		B = split[1];
		System.out.println(solution());
	}

}
