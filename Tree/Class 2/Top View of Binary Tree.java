class Pair{
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
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> TopView = new ArrayList<>();
        
        Queue<Pair> queue = new LinkedList<>(); 
        Map<Integer , Integer > map = new HashMap<>(); 
        queue.add(new Pair(root , 0));
        int maxVerticalLine = Integer.MIN_VALUE;
        int minVerticalLine = Integer.MAX_VALUE;
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
                queue.add(new Pair(node.right , verticalLine + 1));
                
                if(!map.containsKey(verticalLine))
                {
                    map.put(verticalLine , node.data);
                    minVerticalLine = Math.min(minVerticalLine , verticalLine);
                    maxVerticalLine = Math.max(maxVerticalLine , verticalLine);
                }
                
            }
        }
        for(int i = minVerticalLine ; i <= maxVerticalLine ; i++)
        {
            int value = map.get(i);
            TopView.add(value);
        }
        return TopView;
    }
}
// TC : O(N)
// SC : O(N)
