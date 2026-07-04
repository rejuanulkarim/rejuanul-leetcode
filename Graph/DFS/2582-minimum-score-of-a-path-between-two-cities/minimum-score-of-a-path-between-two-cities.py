class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        self.result = float("inf")
        self.visited = [False]*(n+1)
        # create adj list
        adj = [[]for _ in range(n+1)]
        #create graph
        for u,v,d in roads:
            adj[u].append((v,d))
            adj[v].append((u,d))
        def dfs(u):
            self.visited[u] = True
            for v,d in adj[u]:
                self.result = min(self.result, d)
                if not self.visited[v]:
                    dfs(v)
        dfs(1)
        return self.result
        