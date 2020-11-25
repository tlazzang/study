import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main1620 {
	
	public static String[] name;
	public static HashMap<String, Integer> map;
	
	public static void solution(String question) {
		if(map.containsKey(question)) {
			System.out.println(map.get(question));
		}else {
			System.out.println(name[Integer.valueOf(question)]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int M = Integer.valueOf(split[1]);
		name = new String[N + 1];
		map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			name[i + 1] = br.readLine();
			map.put(name[i + 1], i + 1);
		}
		
		for(int i = 0; i < M; i++) {
			solution(br.readLine());
		}
	}

}
