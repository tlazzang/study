
public class Problem617 {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
}
	
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        TreeNode t3 = new TreeNode(t1.val + t2.val);
        dfs(t1,t3);
        dfs(t2,t3);
        return t3;
    }
    public void dfs(TreeNode t1, TreeNode t3){
        if(t1 == null && t3 == null) return;
        if(t1 != null && t3 != null){
            t3.val = t1.val + t3.val;
        }
        if(t1 == null || t3 == null){
            if(t1 == null){
                return;
            }
            if(t3 == null){
            	TreeNode newNode = new TreeNode(t1.val);
            	t3.
                t3 = new TreeNode(t1.val);
            }
        }
        dfs(t1.left, t3.left);
        dfs(t1.right, t3.right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem617 p = new Problem617();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		
		TreeNode t3 = p.mergeTrees(t1,t2);
	}

}
