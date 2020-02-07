import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Problem114 {
	
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	class Solution {
	    List<Integer> list = new ArrayList<>();
	    
	    public void flatten(TreeNode root) {
	        if(root==null) return;
	        preorder(root);
	        TreeNode cur = root;
	        for(int i=1;i<list.size();i++){
	            cur.left = null;
	            cur.right = new TreeNode(list.get(i));
	            cur = cur.right;
	        }
	    }
	    
	    public void preorder(TreeNode root){
	        if(root==null) return;
	        list.add(root.val);
	        preorder(root.left);
	        preorder(root.right);
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
