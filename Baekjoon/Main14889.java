package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main14889 {
	
	public static int[][] S;
	public static int N;
	public static int result = Integer.MAX_VALUE;
	public static boolean[] selected;
	public static ArrayList<Integer> startTeam = new ArrayList<>();
	public static ArrayList<Integer> linkTeam = new ArrayList<>();
	
	public static int solution() {
		splitTeam(0, 1);
		return result;
	}
	
	public static void splitTeam(int picked, int start) {
		if(picked == N/2) {
			for(int i = 0; i < selected.length; i++) {
				if(selected[i]) {
					startTeam.add(i + 1);
				}else {
					linkTeam.add(i + 1);
				}
			}
			calculateTeamAbility();
			startTeam.clear();
			linkTeam.clear();
			return;
		}
		for(int i = start; i <= N; i++) {
			selected[i - 1] = true;
			splitTeam(picked + 1, i + 1);
			selected[i - 1] = false;
		}
	}
	
	public static void calculateTeamAbility() {
		int sumOfStart = 0;
		int sumOfLink = 0;
		
		for(int i = 0; i < startTeam.size(); i++) {
			for(int j = 0; j < startTeam.size(); j++) {
				if(i == j) continue;
				sumOfStart = sumOfStart + S[startTeam.get(i) - 1][startTeam.get(j) - 1];
				sumOfLink = sumOfLink + S[linkTeam.get(i) - 1][linkTeam.get(j) - 1];
			}
		}
		
		result = Math.min(result, Math.abs(sumOfStart - sumOfLink));
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		S = new int[N][N];
		selected = new boolean[N];
		String[] split;
		for(int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for(int j = 0; j < split.length; j++) {
				S[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(solution());
	}

}
