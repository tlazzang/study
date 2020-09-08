
public class Problem1004 {
	
    public static int longestOnes(int[] A, int K) {
        int answer = 0;
        int cnt = 0;
        int l = 0, r = 0;
        
        while(r < A.length) {
        	if(A[r] == 0) {
        		if(cnt < K) {
        			cnt++;
        		}else {
        			while(true) {
        				if(A[l++] == 0) break;
        			}
        		}
        	}
        	answer = Math.max(answer, r - l + 1);
        	r++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 0;
		System.out.println(longestOnes(A, k));
	}

}
