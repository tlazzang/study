
public class Problem337 {
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	    public int rob(TreeNode root) {
	        int[] res=dfs(root);
	        return Math.max(res[0],res[1]);
	    }
	    private int[] dfs(TreeNode node){
	        //int[0] represents the largest num in current layer
	        //int[1] represents the largest num in children layer
	        if(node==null)return new int[2];
	        
	        if(node.left==null & node.right==null){
	            return new int[]{node.val,0};
	        }
	        int[] leftResult=dfs(node.left);
	        int[] rightResult=dfs(node.right);
	        
	        int[] res=new int[2];
	        res[0]=leftResult[1]+rightResult[1]+node.val;
	        res[1]=Math.max(leftResult[1],leftResult[0])+Math.max(rightResult[1],rightResult[0]);
	        return res;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
