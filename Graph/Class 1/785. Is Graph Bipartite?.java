class Solution {
    public boolean checkBipartiteBfs(int node , int[] colour , int[][] graph)
    {
        colour[node] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        
        while(queue.isEmpty() == false)
        {
            node = queue.poll();
            
            for(int i = 0 ; i < graph[node].length ; i++)
            {
                int adjNode = graph[node][i];
                if(colour[adjNode] == -1)
                {
                    colour[adjNode] = 1 - colour[node];
                    queue.add(adjNode);
                }
                else if(colour[adjNode] == colour[node])
                    return false;
            }
            
        }
        return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int colour[] = new int[V];
        
        Arrays.fill(colour , -1);
        
        for(int i = 0 ; i < V ; i++)
        {
            if(colour[i] == -1)
            {
                if(checkBipartiteBfs(i , colour , graph) == false)
                    return false;
            }
        }
        
        return true;
    }
}
// TC : O(V + E)
// SC : V + V => O(2V)
