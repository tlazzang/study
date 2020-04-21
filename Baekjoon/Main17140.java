import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main17140 {
	public static int r, c, k;
	public static int maxRow = 3;
	public static int maxCol = 3;
	public static ArrayList<ArrayList<Integer>> rowList = new ArrayList<>();
	public static ArrayList<ArrayList<Integer>> colList = new ArrayList<>();
	public static HashMap<Integer, Integer> map = new HashMap<>();
	public static int[][] arr;

	public static int solution() {
		int answer = 0;
		while(true) {
			if(answer > 100) return -1;
			if(rangeCheck(r-1, c-1) && arr[r - 1][c - 1] == k) return answer;
			
			if(maxRow >= maxCol) {
				R();
			}else {
				C();
			}
			answer++;
		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < arr.length && col >= 0 && col < arr[0].length;
	}
	
	public static void R() {
		rowList = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			if(i >= 100) break;
			ArrayList<Integer> row = new ArrayList<>();
			map = new HashMap<>();
			Set<Integer> set = new HashSet<>();
			for(int j = 0; j < arr[0].length; j++) {
				if(j >= 100) break;
				if(arr[i][j] == 0) continue;
				if(map.get(arr[i][j]) == null) {
					map.put(arr[i][j], 1);
				}else {
					map.put(arr[i][j], map.get(arr[i][j]) + 1);
				}
				set.add(arr[i][j]);
			}
			
			ArrayList<Integer> tmp = new ArrayList<>(set);
			Collections.sort(tmp, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					if(map.get(o1) == map.get(o2)) {
						return o1.compareTo(o2);
					}else {
						return map.get(o1).compareTo(map.get(o2));
					}
				}
			});
			for(int n : tmp) {
				if(row.size() >= 100) {
					break;
				}
				row.add(n);
				row.add(map.get(n));
			}
			maxCol = Math.max(maxCol, row.size());
			rowList.add(row);
		}
		
		arr = new int[maxRow][maxCol];
		for(int i = 0; i < maxRow; i++) {
			for(int j = 0; j < maxCol; j++) {
				if(rowList.get(i).size() > j) {
					arr[i][j] = rowList.get(i).get(j);
				}else {
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static void C() {
		colList = new ArrayList<>();
		for(int j = 0; j < arr[0].length; j++) {
			if(j >= 100 ) break;
			ArrayList<Integer> col = new ArrayList<>();
			map = new HashMap<>();
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i < arr.length; i++) {
				if(i >= 100) break;
				if(arr[i][j] == 0) continue;
				if(map.get(arr[i][j]) == null) {
					map.put(arr[i][j], 1);
				}else {
					map.put(arr[i][j], map.get(arr[i][j]) + 1);
				}
				set.add(arr[i][j]);
			}
			
			ArrayList<Integer> tmp = new ArrayList<>(set);
			Collections.sort(tmp, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					if(map.get(o1) == map.get(o2)) {
						return o1.compareTo(o2);
					}else {
						return map.get(o1).compareTo(map.get(o2));
					}
				}
			});
			for(int n : tmp) {
				if(col.size() >= 100) {
					break;
				}
				col.add(n);
				col.add(map.get(n));
			}
			maxRow = Math.max(maxRow, col.size());
			colList.add(col);
		}
		
		arr = new int[maxRow][maxCol];
		for(int j = 0; j < maxCol; j++) {
			for(int i = 0; i < maxRow; i++) {
				if(colList.get(j).size() > i) {
					arr[i][j] = colList.get(j).get(i);
				}else {
					arr[i][j] = 0;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		r = Integer.valueOf(split[0]);
		c = Integer.valueOf(split[1]);
		k = Integer.valueOf(split[2]);
		arr = new int[3][3];
		for(int i = 0; i < arr.length; i++) {
			split = br.readLine().split(" ");
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(solution());
	}

}
