import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main16235 {
	
	public static class Tree{
		int age;
		public Tree(int age) {
			this.age = age;
		}
	}
	
	public static class Ground{
		int nutrition;
		ArrayList<Tree> treeList;
		public Ground() {
			nutrition = 5;
			treeList = new ArrayList<>();
		}
	}
	
	public static Ground[][] grounds;
	public static int[][] A;
	public static int N,M,K;
	public static int numOfAliveTree;
	public static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static int solution2() {
		for(int k = 0; k < K; k++) {
			
			//Spring, Summer
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					Ground ground = grounds[i][j];
					Collections.sort(ground.treeList, new Comparator<Tree>() {
						@Override
						public int compare(Tree o1, Tree o2) {
							// TODO Auto-generated method stub
							return o1.age - o2.age;
						}
					});
					Iterator<Tree> it = ground.treeList.iterator();
					int tmpNutrition = 0;
					while(it.hasNext()) {
						Tree tree = it.next();
						//Spring
						if(tree.age <= ground.nutrition) {
							ground.nutrition -= tree.age++;
						}else { 	
							tmpNutrition += tree.age / 2;
							numOfAliveTree--;
							it.remove(); //death of tree; 
						}

					}
					//Summer
					grounds[i][j].nutrition += tmpNutrition;
				}
			}
			
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					//Fall
					Ground ground = grounds[i][j];
					Iterator<Tree> it = ground.treeList.iterator();
					while(it.hasNext()) {
						Tree tree = it.next();
						if(tree.age % 5 == 0) {
							for(int l = 0; l < 8; l++) {
								int nextRow = i + dr[l];
								int nextCol = j + dc[l];
								if(rangeCheck(nextRow, nextCol)) {
									grounds[nextRow][nextCol].treeList.add(new Tree(1));
									numOfAliveTree++;
								}
							}
						}
					}
					grounds[i][j].nutrition += A[i][j];
				}
			}
		}
		return numOfAliveTree;
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 1 && row < N + 1 && col >= 1 && col < N + 1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		K = Integer.valueOf(split[2]);
		grounds = new Ground[N + 1][N + 1];
		A = new int[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				grounds[i][j] = new Ground();
			}
		}
		for(int i = 1; i < N + 1; i++) {
			split = br.readLine().split(" ");
			for(int j = 1; j < N + 1; j++){
				A[i][j] = Integer.valueOf(split[j - 1]);
			}
		}
		
		for(int i = 0; i < M ; i++) {
			split = br.readLine().split(" ");
			int row = Integer.valueOf(split[0]);
			int col = Integer.valueOf(split[1]);
			int age = Integer.valueOf(split[2]);
			numOfAliveTree++;
			grounds[row][col].treeList.add(new Tree(age));
		}
		System.out.println(solution2());
	}

}
