
public class Capet {
	

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int row = 3;
        int col = 3;
        int b = 8;
        int r = 1;
        if(brown == b && red == row * col - b){
            answer[0] = col;
            answer[1] = row;
            return answer;
        }
        
        while(true){
            col++;
            for(int j = col; j >= 3; j--){
                b = (col + j - 6) * 2 + 8;
                r = col * j - b;
                if(b == brown && r == red){
                    answer[0] = col;
                    answer[1] = j;
                    return answer;
                }
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = solution(24, 24);
		System.out.println(answer[0] + ", " + answer[1]);
	}

}
