import java.util.LinkedList;
import java.util.Queue;

public class Problem617 {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
}
	
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> t1_queue = new LinkedList<>();
        Queue<TreeNode> t2_queue = new LinkedList<>();
        Queue<TreeNode> t3_queue = new LinkedList<>();
        if(t1 == null && t2 == null) return null;
        TreeNode root = new TreeNode(0);
        t1_queue.add(t1);
        t2_queue.add(t2);
        t3_queue.add(root);
        
        if(t1 != null){
            root.val = root.val + t1.val;
        while(!t1_queue.isEmpty()){
            TreeNode now = t1_queue.poll();
            TreeNode t3 = t3_queue.poll();
            if(now.left != null){
                if(t3.left == null){
                    t3.left = new TreeNode(now.left.val);
                }
                else{
                    t3.left.val = t3.left.val + now.left.val;
                }
                t1_queue.add(now.left);
                t3_queue.add(t3.left);
            }
            
            if(now.right != null){
                if(t3.right == null){
                    t3.right = new TreeNode(now.right.val);
                }
                else{
                    t3.right.val = t3.right.val + now.right.val;
                }
                t1_queue.add(now.right);
                t3_queue.add(t3.right);
            }
            
        }
        }
        
        t3_queue.add(root);
        
        if(t2 != null){
            root.val = root.val + t2.val;
        while(!t2_queue.isEmpty()){
            TreeNode now = t2_queue.poll();
            TreeNode t3 = t3_queue.poll();
            if(now.left != null){
                if(t3.left == null){
                    t3.left = new TreeNode(now.left.val);
                }
                else{
                    t3.left.val = t3.left.val + now.left.val;
                }
                t2_queue.add(now.left);
                t3_queue.add(t3.left);
            }
            
            if(now.right != null){
                if(t3.right == null){
                    t3.right = new TreeNode(now.right.val);
                }
                else{
                    t3.right.val = t3.right.val + now.right.val;
                }
                t2_queue.add(now.right);
                t3_queue.add(t3.right);
            }
            
        }
        }
        return root;
    }

}
