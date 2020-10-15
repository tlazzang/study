
public class Problem206 {
	
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 
	 public static ListNode h;
	 
    public static ListNode reverseList(ListNode head) {
//         ListNode now = head;
//         ListNode prev = null;
//         while(now != null){
//             ListNode tmp = now.next;
//             now.next = prev;
//             prev = now;
//             now = tmp;
//         }
//         head = prev;
//         return head;
        ListNode lastNode = reverse(head);
        lastNode.next = null;
        System.out.println(head.val);
        return h;
    }
    
    public static ListNode reverse(ListNode now){
        if(now.next == null){
            h = now;
//            System.out.println(head.val);
            return now;
        }
        
        ListNode prev = reverse(now.next);
        prev.next = now;
//        System.out.println(prev.val + " -> " + now.val);
//        System.out.println(head.val);
        return now;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		head = reverseList(head);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}

}
