package HackerRank;

import java.util.HashMap;

public class RansomNote {
	
	   static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String s : note){
            if(map.containsKey(s)){
                map.put(s, map.get(s) - 1);
            }else{
                map.put(s, -1);
            }
        }
        
        for(String s : magazine){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }else{
                map.put(s, 1);
            }
        }

        for(String s : note){
            if(map.get(s) < 0){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		String[] magazine = {"a","b","c","a","b","c"};
		String[] note = {"a","b","c"};
		checkMagazine(magazine, note);

	}

}
