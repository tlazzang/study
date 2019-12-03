import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem890 {
	
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> wordMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            boolean isMatched = true;
            for(int j = 0; j < pattern.length(); j++){
                String key = pattern.charAt(j)+"";
                String value = words[i].charAt(j)+"";
                if(!map.containsKey(pattern.charAt(j)+"")){
                    map.put(key, value);
                }
                else{
                    if(!map.get(key).equals(value){
                        isMatched = false;
                        break;
                    }
                }
                
                if(!wordMap.containsKey(value)){
                    wordMap.put(value, key);
                }
                else{
                    if(!wordMap.get(value).equals(key)){
                        isMatched = false;
                        break;
                    }
                }
            }
            if(isMatched) list.add(words[i]);
            map.clear();
            wordMap.clear();
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem890 p = new Problem890();
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
		p.findAndReplacePattern(words, pattern);
	}

}
