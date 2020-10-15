import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2869 {
	
	public static int heightOfTree;
	public static int nowHeight;
	public static int day, night;
	
	public static int solution() {
		int answer;
		if((heightOfTree - day) % (day - night) == 0) {
			answer = ((heightOfTree - day) / (day - night)) + 1;
		}else {
			answer = ((heightOfTree - day) / (day - night)) + 2;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		day = Integer.valueOf(split[0]);
		night = Integer.valueOf(split[1]);
		heightOfTree = Integer.valueOf(split[2]);
		System.out.println(solution());
	}

}
