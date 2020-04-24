package KakaoWinterInternship;

import java.util.ArrayList;
import java.util.HashMap;

public class SetRoomNumber {
	
	public static class Node{
		long num;
		Node next;
		boolean occcupied;
		public Node(long num, Node next, boolean occupied) {
			this.num = num;
			this.next = next;
			this.occcupied = occupied;
		}
	}
	
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap<Long, Node> map = new HashMap<>();
        for(int i = 0; i < room_number.length; i++) {
        	if(map.get(room_number[i]) == null) {
        		answer[i] = room_number[i];
        		if(map.get(room_number[i] + 1) == null) {
        			Node parentNode = new Node(room_number[i] + 1, null, false);
        			Node node = new Node(room_number[i], parentNode, true);
        			map.put(room_number[i], node);
        			map.put(room_number[i] + 1, parentNode);
        		}else {
        			Node node = new Node(room_number[i], map.get(room_number[i] + 1), true);
        			map.put(room_number[i], node);
        		}
        	} else {
        		ArrayList<Node> visitedNode = new ArrayList<>();
        		Node current = map.get(room_number[i]);
        		visitedNode.add(current);
        		while(current.occcupied) {
        			current = current.next;
        			visitedNode.add(current);
        		}
        		current.occcupied = true;
        		answer[i] = current.num;
        		if(map.get(current.num + 1) == null) {
        			current.next = new Node(current.num + 1, null, false);
        			map.put(current.num + 1, current.next);
        		}else {
        			current.next = map.get(current.num + 1);
        		}
        		
        		for(Node n : visitedNode) {
        			n.next = current.next;
        		}
        	}
        	
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		long[] answer = solution(k, room_number);
		for(long l : answer) {
			System.out.print(l + " ");
		}
	}

}
