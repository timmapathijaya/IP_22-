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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if(root == null)
            return inorder;
        // Morris Traversal 
        // Inorder : Left , Root , Right 
        while(root != null)
        {
            if(root.left == null)
            {
                inorder.add(root.val);
                root = root.right;
            }
            else 
            {
                TreeNode node = root.left;
                while(node.right != null && node.right != root)
                {
                    node = node.right;
                }
                if(node.right == null) // Creating returning path
                {
                    node.right = root;
                    root = root.left;
                }
                else if(node.right == root) // Left Subtree is already explored
                {
                    node.right = null;
                    inorder.add(root.val);
                    root = root.right;
                }
                
            }
        }
        return inorder;
    }
}

// TC : O(3 * (N - 1)) => O(N)
// SC : O(1)
