public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // In BST Inorder => Ascending Order 
        // Just Greater 
        TreeNode currentNode = root;
        TreeNode lastLeftTurn = null;
        TreeNode inorder_successorNode = null;

        while(currentNode != null)
        {
            if(currentNode == p)
            {
                if(currentNode.right != null)
                {
                   currentNode = currentNode.right; 
                   while(currentNode.left != null)
                   currentNode = currentNode.left;

                   inorder_successorNode = currentNode;
                }
                else 
                 inorder_successorNode = lastLeftTurn;

                 break;
            }
            else if(currentNode.val < p.val){
            currentNode = currentNode.right;
            }
            else{
                lastLeftTurn = currentNode;
                currentNode = currentNode.left;
            }
        }
        return inorder_successorNode;
    }
}
// TC : O(Height of Tree)
// SC : O(1)
