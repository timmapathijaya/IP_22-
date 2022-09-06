class Solution {
     
    public long imageMultiplication(Node leftNode , Node rightNode)
    {
        if(leftNode == null || rightNode == null)
        return 0;
        
        long mod = 1000000007;
        long sum = ( leftNode.data % mod * rightNode.data % mod ) % mod;
        sum = (sum % mod + imageMultiplication(leftNode.left , rightNode.right) % mod ) % mod;
        sum = (sum % mod + imageMultiplication(leftNode.right , rightNode.left) % mod ) % mod;
        
        return sum ;
    }
    public long imgMultiply(Node root)
    {
        long mod = 1000000007;
        long rootProduct = ( root.data % mod * root.data % mod ) % mod;
        
        return (imageMultiplication(root.left , root.right) % mod + rootProduct % mod ) % mod;
    }
}
// TC : O(N)
// SC : O(H)
