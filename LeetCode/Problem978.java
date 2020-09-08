
public class Problem978 {
	
    public static int maxTurbulenceSize(int[] A) {
    	if(A.length == 1) return 1;
        int answer = 1;
        boolean flag = false;
        int l = 0, r = 0;
        while(r < A.length - 1) {
        	if(r - l == 0) {
        		flag = A[l] < A[l+1];
        		r++;
        		continue;
        	}
        	
        	if(A[r] == A[r+1]) {
        		r = r + 1;
        		l = r;
        		continue;
        	}
        	
        	if(A[r] < A[r+1] == flag) {
        		flag = A[r] < A[r+1];
        		l++;
        	}else {
        		flag = A[r] < A[r+1];
        		answer = Math.max(answer, r - l + 2);
        		r++;
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,4,2,10,7,8,8,1,9};
		System.out.println(maxTurbulenceSize(A));
	}

}
