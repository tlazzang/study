package KakaoWinterInternship;

public class AcrossBirdge {
	
	public static int answer = 0;
    public static int solution(int[] stones, int k) {
        int start = 0;
        int end = 10;
        binarySearch(start, (start + end) / 2, end, stones, k);
        return answer;
    }
    
    public static void binarySearch(int start, int mid, int end, int[] stones, int k) {
    	if(start == mid) {
    		answer = mid;
    		return;
    	}
        int[] tmp = copy(stones);
        for(int i = 0; i < tmp.length; i++) {
        	tmp[i] -= mid;
        }
        if(canAcross(tmp, k)) {
        	answer = Math.max(answer, mid + 1);
        	binarySearch(mid, (mid + end) / 2, end, stones, k);
        }else {
        	binarySearch(start, (start + mid) / 2, mid, stones, k);
        }
    }
    
    public static int[] copy(int[] arr) {
    	int[] copied = new int[arr.length];
    	for(int i = 0; i < copied.length; i++) {
    		copied[i] = arr[i];
    	}
    	return copied;
    }
    
    public static boolean canAcross(int[] arr, int k) {
    	int cnt = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] < 1) {
    			cnt++;
    		}
    		else {
    			if(cnt > k) return false;
    			cnt = 0;
    		}
    	}
    	if(cnt > k) return false;
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(solution(stones, k));
	}

}
