
public class Problem1052 {
	
	public static final int GRUMPY = 1;
	public static final int NOT_GRUMPY = 0;
	
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int answer = 0;
        int sum = 0;
        
        for(int i = 0; i < customers.length; i++) {
        	if(grumpy[i] == NOT_GRUMPY) {
        		sum += customers[i];
        	}
        }
        
        for(int i = 0; i < X; i++) {
        	if(grumpy[i] == GRUMPY) {
        		sum += customers[i];
        	}
        }
        
        int l = 0;
        for(int r = X; r < customers.length; r++) {
        	
        	if(grumpy[l] == GRUMPY) {
        		sum -= customers[l];
        	}
        	
        	if(grumpy[r] == GRUMPY) {
        		sum += customers[r];
        	}
        	
        	l++;
        	answer = Math.max(answer, sum);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int X = 3;
		
		System.out.println(maxSatisfied(customers, grumpy, X));

	}

}
