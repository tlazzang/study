
public class Problem237 {
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */

	    public void deleteNode(ListNode node) {
//	         O(n) Solution
//	         now = node;
//	         ListNode prev = null;
//	         while(now != null){
//	             if(now.next == null){
//	                 prev.next = null;
//	                 break;
//	             }
//	             now.val = now.next.val;
//	             prev = now;
//	             now = now.next;
//	         }
	        
//	         O(1) Solutuon
	        node.val = node.next.val;
	        node.next = node.next.next;

	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
