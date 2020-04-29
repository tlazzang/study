import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main17825 {
	
	public static class Node{
		int score;
		Node next;
		Node anotherNext;
		boolean isThereHorse;
		
		public Node(int score) {
			this.score = score;
			this.next = null;
			this.anotherNext = null;
			isThereHorse = false;
		}
	}
	
	public static class Horse{
		Node now;
		
		public Horse(Node now) {
			this.now = now;
		}
	}
	
	public static Node start;
	public static Node end;
	public static ArrayList<Horse> horseList = new ArrayList<>();
	public static Horse[] pickedList = new Horse[10];
	public static int[] dice = new int[10];
	public static int result = Integer.MIN_VALUE;
	
	public static int solution() {
		makeGameBoard();
		solve1(4, 10, 0);
		return result;
	}
	
	public static void initGameBoard(Node node) {
		if(node == null) return;
		
		node.isThereHorse = false;
		
		if(node.anotherNext != null) {
			initGameBoard(node.anotherNext);
		}
		
		initGameBoard(node.next);
	}
	
	public static void initHorseList() {
		for(Horse h : horseList) {
			h.now = start;
		}
	}
	
    //중복순열: 순서가 중요하고(123!=321), 중복을 허용하는 경우
    private static void solve1(int n, int r, int depth) {
        if (depth == r) {
            initGameBoard(start);
            initHorseList();
            result = Math.max(result, getScoreAfterMovingHorse(pickedList, dice));
            return;
        }

        for (int i = 0; i < n; i++) {
            pickedList[depth] = horseList.get(i);
            solve1(n, r, depth + 1);
        }
    }
	
	static void swap(Horse[] arr, int depth, int i) {
	    Horse temp = arr[depth];
	    arr[depth] = arr[i];
	    arr[i] = temp;
	}
	
	public static int getScoreAfterMovingHorse(Horse[] horse, int[] dice) {
		int score = 0;
		
		for(int i = 0; i < 10; i++) {
			Horse h = horse[i];
			Node now = h.now;
			
			for(int k = 0; k < dice[i]; k++) {
				if(k == 0) {
					if(now.anotherNext != null) {
						now = now.anotherNext;
					}else {
						now = now.next;
					}
				}else {
					if(now.next == null) {
						System.out.println("hi");
					}
					now = now.next;
				}
				if(now == end) {
					break;
				}
			}
			
			if(now.isThereHorse) {
				return -1;
			}
			
			if(now == end) {
				h.now.isThereHorse = false;
				h.now = start;
				h.now.isThereHorse = true;
			}else {
				h.now.isThereHorse = false;
				h.now = now;
				h.now.isThereHorse = true;
				score += h.now.score;
			}
		}
		
		if(score == 300) {
			System.out.println("hi");
		}
		return score;
	}
	
	public static void makeGameBoard() {
		start = new Node(0);
		end = new Node(0);
		for(int i = 0; i < 4; i++) {
			horseList.add(new Horse(start));
		}
		
		Node center = new Node(25);
		Node prev = null;
		Node centerEnd = null;
		for(int i = 30; i <= 35; i+=5) {
			Node node = new Node(i);
			if(i == 30) {
				center.next = node;
			}else {
				prev.next = node;
			}
			
			if(i == 35) {
				centerEnd = node;
			}
			prev = node;
		}
		
		prev = null;
		Node node40 = null;
		for(int i = 2; i <= 40; i += 2) {
			Node node = new Node(i);
			if(i == 2) {
				start.next = node;
			}else if(i == 40) {
				node40 = node;
				node.next = end;
				prev.next = node;
			}else {
				prev.next = node;
			}
			
			if(node.score == 10) {
				Node prevNode = null;
				for(int j = 13; j <= 19; j+=3) {
					Node newNode = new Node(j);
					if(j == 13) {
						node.anotherNext = newNode;
					}else {
						prevNode.next = newNode;
					}
					prevNode = newNode;
				}
				prevNode.next = center;
			}
			
			if(node.score == 20) {
				Node prevNode = null;
				for(int j = 22; j <= 24; j+=2) {
					Node newNode = new Node(j);
					if(j == 22) {
						node.anotherNext = newNode;
					}else {
						prevNode.next = newNode;
					}
					prevNode = newNode;
				}
				prevNode.next = center;
			}
			
			if(node.score == 30) {
				Node prevNode = null;
				for(int j = 28; j >= 26; j--) {
					Node newNode = new Node(j);
					if(j == 28) {
						node.anotherNext = newNode;
					}else {
						prevNode.next = newNode;
					}
					prevNode = newNode;
				}
				prevNode.next = center;
			}
			
			prev = node;
		}
		
		centerEnd.next = node40;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		dice = new int[10];
		for(int i = 0; i < 10; i++) {
			dice[i] = Integer.valueOf(split[i]);
		}
		System.out.println(solution());
	}

}
