package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main14888 {
	
	public static Stack<Character> choosenOperator = new Stack<>();
	public static int N;
	public static int[] nums;
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	public static int[] operator = new int[4];
	
	public static void perm(int[] operator, int picked) {
		if(picked == N - 1) {
			calculate();
			return;
		}
		for(int i = 0; i < operator.length; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				switch(i) {
					case 0:{
						choosenOperator.add('+');
						break;
					}
					case 1:{
						choosenOperator.add('-');
						break;
					}
					case 2:{
						choosenOperator.add('*');
						break;
					}
					case 3:{
						choosenOperator.add('/');
						break;
					}
				}
				perm(operator, picked + 1);
				choosenOperator.pop();
				operator[i]++;
			}
		}
	}
	
	public static void calculate() {
		int result = nums[0];
		for(int i = 1; i < nums.length; i++) {
			char c = choosenOperator.elementAt(i - 1);
			switch(c) {
				case '+':{
					result = result + nums[i];
					break;
				}
				case '-':{
					result = result - nums[i];
					break;
				}
				case '*':{
					result = result * nums[i];
					break;
				}
				case '/':{
					result = result / nums[i];
					break;
				}
			}
		}
		min = Math.min(min, result);
		max = Math.max(max, result);
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		nums = new int[N];
		String[] split = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.valueOf(split[i]);
		}
		split = br.readLine().split(" ");
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.valueOf(split[i]);
		}
		perm(operator, 0);
		System.out.println(max);
		System.out.println(min);
	}

}
