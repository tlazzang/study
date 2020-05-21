import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Traversal {
	
	public static void solve(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
		printPostOrder(preOrder, inOrder);
	}
	
	public static void printPostOrder(List<Integer> preOrder, List<Integer> inOrder) {
		if(preOrder.size() == 0) return;
		
		int root = preOrder.get(0);
		int rootIdx = inOrder.indexOf(root);
		
		printPostOrder(preOrder.subList(1, rootIdx + 1), inOrder.subList(0, rootIdx));
		printPostOrder(preOrder.subList(rootIdx + 1, preOrder.size()), inOrder.subList(rootIdx + 1, inOrder.size()));
		
		System.out.print(root + " ");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.valueOf(br.readLine());
			
			String[] split = br.readLine().split(" ");
			ArrayList<Integer> preOrder = new ArrayList<>();
			for(int j = 0; j < N; j++) {
				preOrder.add(Integer.valueOf(split[j]));
			}
			
			split = br.readLine().split(" ");
			ArrayList<Integer> inOrder = new ArrayList<>();
			for(int j = 0; j < N; j++) {
				inOrder.add(Integer.valueOf(split[j]));
			}
			
			solve(preOrder, inOrder);
		}
	}

}
