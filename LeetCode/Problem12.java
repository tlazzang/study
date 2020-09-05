
public class Problem12 {
	
    public static String intToRoman(int num) {
        String answer = "";
        
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        for(int i = nums.length - 1; i >= 0; i--) {
        	
            if(num / 900 > 0) {
            	answer += "CM";
            	num = num % 900;
            	continue;
            }else if(num / 400 > 0) {
            	answer += "CD";
            	num = num % 400;
            	continue;
            }else if(num / 90 > 0) {
            	num = num % 90;
            	continue;
            }else if(num / 40 > 0) {
            	num = num % 40;
            	continue;
            }else if(num / 9 > 0) {
            	answer += "IX";
            	num = num % 9;
            	continue;
            }else if(num / 4 > 0) {
            	answer += "IV";
            	num = num % 4;
            	continue;
            }
            
        	if(num / nums[i] > 0) {
        		int cnt = num / nums[i];
        		for(int k = 0; k < cnt; k++) {
        			answer += roman[i];
        		}
        		num = num % nums[i];
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(1994));
	}

}
