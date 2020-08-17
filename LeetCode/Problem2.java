import java.util.Stack;

public class Problem2 {
	
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        
        Stack<Integer> l1_stack = new Stack<>();
        Stack<Integer> l2_stack = new Stack<>();
        
        while(l1.next != null) {
        	l1_stack.push(l1.val);
        	l1 = l1.next;
        }
        l1_stack.push(l1.val);
        
        while(l2.next != null) {
        	l2_stack.push(l2.val);
        	l2 = l2.next;
        }
        l2_stack.push(l2.val);
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        while(!l1_stack.isEmpty()) {
        	sb1.append(String.valueOf(l1_stack.pop()));
        }
    
        while(!l2_stack.isEmpty()) {
        	sb2.append(String.valueOf(l2_stack.pop()));
        }
        
        sb1 = sb1.reverse();
        sb2 = sb2.reverse();
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int overflow = 0;
        
        while(true) {
        	if(sb1.length() == idx || sb2.length() == idx) {
        		break;
        	}
        	int a = Integer.valueOf(sb1.charAt(idx)+"");
        	int b = Integer.valueOf(sb2.charAt(idx)+"");
        	int sum = a + b + overflow;
        	
        	if(sum >= 10) overflow = 1;
        	else overflow = 0;
        	
        	String s = String.valueOf(sum);
        	sb.append(s.charAt(s.length() - 1)+"");
        	
        	idx++;
        }
        
        if(sb1.length() == idx) {
        	while(true) {
        		if(sb2.length() == idx) {
        			break;
        		}
        		int a = Integer.valueOf(sb2.charAt(idx)+"");
        		a += overflow;
        		if(a >= 10) overflow = 1;
        		else overflow = 0;
        		
        		String s = String.valueOf(a);
        		sb.append(s.charAt(s.length() - 1)+"");
        		idx++;
        	}
        }else {
        	while(true) {
        		if(sb1.length() == idx) {
        			break;
        		}
        		int a = Integer.valueOf(sb1.charAt(idx)+"");
        		a += overflow;
        		if(a >= 10) overflow = 1;
        		else overflow = 0;
        		
        		String s = String.valueOf(a);
        		sb.append(s.charAt(s.length() - 1)+"");
        		idx++;
        	}
        }
        
        ListNode nowNode = head;
        for(int i = 0; i < sb.length(); i++) {
        	nowNode.val = Integer.valueOf(sb.charAt(i)+"");
        	if(i != sb.length() - 1) {
            	ListNode next = new ListNode();
            	nowNode.next = next;
            	nowNode = nowNode.next;
        	}
        }
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(l1, l2);
		while(result.next != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.print(result.val);
	}

}
