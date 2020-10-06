import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem207 {
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] next = new ArrayList[numCourses];
        int[] inputDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
        	next[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites) {
        	inputDegree[pre[0]]++;
        	next[pre[1]].add(pre[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inputDegree.length; i++) {
        	if(inputDegree[i] == 0) {
        		queue.add(i);
        	}
        }
        
        int size = 0;
        while(!queue.isEmpty()) {
        	int now = queue.poll();
        	size++;
        	for(int n : next[now]) {
        		if(--inputDegree[n] == 0) {
        			queue.add(n);
        		}
        	}
        }
        
        return size == numCourses;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
