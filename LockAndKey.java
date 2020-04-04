
public class LockAndKey {
	
    public static boolean solution(int[][] key, int[][] lock) {
        for(int i = 0; i < 4; i++) {
        	if(check(key, lock)) return true;
        	key = getRotatedKey(key);
        	System.out.println("hi");
        }
        return false;
    }
    
    public static int[][] getRotatedKey(int[][] key){
    	int[][] rotatedKey = new int[key.length][key.length];
    	for(int i = 0; i < rotatedKey.length; i++) {
    		for(int j = 0, k = rotatedKey.length - 1; j < rotatedKey.length; j++, k--) {
    			rotatedKey[i][j] = key[k][i];
    		}
    	}
    	return rotatedKey;
    }
    
    public static boolean check(int[][] key, int[][] lock) {
    	boolean flag = true;
    	for(int r = lock.length; r >= -lock.length; r--) {
    		for(int c = lock.length; c >= -lock.length; c--) {
    			flag = true;
    			for(int i = 0; i < lock.length; i++) {
    				for(int j = 0; j < lock.length; j++) {
    					if(lock[i][j] == 0) {
    						if(!rangeCheck(i+r, j+c, key) || key[i+r][j+c] != 1) {
    							flag = false;
    							break;
    						}
    					}else if(lock[i][j] == 1 && rangeCheck(i+r, j+c, key) && key[i + r][j + c] == 1) {
    						flag = false;
    						break;
    					}
    				}
    			}
    			if(flag) return true;
    		}
    	}
    	return flag;
    }
    
    public static boolean rangeCheck(int i, int j, int[][] arr) {
    	return i >= 0 && i < arr.length && j >= 0 && j < arr[0].length;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key, lock));
	}

}
