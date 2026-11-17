# Python
# TC - O((V+E)log V)
# SC - O((V+E)

class Solution:
    def dijkstra(self, adj: list[list[list[int]]], src: int) -> list[int]:
        # code here
        import heapq
        
        V = len(adj)
        pq = []
        
        # graph = [[] for _ in range(V)]
        
        # for u, v, w in adj:
        #     graph[u].append((v, w))
        #     graph[v].append((u, w))
        
        dist = [float("inf")] * V
        
        heapq.heappush(pq,(0,src))
        
        dist[src] = 0
        
        while pq:
            currWt, currVtx = heapq.heappop(pq)
            
            if currWt > dist[currVtx]:
                continue
            
            for newVtx, wt in adj[currVtx]:
                newWt = currWt + wt
                
                if newWt < dist[newVtx]:
                    dist[newVtx] = newWt
                    
                    heapq.heappush(pq,(newWt, newVtx))
                    
        return dist

# Java
# TC - O((V+E)log V)
# SC - O((V+E)

class Solution {
    class Pair{
        int vtx,wt;
        Pair(int vtx,int wt){
            this.vtx=vtx;
            this.wt=wt;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        List<List<Pair>> graph=new ArrayList<>();
        
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            
            graph.get(u).add(new Pair(v,w));
            graph.get(v).add(new Pair(u,w));
        }
        pq.add(new Pair(src,0));
        dist[src]=0;
        while(!pq.isEmpty()){
            
            Pair temp=pq.poll();
            int currVtx=temp.vtx;
            int currWt=temp.wt;
            
            for(Pair n:graph.get(currVtx)){
                int newVtx=n.vtx;
                int newWt=n.wt+currWt;
                
                if(newWt<dist[newVtx]){
                    dist[newVtx]=newWt;
                    pq.add(new Pair(newVtx,newWt));
                }
            }
        }
        
        return dist;
    }
}
