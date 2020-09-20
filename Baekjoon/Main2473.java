import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2473 {
	
	public static void solution(long[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		long min = Long.MAX_VALUE;
		long answer1 = 0;
		long answer2 = 0;
		long answer3 = 0;
		
		for(int i = 0; i < n - 2; i++) {
			int l = i + 1;
			int r = n - 1;
			while(l < r) {
				long sum = arr[i] + arr[l] + arr[r];
				if(Math.abs(sum) < min) {
					min = Math.abs(sum);
					answer1 = arr[i];
					answer2 = arr[l];
					answer3 = arr[r];
				}
				if(sum < 0) {
					l++;
				}else {
					r--;
				}
			}
		}
		
		System.out.println(answer1 + " " + answer2 + " " + answer3);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int a = 1000000000;
		int b = 1000000000;
		int c = 1000000000;
		long s = a + b;
		s += c;
		System.out.println(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		long[] arr = new long[N];
		String[] split = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Long.valueOf(split[i]);
		}
		solution(arr);
		

	}

}
