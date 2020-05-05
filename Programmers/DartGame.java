package KakaoBlidn2018;

import java.util.ArrayList;
import java.util.List;

public class DartGame {
	
	public static ArrayList<Integer> scoreList = new ArrayList<>();
	
	public static int solution(String dartResult) {
	    int answer = 0;
	    
	    for(int i = 0; i < dartResult.length(); i++) {
	    	if(Character.isDigit(dartResult.charAt(i))) {
	    		int endIdx = i + 1;
	    		while(true) {
	    			if(Character.isUpperCase(dartResult.charAt(endIdx))) break;
	    			endIdx++;
	    		}

	    		if(endIdx + 1 < dartResult.length()) {
	    			if(dartResult.charAt(endIdx + 1) == '*' || dartResult.charAt(endIdx + 1) == '#') {
	    				endIdx++;
	    				String sub = dartResult.substring(i, endIdx + 1);
	    	    	
	    	    		String bonus = dartResult.charAt(endIdx - 1)+"";
	    	    		int score = Integer.valueOf(sub.split(bonus+"")[0]);
	    	    		String option = sub.split(bonus+"")[1];
	    	    		applyScore(score, bonus, option);
	    			}else {
	    				String sub = dartResult.substring(i, endIdx + 1);
	    				
	    	    		String bonus = dartResult.charAt(endIdx)+"";
	    	    		int score = Integer.valueOf(sub.split(bonus+"")[0]);
	    	    		applyScore(score, bonus, "");
	    			}
	    		}else {
    				String sub = dartResult.substring(i, endIdx + 1);
    				
    	    		String bonus = dartResult.charAt(endIdx)+"";
    	    		int score = Integer.valueOf(sub.split(bonus+"")[0]);
    	    		applyScore(score, bonus, "");
	    		}
	    		i = endIdx;
	    	}
	    }
	    
	    for(int n : scoreList) {
	    	answer += n;
	    }
	    return answer;
	}
	
	public static void applyScore(int score, String bonus, String option) {
		if(option.isEmpty()) {
			if(bonus.equals("S")) {
				score = score;
			}else if(bonus.equals("D")) {
				score = score * score;
			}else {
				score = score * score * score;
			}
			scoreList.add(score);
		}else {
			if(bonus.equals("S")) {
				score = score;
			}else if(bonus.equals("D")) {
				score = score * score;
			}else {
				score = score * score * score;
			}
			
			if(option.equals("*")) {
				score = score * 2;
				if(scoreList.size() > 0) {
					Integer i = scoreList.get(scoreList.size() - 1) * 2;
					scoreList.set(scoreList.size() - 1, i);
				}
			}else {
				score = score * -1;
			}
			scoreList.add(score);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1S2D*3T";
		System.out.println(solution(s));
	}

}
