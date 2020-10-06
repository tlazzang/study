import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Problem56 {
	
  private static class IntervalComparator implements Comparator<int[]> {
	    @Override
	    public int compare(int[] a, int[] b) {
	      return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
	    }
	  }
	
  public static int[][] merge(int[][] intervals) {
	    Collections.sort(Arrays.asList(intervals), new IntervalComparator());

	    LinkedList<int[]> merged = new LinkedList<>();
	    for (int[] interval : intervals) {
	      // if the list of merged intervals is empty or if the current
	      // interval does not overlap with the previous, simply append it.
	      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
	        merged.add(interval);
	      }
	      // otherwise, there is overlap, so we merge the current and previous
	      // intervals.
	      else {
	        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
	      }
	    }

	    return merged.toArray(new int[merged.size()][]);
	  }
	  
//    public static int[][] merge(int[][] intervals) {
//
//        int[][] answer = {};
//    	if(intervals.length == 0) {
//    		return answer;
//    	}
//        Integer[][] sortedArray = new Integer[intervals.length][2];
//        for(int i = 0; i < intervals.length; i++) {
//        	for(int j = 0; j < 2; j++) {
//        		sortedArray[i][j] = intervals[i][j];
//        	}
//        }
////        Integer[][] sortedArray = Arrays.stream(intervals).toArray(Integer[][]::new);
//        Arrays.sort(sortedArray, (arr1, arr2) -> arr1[0] - arr2[0]);
//        
//        ArrayList<Integer[]> list = new ArrayList<>();
//        for(Integer[] arr : sortedArray) {
//        	list.add(arr);
//        }
//        
//        int start = list.get(0)[0];
//        int end = list.get(0)[1];
//        
//        ArrayList<Integer[]> result = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++) {
//        	Integer[] arr = list.get(i);
//        	
//        	if((start <= arr[0] && end >= arr[0])) {
//        		end = Math.max(end, arr[1]);
//        	}else {
//        		Integer[] merged = new Integer[2];
//        		merged[0] = start;
//        		merged[1] = end;
//        		result.add(merged);
//        		start = arr[0];
//        		end = arr[1];
//        	}
//        }
//        
//		Integer[] merged = new Integer[2];
//		merged[0] = start;
//		merged[1] = end;
//        result.add(merged);
//        
//        
////        while(true) {
////        	boolean flag = false;
////        	for(int i = 0; i < list.size(); i++) {
////        		for(int j = 0; j < list.size(); j++) {
////        			if(i == j ) continue;
////        			Integer[] arr1 = list.get(i);
////        			Integer[] arr2 = list.get(j);
////        			if((arr1[0] <= arr2[0] && arr1[1] >= arr2[0]) || arr1[0] <= arr2[1] && arr1[1] >= arr2[1]) {
////        				flag = true;
////        				int start = Math.min(arr1[0], arr2[0]);
////        				int end = Math.max(arr1[1], arr2[1]);
////        				list.remove(arr1);
////        				list.remove(arr2);
////        				Integer[] mergedInterval = new Integer[2];
////        				mergedInterval[0] = start;
////        				mergedInterval[1] = end;
////        				list.add(mergedInterval);
////        				break;
////        			}
////        		}
////        		if(flag) break;
////        	}
////        	if(!flag) break;
////        }
//        
//        answer = new int[result.size()][2];
//        for(int i = 0; i < result.size(); i++) {
//        	answer[i][0] = result.get(i)[0];
//        	answer[i][1] = result.get(i)[1];
//        }
//        
//        return answer;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//		int[][] intervals = {{1,4},{5,7},{3,6}};
		int[][] intervals = {{2,3},{2,5},{2,4} ,{6,9}};
		int[][] result = merge(intervals);
		for(int[] arr : result) {
			System.out.print("["+arr[0]+", "+arr[1]+"], ");
		}
	}

}
