import java.util.ArrayList;
import java.util.List;

public class Problem17 {
	
	public static List<String> result = new ArrayList<>();
	public static String[] arr = new String[10];
	
    public static List<String> letterCombinations(String digits) {
    	setArr();
    	dfs(digits, 0, digits.length(), 0, new StringBuilder());
        return result;
    }
    
    public static void dfs(String digits, int pickedCnt, int toPick, int index, StringBuilder sb) {
    	if(pickedCnt == toPick) {
    		result.add(sb.toString());
    		return;
    	}
    	int num = Integer.valueOf(digits.charAt(index)+"");
    	for(int i = 0; i < arr[num].length(); i++) {
    		sb.append(arr[num].charAt(i));
    		dfs(digits, pickedCnt + 1, toPick, index + 1, sb);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    }
    
    public static void setArr() {
    	arr[2] = "abc";
    	arr[3] = "def";
    	arr[4] = "ghi";
    	arr[5] = "jkl";
    	arr[6] = "mno";
    	arr[7] = "pqrs";
    	arr[8] = "tuv";
    	arr[9] = "wxyz";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = letterCombinations("");
		for(String s : result) {
			System.out.print(s + " , ");
		}
	}

}
