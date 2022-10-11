/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node rootNode = root;
        
        while(root != null)
        {
            Node traversalPointer = root;
            Node prevNode = null; // prev not connected node
            Node startNode = null; // start node of the level
            
            while(traversalPointer != null)
            {
                if(traversalPointer.left != null)
                {
                    if(startNode == null) 
                      startNode = traversalPointer.left;
                    
                    if(prevNode != null)
                      prevNode.next = traversalPointer.left;
                    
                    if(traversalPointer.right != null)
                    {
                       traversalPointer.left.next = traversalPointer.right;
                       prevNode = traversalPointer.right; 
                    }
                    else
                      prevNode = traversalPointer.left;
                    
                }
                else if(traversalPointer.right != null)
                {
                    if(startNode == null)
                      startNode = traversalPointer.right;
                    
                    if(prevNode != null)
                      prevNode.next = traversalPointer.right;
                    
                    prevNode = traversalPointer.right;
                }
                
                traversalPointer = traversalPointer.next;
            }
            
            root = startNode;
        }
        return rootNode;
    }
}
// TC : O(N)
// SC : O(1)
