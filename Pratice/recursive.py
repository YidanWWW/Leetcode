class Solution:
    def recursive(self, n: int, m: int):
        res = [] 
        path = []
        self.dfs(n, m, res, path)
        return res
        
    def dfs(self, n, m, res, path):
        if len(path)==n:
            res.append(path[:])
            return
        for i in range(1, m+1):
            path.append(i)
            self.dfs(n, m, res, path)
            path.pop()

n = 2
m = 4 #-> [[1],[2],[3],[4]]
solution = Solution()
print(solution.recursive(n, m))
