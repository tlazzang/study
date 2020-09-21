import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main15961 {
	
	public static int solution(int[] arr, int k, int c) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int l = 0, r = 0;
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		
		while(r < arr.length + k) {
			if(r - l < k) {
				if(map.containsKey(arr[r % arr.length])) {
					map.put(arr[r % arr.length], map.get(arr[r % arr.length]) + 1);
				}else {
					map.put(arr[r % arr.length], 1);
					cnt++;
				}
				
				if(map.containsKey(c)) {
					max = Math.max(max, cnt);
				}else {
					max = Math.max(max, cnt + 1);
				}
				r++;
			}else {
				if(map.get(arr[l]) == 1) {
					map.remove(arr[l]);
					cnt--;
				}else {
					map.put(arr[l], map.get(arr[l]) - 1);
				}
				l++;
			}
		}
		
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, d, k, c;
		String[] split = br.readLine().split(" ");
		n = Integer.valueOf(split[0]);
		d = Integer.valueOf(split[1]);
		k = Integer.valueOf(split[2]);
		c = Integer.valueOf(split[3]);
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		System.out.println(solution(arr, k, c));
	}

}
