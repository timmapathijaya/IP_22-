/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        
        if(root == null)
            return preorder;
        
        // Morris Traversal 
        // Preorder : Root , Left , Right
        while(root != null)
        {
            if(root.left == null)
            {
              preorder.add(root.val);  
              root = root.right;
            }
            else 
            {
                TreeNode node = root.left;
                while(node.right != null && node.right != root)
                {
                    node = node.right;
                }
                if(node.right == null) // Creat the return path
                {   
                    node.right = root;
                    preorder.add(root.val);
                    root = root.left;
                }
                else if(node.right == root) // Left subtree is already explored
                {
                    node.right = null;
                    root = root.right;
                }
            }
        }
        return preorder;
    }
}
// TC : O(3 * (N - 1)) => O(N)
// SC : O(1)
