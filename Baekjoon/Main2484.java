import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2484 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int maxPrice = -1;
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			int[] dice = new int[7];
			int maxSameCount = -1; 
			int maxSameNumber = -1;
			int maxNumber = -1;
			for(int j = 0; j < line.length; j++) {
				int n = Integer.valueOf(line[j]);
				dice[n]++;
				if(maxSameCount <= dice[n]) {
					maxSameCount = dice[n];
					maxSameNumber = n;
				}
				maxNumber = Math.max(maxNumber, n);
			}
			
			if(maxSameCount == 4) {
				int price = 50000 + maxSameNumber * 5000;
				maxPrice = Math.max(maxPrice, price);
			}
			else if(maxSameCount == 3) {
				int price = 10000 + maxSameNumber * 1000;
				maxPrice = Math.max(maxPrice, price);
			}
			else if(maxSameCount == 2) {
				ArrayList<Integer> numbers = new ArrayList<>();
				for(int k = 1; k < dice.length; k++) {
					if(dice[k] == 2) {
						numbers.add(k);
					}
				}
				
				if(numbers.size() == 1) {
					int price = 1000 + numbers.get(0) * 100;
					maxPrice = Math.max(maxPrice, price);
				}
				else if(numbers.size() == 2) {
					int price = 2000 + numbers.get(0) * 500 + numbers.get(1) * 500;
					maxPrice = Math.max(maxPrice, price);
				}
			}
			else if(maxSameCount == 1) {
				int price = maxNumber * 100;
				maxPrice = Math.max(maxPrice, price);
			}
		}
		System.out.println(maxPrice);
	}

}
