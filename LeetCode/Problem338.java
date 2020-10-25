
public class Problem338 {
	
    public int[] countBits(int num) {
    	int[] answer = new int[num + 1];
    	for(int i = 0; i <= num; i++) {
    		String binaryString = Integer.toBinaryString(i);
    		int cnt = 0;
    		for(int j = 0; j < binaryString.length(); j++) {
    			if(Integer.valueOf(binaryString.charAt(j)+"") == 1) {
    				cnt++;
    			}
    		}
    		answer[i] = cnt;
    	}
    	return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem338 p = new Problem338();
		int[] answer = p.countBits(5);
		for(int n : answer) {
			System.out.print(n+" ");
		}
	}
}
