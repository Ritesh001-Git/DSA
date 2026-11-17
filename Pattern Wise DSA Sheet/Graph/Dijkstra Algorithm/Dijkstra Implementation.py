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
