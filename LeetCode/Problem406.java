import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Problem406 {
	
    public int[][] reconstructQueue(int[][] people) {
        int[][] answer = new int[people.length][2];
        boolean[] isConstructed = new boolean[people.length];
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<int[]> answerList = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(Integer.compare(o1[0], o2[0]) == 0) {
					return Integer.compare(o1[1], o2[1]);
				}
				else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
        });
        
        for(int i = 0; i < people.length; i++) {
        	int[] pair = new int[2];
        	pair[0] = people[i][0];
        	pair[1] = people[i][1];
        	list.add(pair);
        }
        while(answerList.size() < people.length) {
        	for(int i = 0; i < list.size(); i++) {
        		if(isConstructed[i]) continue;
        		int cnt = 0;
        		int h = list.get(i)[0];
        		int k = list.get(i)[1];
        		for(int j = 0; j < answerList.size(); j++) {
        			if(answerList.get(j)[0] >= h) cnt++;
        		}
        		if(cnt == k) {
        			answerList.add(list.get(i));
        			isConstructed[i] = true;
        			break;
        		}
        	}
        }
        for(int i = 0; i < answerList.size(); i++) {
        	int[] pair = answerList.get(i);
        	answer[i][0] = pair[0];
        	answer[i][1] = pair[1];
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem406 p = new Problem406();
		int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] answer = p.reconstructQueue(input);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i][0] + ", " + answer[i][1]);
		}
	}

}
