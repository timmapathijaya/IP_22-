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
class Sum 
{
    int sum;
    Sum(int sum)
    {
        this.sum = sum;
    }
}
class Solution {
    public void reverseInorder(TreeNode node , Sum s)
    {
        if(node == null)
            return;
        reverseInorder(node.right , s);
        node.val = node.val + s.sum;
        s.sum = node.val;
        reverseInorder(node.left , s);
        
    }
    public TreeNode bstToGst(TreeNode root) {
        // Reverse Inorder => In Decreasing Order we will get the values 
        if(root.left == null && root.right == null)
            return root;
        reverseInorder(root , new Sum(0));
        return root;
    }
}
// TC : O(N)
// SC : O(Height of BST)
