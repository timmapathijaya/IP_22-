class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
       ArrayList<Integer> ReverseLevelOrder = new ArrayList<>();
       Queue<Node> queue = new LinkedList<>();
       
       queue.add(node);
       // Level Order 
       while(queue.isEmpty() == false) // N
       {
           int levelSize = queue.size();
           for(int i = 1 ; i <= levelSize ; i++)
           {
               Node currentNode = queue.poll();
               
               if(currentNode.right != null)
               queue.add(currentNode.right);
               
               if(currentNode.left != null)
               queue.add(currentNode.left);
               
               ReverseLevelOrder.add(currentNode.data);
               
           }
       }
       
       Collections.reverse(ReverseLevelOrder); // N
       
       return ReverseLevelOrder;
    }
}      
// TC : O(2N)
// SC : O(N)
