import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main1158 {
	
	public static void solution(int n, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			list.addLast(i + 1);
		}
		int nowIdx = 0;
		ArrayList<Integer> answerList = new ArrayList<>();
		while(!list.isEmpty()) {
			nowIdx = (nowIdx + k - 1) % list.size();
			answerList.add(list.remove(nowIdx));
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0; i < answerList.size() - 1; i++) {
			sb.append(answerList.get(i) + ", ");
		}
		sb.append(answerList.get(answerList.size() - 1));
		sb.append(">");
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int K = Integer.valueOf(split[1]);
		solution(N, K);
	}

}
