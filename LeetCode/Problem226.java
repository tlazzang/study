
public class Problem226 {
	
	
	 public class TreeNode {
		 int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	
    public TreeNode invertTree(TreeNode root) {
        invertUsingDfs(root);
        return root;
    }
    public void invertUsingDfs(TreeNode root){
        if(root == null){
            return ;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertUsingDfs(root.left);
        invertUsingDfs(root.right);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
