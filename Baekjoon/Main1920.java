import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1920 {
	
	public static boolean contains(int[] arr, int n) {
		boolean result = false;
		int l = 0;
		int r = arr.length - 1;
		while(l <= r) {
			int half = (l + r) / 2;
			if(n == arr[half]) return true;
			else if(n < arr[half]) r = half - 1;
			else l = half + 1;
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] arr = new int[N];
		String[] split = br.readLine().split(" ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(split[i]);
		}
		int M = Integer.valueOf(br.readLine());
		int[] toSearch = new int[M];
		split = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			toSearch[i] = Integer.valueOf(split[i]);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < M; i++) {
			if(contains(arr, toSearch[i])) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
//		int[] a = {4,1,5,2,3};
//		int n = 1;
//		System.out.println(contains(a, n));
	}

}
