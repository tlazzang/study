import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	 
	
    List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        return list;
    }
    public void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> listOfLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode now = queue.poll();
                if(now != null ){
                    listOfLevel.add(now.val);
                }
                if(now.left != null){
                    queue.add(now.left);
                }
                if(now.right != null){
                    queue.add(now.right);
                }
            }
            list.add(listOfLevel);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
