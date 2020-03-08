package HackerRank;

import java.util.Arrays;

public class MarkAndToy {
	
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
    	int maxNumOfToy = 0;
    	int sum = 0;
    	Arrays.sort(prices);
    	int i = 0;
    	while(sum + prices[i] < k) {
    		sum = sum + prices[i];
    		maxNumOfToy++;
    		i++;
    	}
    	return maxNumOfToy;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {100,5,30,20,1,3};
		System.out.println(maximumToys(arr, 5));
	}

}
