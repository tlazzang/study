import java.util.Stack;

public class Problem155 {
	
    public static class Node{
        int val;
        Node prev;
        public Node(int val){
            this.val = val;
        }
    }
    
    public static Stack<Node> stack = new Stack<>();
    public static Node minNode = null;
    
    
    public static void push(int x) {
        Node n = new Node(x);
        if(minNode == null){
            minNode = n;
        }
        
        if(minNode.val > n.val){
            Node tmpMin = minNode;
            minNode = n;
            n.prev = tmpMin;
        }
        stack.push(n);
    }
    
    public static void pop() {
        Node n = stack.pop();
        if(n == minNode){
            minNode = minNode.prev;
        }
    }
    
    public static int top() {
        return stack.peek().val;
    }
    
    public static int getMin() {
        return minNode.val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		push(-2);
//		push(0);
//		push(-3);
//		System.out.println(getMin());
//		pop();
//		System.out.println(top());
//		System.out.println(getMin());
//		System.out.println(getMin());
		
		push(2);
		pop();
		push(3);
		System.out.println(getMin());
	}

}
