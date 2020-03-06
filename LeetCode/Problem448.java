import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], true);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1; i < nums.length + 1; i++){
            if(!map.containsKey(i)){
                result.add(i);
            }
        }
        return result;
    }
}
