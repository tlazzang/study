import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9935 {
	
	public static char[] arr = new char[1000000];
	public static char[] original = new char[1000000];
	public static int len = 0;
	public static int originalLen = 0;
	
	public static void solution(char[] trigger) {
		
		int idx = 0;
		for(int i = 0; i < originalLen; i++) {
			arr[idx++] = original[i];
			if(arr[idx - 1] == trigger[trigger.length - 1]) {
				if(idx - trigger.length < 0) {
					continue;
				}
				boolean flag = true;
				for(int j = idx - 1,  k = trigger.length - 1; j >= idx - trigger.length; j--, k--) {
					if(arr[j] != trigger[k]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					idx -= trigger.length;
				}
			}
		}
		
		if(idx == 0) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < idx; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] o = br.readLine().toCharArray();
		originalLen = o.length;
		for(int i = 0; i < o.length; i++) {
			original[i] = o[i];
		}
		char[] trigger = br.readLine().toCharArray();
		solution(trigger);
		
	}

}
