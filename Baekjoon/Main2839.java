import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2839 {
	
	public static int solution(int N) {
		int numOf5kg = N / 5;
		
		while(true) {
			if(numOf5kg < 0) return -1;
			
			if((N - (numOf5kg * 5)) % 3 == 0) {
				int numOf3kg = (N - (numOf5kg * 5)) / 3 ;
				return numOf5kg + numOf3kg;
			}else {
				numOf5kg--;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(Integer.valueOf(br.readLine())));
	}

}
