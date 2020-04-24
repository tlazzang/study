package KakaoWinterInternship;

import java.util.Stack;

public class PickDoll {
	
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stack = new Stack[board[0].length];
        Stack<Integer> bucket = new Stack<>();
        for(int j = 0; j < board[0].length; j++) {
        	stack[j] = new Stack<>();
        	for(int i = board.length - 1; i >= 0; i--) {
        		if(board[i][j] == 0) break;
        		stack[j].push(board[i][j]);
        	}
        }
        for(int i = 0; i < moves.length; i++) {
        	if(stack[moves[i] - 1].isEmpty()) continue;
        	int picked = stack[moves[i] - 1].pop();
        	if(!bucket.isEmpty() && bucket.peek() == picked) {
        		bucket.pop();
        		answer += 2;
        	}else {
        		bucket.push(picked);
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}

}
