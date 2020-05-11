import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main18808 {
	
	public static int[][] noteBook;
	public static ArrayList<int[][]> stickerList = new ArrayList<>();
	public static int N, M;
	
	public static int solution() {
		System.out.println("solution");
		for(int[][] sticker : stickerList) {
			for(int c = 0; c < 4; c++) {
				if(attach(sticker)) break;
				sticker = getRotatedSticker(sticker);
			}
		}
		return getNumOfAttachedArea();
	}
	
	public static int getNumOfAttachedArea() {
		int result = 0;
		for(int i = 0; i < noteBook.length; i++) {
			for(int j = 0; j < noteBook[0].length; j++) {
				if(noteBook[i][j] == 1) {
					result++;
				}
			}
		}
		return result;
	}
	
	public static boolean attach(int[][] sticker) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				boolean flag = true;
				if(!rangeCheck(i + sticker.length - 1, j + sticker[0].length - 1)) continue;
				for(int k = i; k < i + sticker.length; k++) {
					for(int l = j; l < j + sticker[0].length; l++) {
						if(noteBook[k][l] == 1 && sticker[k-i][l-j] == 1) {
							flag = false;
							break;
						}
					}
				}
				if(flag) {
					for(int k = i; k < i + sticker.length; k++) {
						for(int l = j; l < j + sticker[0].length; l++) {
							if(sticker[k-i][l-j] == 1) {
								noteBook[k][l] = 1;
							}
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public static int[][] getRotatedSticker(int[][] sticker){
		int[][] rotatedSticker = new int[sticker[0].length][sticker.length];
		for(int i = 0; i < rotatedSticker.length; i++) {
			for(int j = 0; j < rotatedSticker[0].length; j++) {
				rotatedSticker[i][j] = sticker[(rotatedSticker[0].length-1) - j][i];
			}
		}
		return rotatedSticker;
	}
	
	public static boolean rangeCheck(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		int K = Integer.valueOf(split[2]);
		noteBook = new int[N][M];
		for(int i = 0; i < K; i++) {
			split = br.readLine().split(" ");
			int rowLength = Integer.valueOf(split[0]);
			int colLength = Integer.valueOf(split[1]);
			int[][] sticker = new int[rowLength][colLength];
			for(int k = 0; k < rowLength; k++) {
				split = br.readLine().split(" ");
				for(int l = 0; l < colLength; l++) {
					sticker[k][l] = Integer.valueOf(split[l]);
				}
			}
			stickerList.add(sticker);
		}
		System.out.println(solution());
	}

}
