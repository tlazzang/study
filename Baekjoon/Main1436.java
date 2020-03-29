package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int cnt = 0;
		int i = 666;
		while(true) {
			if(String.valueOf(i).contains("666")) {
				cnt++;
				if(N == cnt) {
					System.out.println(i);
					return;
				}
			}
			i++;
		}
	}

}
