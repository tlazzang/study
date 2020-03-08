package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Notification {
	
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int result = 0;
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i = 0; i < expenditure.length; i++) {
    		if(queue.size() != d) {
    			queue.add(expenditure[i]);
    		}
    		else {
    			if(expenditure[i] >= getMedian(new ArrayList<>(queue)) * 2) {
    				result++;
    			}
				queue.poll();
				queue.add(expenditure[i]);
    		}
    	}
    	return result;
    }
    
    static double getMedian(List<Integer> list) {
    	double median = 0.0;
    	Collections.sort(list);
    	return (list.size() % 2 == 0) ? (list.get(list.size() / 2) + list.get((list.size() / 2) - 1)) / 2.0 : list.get(list.size() / 2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,3,3,6,7,8,9};
//		int[] arr = {1,2,3,4,5,6,8,9};
//		System.out.println(getMedian(Arrays.stream(arr).boxed().collect(Collectors.toList())));
		
	
		int[] exp = {1 ,2 ,3 ,4, 4};
		int d = 4;
//		int[] exp = {2, 3, 4, 2, 3, 6, 8, 4, 5};
//		int d = 5;
//		
		System.out.println(activityNotifications(exp, d));
	}

}
