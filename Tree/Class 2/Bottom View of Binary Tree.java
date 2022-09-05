class Pair 
{
    Node node;
    int verticalLine;
    public Pair(Node node , int verticalLine)
    {
        this.node = node;
        this.verticalLine = verticalLine;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> BottomView = new ArrayList<>();
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root , 0 ));
        // The last node in a every vertical line is visible from bottom 
        
        Map<Integer , Integer > map = new HashMap<>();
        int leftMostVerticalLine = Integer.MAX_VALUE;
        int rightMostVerticalLine = Integer.MIN_VALUE;
        // Level Order
        while(queue.isEmpty() == false)
        {
             int levelSize = queue.size();
             for(int i = 1 ; i <= levelSize ; i++)
             {
                 Pair p = queue.poll();
                 Node node = p.node;
                 int verticalLine = p.verticalLine;
                 if(node.left != null)
                 queue.add(new Pair(node.left , verticalLine - 1));
                 
                 if(node.right != null)
                 queue.add(new Pair (node.right , verticalLine + 1));
                 
                 map.put(verticalLine , node.data);
                 
                 leftMostVerticalLine = Math.min(leftMostVerticalLine , verticalLine);
                 rightMostVerticalLine = Math.max(rightMostVerticalLine , verticalLine);
             }
        }
        for(int i = leftMostVerticalLine ; i <= rightMostVerticalLine ; i++)
        BottomView.add(map.get(i));
        
        return BottomView;
        
    }
}
// TC : O(N)
// SC : O(2N)
