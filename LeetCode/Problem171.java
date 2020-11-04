import java.util.HashMap;

public class Problem171 {
	
	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
    public static int titleToNumber(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < alphabet.length(); i++) {
        	map.put(alphabet.charAt(i), i + 1);
        }
        
        for(int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
        	result += Math.pow(26, j) * map.get(s.charAt(i));
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("A"));
	}

}
