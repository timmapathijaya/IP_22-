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
        if(root == null)
            return root;
        // Try to connect the childs by standing in the parent only 
        Node node = root;
        while(node.left != null)
        {
            Node travellingNode = node;
            while(travellingNode != null)
            {
                travellingNode.left.next = travellingNode.right;
                if(travellingNode.next != null)
                {
                    travellingNode.right.next = travellingNode.next.left;
                }
                travellingNode = travellingNode.next;
            }
            node = node.left;
        }
        return root;
    }
}
// TC : O(N)
// SC : O(1)
