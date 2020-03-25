package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13458 {
	
	public static int N;
	public static int[] room;
	public static int B, C;
	
	public static long solution() {
		long result = room.length;
		for(int i = 0; i < room.length; i++) {
			room[i] = room[i] - B;
//			if(room[i] > 0) {
				if(room[i] % C == 0) {
					result = result + room[i] / C;
				}else {
					result = (result + room[i] / C) + 1; 
				}
//			}
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		room = new int[N];
		String[] split = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			room[i] = Integer.valueOf(split[i]);
		}
		split = br.readLine().split(" ");
		B = Integer.valueOf(split[0]);
		C = Integer.valueOf(split[1]);
		System.out.println(solution());
	}

}
