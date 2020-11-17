import java.util.HashSet;

public class Problem160 {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode now = headA;
        while(now != null){
            if(set.contains(now)){
                return now;
            }
            set.add(now);
            now = now.next;
        }
        
        now = headB;
        while(now != null){
            if(set.contains(now)){
                return now;
            }
            set.add(now);
            now = now.next;
        }
        
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
