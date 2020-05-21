import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem621 {
	
	public static class Task{
		Character name;
		int lastUsed;
		public Task(Character name, int lastUsed) {
			this.name = name;
			this.lastUsed = lastUsed;
		}
	}
	
    public static int leastInterval(char[] tasks, int n) {
    	int interval = 0;
    	
    	HashMap<Character, Integer> map = new HashMap<>();
    	HashMap<Character, Integer> frequency = new HashMap<>();
    	
    	Character[] task = new Character[tasks.length];
    	for(int i = 0; i < task.length; i++) {
    		task[i] = Character.valueOf(tasks[i]);
    	}
    	
    	for(char c : task) {
    		if(frequency.containsKey(c)) {
    			frequency.put(c, frequency.get(c) + 1);
    		}else {
    			frequency.put(c, 1);
    		}
    	}
    	
    	PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return frequency.get(o2) - frequency.get(o1);
			}
    	});
    	
    	for(Character c : frequency.keySet()) {
    		pq.add(c);
    	}
    	
    	Queue<Task> cooling = new LinkedList<>();
    	
    	while(!pq.isEmpty() || !cooling.isEmpty()) { 
    		if(pq.isEmpty()) {
    			interval = cooling.peek().lastUsed + n + 1;
    		}
    		
    		while(!cooling.isEmpty() && interval > cooling.peek().lastUsed + n) {
    			pq.add(cooling.poll().name);
    		}
    		
    		Character t = pq.poll();
    		frequency.put(t, frequency.get(t) - 1);
    		if(frequency.get(t) != 0) {
    			cooling.add(new Task(t, interval));
    		}
    		interval++;
    	}
    	
        return interval;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(leastInterval(new char[] {'A','A', 'A','A','B','B','C','C','D','D'}, 2));
//		System.out.println(leastInterval(new char[] {'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'}, 2));
	}

}
