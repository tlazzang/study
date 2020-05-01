package KakaoBlind2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PillarAndBo {
	
	public static boolean[][] pillar;
	public static boolean[][] bo;
	public static int N;
	
    public static int[][] solution(int n, int[][] build_frame) {
    	N = n;
    	pillar = new boolean[n+3][n+3];
    	bo = new boolean[n+3][n+3];
    	
    	ArrayList<int[]> list = new ArrayList<>();
    	
    	for(int[] arr : build_frame) {
    		int col = arr[0] + 1;
    		int row = arr[1] + 1;
    		int a = arr[2];
    		int b = arr[3];
    		
    		if(a == 0) { //기둥.
    			if(b == 1) { //설치.
        			if(row == 1 || bo[row][col] || bo[row][col-1] || pillar[row-1][col]) {
        				pillar[row][col] = true;
        			}
    			}else { //삭제.
    				if(canRemovePillar(row, col)) {
    					pillar[row][col] = false;
    				}
    			}
    		}
    		
    		else { //보.
    			if(b == 1) { //설치.
        			if(pillar[row-1][col] || pillar[row-1][col+1] || (bo[row][col-1] && bo[row][col+1])) {
        				bo[row][col] = true;
        			}
    			}else { //삭제.
    				if(canRemoveBo(row, col)) {
    					bo[row][col] = false;
    				}
    			}
    		}
    	}
    	
    	for(int i = 1; i <= N + 1; i++) {
    		for(int j = 1; j <= N + 1; j++) {
    			if(pillar[i][j]) {
    				int[] tmp = new int[3];
    				tmp[0] = j - 1;
    				tmp[1] = i - 1;
    				tmp[2] = 0;
    				list.add(tmp);
    			}
    		}
    	}
    	
    	for(int i = 1; i <= N + 1; i++) {
    		for(int j = 1; j <= N + 1; j++) {
    			if(bo[i][j]) {
    				int[] tmp = new int[3];
    				tmp[0] = j - 1;
    				tmp[1] = i - 1;
    				tmp[2] = 1;
    				list.add(tmp);
    			}
    		}
    	}
    	
    	Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}else {
					if(o1[1] != o2[1]) {
						return o1[1] - o2[1];
					}else {
						return o1[2] - o2[2];
					}
				}
			}
    		
    	});
    	
        int[][] answer = new int[list.size()][3];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static boolean canRemovePillar(int row, int col) {
    	pillar[row][col] = false;
    	
    	for(int i = 1; i <= N + 1; i++) {
    		for(int j = 1; j <= N + 1; j++) {
    			if(pillar[i][j]) {
    				if(!(i == 1 || bo[i][j] || bo[i][j-1] || pillar[i-1][j])) {
        				pillar[row][col] = true;
        				return false;
    				}
    			}
    		}
    	}
    	
    	for(int i = 1; i <= N + 1; i++) {
    		for(int j = 1; j <= N + 1; j++) {
    			if(bo[i][j]) {
    				if(!(pillar[i-1][j] || pillar[i-1][j+1] || (bo[i][j-1] && bo[i][j+1]))) {
        				pillar[row][col] = true;
        				return false;
        			}
    			}
    		}
    	}
    	
    	pillar[row][col] = true;
    	return true;
    }
    
    public static boolean canRemoveBo(int row, int col) {
    	bo[row][col] = false;
    	
    	for(int i = 1; i <= N + 1; i++) {
    		for(int j = 1; j <= N + 1; j++) {
    			if(bo[i][j]) {
    				if(!(pillar[i-1][j] || pillar[i-1][j+1] || (bo[i][j-1] && bo[i][j+1]))) {
        				bo[row][col] = true;
        				return false;
        			}
    			}
    		}
    	}
    	
    	for(int i = 1; i <= N + 1; i++) {
    		for(int j = 1; j <= N + 1; j++) {
    			if(pillar[i][j]) {
    				if(!(i == 1 || bo[i][j] || bo[i][j-1] || pillar[i-1][j])) {
        				bo[row][col] = true;
        				return false;
    				}
    			}
    		}
    	}
    	
    	bo[row][col] = true;
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
//		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] build_frame = {{1,0,0,1}, {0,1,1,1}, {0,1,1,0}};
		int[][] answer = solution(5, build_frame);
		
		for(int[] n : answer) {
			System.out.print(n[0] + " " + n[1] + " " + n[2]);
			System.out.println();
		}
		
	}

}
