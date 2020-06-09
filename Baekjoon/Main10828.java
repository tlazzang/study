import java.util.Scanner;
import java.util.Stack;

public class Main10828 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N +1; i++) {
			String s = sc.nextLine();
			String[] command = s.split(" ");
			switch(command[0]) {
			case "push" :{
				stack.push(Integer.parseInt(command[1]));
				break;
			}
			case "top" :{
				System.out.println(stack.peek());
				break;
			}
			case "pop" :{
				if(!stack.empty()) {
				System.out.println(stack.pop());
				}
				else {
					System.out.println("-1");
				}
				break;
			}
			case "size" :{
				System.out.println(stack.size());
				break;
			}
			case "empty" :{
				if(stack.empty()) {
					System.out.println("1");
				}
				else {
					System.out.println("0");
				}
				break;
			}
			default :{
				break;
			}
			}
		}
	}
}

