package KakaoWinterInternship;

public class CheatingUser {
	public static String[] picked_id;
	public static int answer = 0;
	public static boolean flag = false;
    public static int solution(String[] user_id, String[] banned_id) {
    	picked_id = new String[banned_id.length];
    	pickUserId(0, 0, banned_id.length, user_id, banned_id);
        return answer;
    }
    
    public static void pickUserId(int idx, int picked, int toPick, String[] user_id, String[] banned_id) {
    	if(picked == toPick) {
    		flag = false;
    		permutation(picked_id, banned_id, 0, picked_id.length, picked_id.length);
    		return;
    	}
    	for(int i = idx; i < user_id.length; i++) {
    		picked_id[picked] = user_id[i];
    		pickUserId(i + 1, picked + 1, toPick, user_id, banned_id);
    		picked_id[picked] = "";
    	}
    }
    
    static void permutation(String[] arr, String[] banned_id, int depth, int n, int r) {
    	if(flag) return;
        if (depth == r) {
            if(isMapping(arr, banned_id)) {
            	flag = true;
            	answer++;
            }
            return;
        }
     
        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, banned_id, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
     
    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    
    public static boolean isMapping(String[] picked_id, String[] banned_id) {
    	boolean[] visited = new boolean[banned_id.length];
    	for(int i = 0; i < picked_id.length; i++) {
    		boolean result = false;
    		for(int j = 0; j < banned_id.length; j++) {
    			if(visited[j]) continue;
    			if(picked_id[i].length() != banned_id[j].length()) continue;
    			boolean flag = true;
    			for(int k = 0; k < picked_id[i].length(); k++) {
    				if(picked_id[i].charAt(k) != banned_id[j].charAt(k) && banned_id[j].charAt(k) != '*') {
    					flag = false;
    					break;
    				}
    			}
    			if(flag) {
    				visited[j] = true;
    				result = true;
    				break;
    			}
    		}
    		if(!result) return false;
    	}
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(solution(user_id, banned_id));
	}

}
