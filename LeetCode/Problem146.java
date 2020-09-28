import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class Problem146 {
	
	public static LinkedHashMap<Integer, Integer> lmap;
    public static HashMap<Integer, Task> map;
    public static PriorityQueue<Task> pq; 
    public static int capa;
    public static int nowTime;
    
    public static class Task implements Comparable<Task>{
        int key;
        int value;
        int inputTime;
        int usedCnt;
        
        public Task(int key, int value, int inputTime, int usedCnt){
            this.key = key;
            this.value = value;
            this.inputTime = inputTime;
            this.usedCnt = usedCnt;
        }
        
        public int compareTo(Task t){
            if(this.usedCnt != t.usedCnt){
                return this.usedCnt - t.usedCnt;
            }else{
                return this.inputTime - t.inputTime;
            }
        }
    }

    public static void LRUCache(int capacity) {
    	lmap = new LinkedHashMap<>();
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        nowTime = 0;
        capa = capacity;
    }
    
    public static int get(int key) {
    	if(lmap.containsKey(key)) {
    		lmap.put(key, lmap.remove(key));
    		return lmap.get(key);
    	}else {
    		return -1;
    	}
    }
    
    public static void put(int key, int value) {
        if(lmap.containsKey(key)){
        	lmap.remove(key);
        	lmap.put(key, value);
            return;
        }
        
        if(lmap.size() < capa){
        	lmap.put(key, value);
        }else{
        	for(int k : lmap.keySet()) {
        		lmap.remove(k);
        		break;
        	}
            lmap.put(key, value);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache(2);
		put(2, 1);
		put(2, 2);
		System.out.println(get(2));
		put(1, 1);
		put(4, 1);
		System.out.println(get(2));
	}

}
