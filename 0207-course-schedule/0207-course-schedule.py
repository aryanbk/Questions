class Solution:
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        adj = [None]*numCourses
        for i in prereq:
            if adj[i[0]]:
                adj[i[0]].append(i[1])
            else:
                adj[i[0]]=[i[1]]
        
        vis1, vis2 = [False]*numCourses, [False]*numCourses
        
        def dfs(i):
            if vis2[i]==True:
                return False
            if vis1[i]==True:
                return True

            vis1[i]=True
            vis2[i]=True
            ans=True
            if adj[i]:
                for pre in adj[i]:
                    ans = ans and dfs(pre)
            vis2[i]=False
            return ans
        
        
        
        for i in range(numCourses):
            if not dfs(i):
                return False
        return True
        
        
            