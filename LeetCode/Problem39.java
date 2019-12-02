import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Problem39 {
	
    List<List<Integer>> list;
    List<Integer> subset;
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        subset = new ArrayList<>();
        dfs(candidates, 0, target);
        Iterator<List<Integer>> it = set.iterator();
        while(it.hasNext()) {
        	list.add(it.next());
        }
        for(List<Integer> tmp : list) {
        	for(int i = 0; i < tmp.size(); i++) {
        		System.out.print(tmp.get(i) + ", ");
        	}
        	System.out.println();
        }
        return list;
    }
    
    public void dfs(int[] candidates, int sum, int target){
        if(sum >= target){
            if(sum == target){
            	List<Integer> tmp = new ArrayList<>();
            	tmp.addAll(subset);
            	Collections.sort(tmp);
            	set.add(tmp);
//                list.add(tmp);
            }
            return;
        }
        for(int i = 0; i < candidates.length; i++){
            subset.add(candidates[i]);
            dfs(candidates, sum + candidates[i], target);
            subset.remove(subset.size() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,6,7};
		int target = 7;
		Problem39 p = new Problem39();
		p.combinationSum(candidates, target);
	}

}
