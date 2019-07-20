import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1074 {
	int N;
	int r;
	int c;
	int result = 0;
	
	public Main1074(int N, int r, int c) {
		this.N = N;
		this.r = r;
		this.c = c;
	}
	
	public void solution(int x, int y, int size) {

		if(!((x <= r && r < x + size) && (y <= c && c < y + size))) {
			result = result + (size * size);
			return ;
		}
		if(x == r && y == c) {
			System.out.println(result);
			return ;
		}
		solution(x, y, size / 2);
		solution(x, y + size / 2 , size / 2);
		solution(x + size / 2, y, size / 2);
		solution(x + size / 2, y + size /2, size / 2);	
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.valueOf(line[0]);
		int r = Integer.valueOf(line[1]);
		int c = Integer.valueOf(line[2]);
		Main1074 m = new Main1074(N, r, c);
		int size = (int)(Math.pow(2, N));
		m.solution(0, 0, size);
	}

}
