package KakaoBlidn2018;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	
	  public static int solution(int cacheSize, String[] cities) {
	      int answer = 0;
	      if(cacheSize == 0) return 5 * cities.length;
	      
	      for(int i = 0; i < cities.length; i++) {
	    	  cities[i] = cities[i].toLowerCase();
	      }
	      
	      Queue<String> queue = new LinkedList<>();
	      
	      for(int i = 0; i < cacheSize; i++) {
	    	  if(i < cities.length) {
		    	  Iterator<String> it = queue.iterator();
		    	  boolean isCacheHit = false;
		    	  
		    	  if(queue.isEmpty()) {
		    		  queue.add(cities[i]);
		    		  answer += 5;
		    		  continue;
		    	  }
		    	  
		    	  while(it.hasNext()) {
		    		  String s = it.next();
			    	  if(s.equals(cities[i])) {
			    		  answer += 1;
			    		  it.remove();
			    		  queue.add(cities[i]);
			    		  isCacheHit = true;
			    		  break;
			    	  }
		    	  }
		    	  if(!isCacheHit) {
		    		  answer += 5;
		    		  queue.add(cities[i]);
		    	  }
	    	  }
	      }
	      
	      for(int i = cacheSize; i < cities.length; i++) {
	    	  Iterator<String> it = queue.iterator();
	    	  boolean isCacheHit = false;
	    	  while(it.hasNext()) {
	    		  String s = it.next();
		    	  if(s.equals(cities[i])) {
		    		  answer += 1;
		    		  it.remove();
		    		  queue.add(cities[i]);
		    		  isCacheHit = true;
		    		  break;
		    	  }
	    	  }
	    	  if(!isCacheHit) {
	    		  answer += 5;
	    		  if(queue.size() == cacheSize) {
	    			  queue.poll();
	    		  }
	    		  queue.add(cities[i]);
	    	  }
	      }
	      
	      return answer;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] s = {};
//		String[] s =  {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		String[] s = {"jeju", "jeju", "jeju", "pangyo", "jeju"};
		int size = 3;
		System.out.println(solution(size, s));
	}

}
