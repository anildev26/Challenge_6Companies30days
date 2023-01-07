package challenge_6Company_30Days;

import javax.swing.tree.TreeNode;
import java.util.*;

public class gsAllElementsInTwoBinarySearch {

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
 }

    List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return res;
        }
        helper(root1);
        helper(root2);
        Collections.sort(res);
        return res;
    }
    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        res.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
