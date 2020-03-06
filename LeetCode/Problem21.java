public class Problem21 {
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode result;
	        if(l1 == null && l2 == null){
	            return null;
	        }
	        if(l1 == null || l2 == null){
	            if(l1 == null){
	                result = new ListNode(l2.val);
	                l2 = l2.next;
	            }
	            else{
	                result = new ListNode(l1.val);
	                l1 = l1.next;
	            }
	        }
	        else{
	            if(l1.val > l2.val){
	            result = new ListNode(l2.val);
	            l2 = l2.next;
	        }else{
	            result = new ListNode(l1.val);
	            l1 = l1.next;
	        }
	        }
	        ListNode now = result;
	        while(l1 != null || l2 != null){
	            if(l1 == null || l2 == null){
	                if(l1 == null){
	                    now.next = new ListNode(l2.val);
	                    l2 = l2.next;
	                }else{
	                    now.next = new ListNode(l1.val);
	                    l1 = l1.next;
	                }
	            }
	            else{
	                if(l1.val > l2.val){
	                    now.next = new ListNode(l2.val);
	                    l2 = l2.next;
	                }else{
	                    now.next = new ListNode(l1.val);
	                    l1 = l1.next;
	                }
	            }
	            now = now.next;
	        }
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
