import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Problem114 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode now = root;
        while(true){
            if(now.left != null){
                TreeNode tmp = now.right;
                now.right = now.left;
                getTreeNodeBottomRight(now.left).right = tmp;
                now.left = null;
            }else{
                if(now.right == null) break;
                now = now.right;
            }
        }
    }
    
    public TreeNode getTreeNodeBottomRight(TreeNode root){
        if(root.right == null){
            return root;
        }else{
            return getTreeNodeBottomRight(root.right);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
