import java.util.Arrays;

public class StoneBridge {
	
    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int l = 0, r = 6;
        Arrays.sort(rocks);
        
        if(rocks.length == n) {
        	return distance;
        }
        
        while(l <= r) {
        	int[] tmp = Arrays.copyOf(rocks, rocks.length);
        	int prev = 0;
        	int mid = (l + r) / 2;
        	int cnt = 0;
        	boolean flag = false;
        	for(int i = 0; i < tmp.length; i++) {
        		if(tmp[i] - prev < mid) {
        			tmp[i] = prev;
        			cnt++;
        		}else {
        			prev = tmp[i];
        		}
//        		if(tmp[i] - prev == mid) {
//        			flag = true;
//        			tmp[i] = prev;
//        			prev = tmp[i];
//        			
//        		}else if(tmp[i] - prev < mid){
//        			tmp[i] = prev;
//        			cnt++;
//        		}else {
//        			prev = tmp[i];
//        		}
        	}
        	
    		if(distance - prev == mid) {
    			flag = true;
    			prev = distance;
    			
    		}else if(distance - prev < mid){
    			cnt++;
    		}
        	
        	if(cnt <= n) {
//        		if(flag) {
        			answer = Math.max(answer, mid);
        			System.out.println(answer);
//        		}
        		l = mid + 1;
        	}else {
        		r = mid - 1;
        	}
        	
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int distance = 20;
		int[] rocks = {1, 5, 7 , 9, 15};
		int n = 2;
		
//		int distance = 10;
//		int n = 2;
//		int[] rocks = {1, 5, 8};
		System.out.println(solution(distance, rocks, n));
	}

	
}
