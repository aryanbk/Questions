class Solution:
    def findOrder(self, numCourses: int, prereq: List[List[int]]) -> List[int]:
        
        adj = [None]*numCourses
        for i in prereq:
            if adj[i[0]]:
                adj[i[0]].append(i[1])
            else:
                adj[i[0]]=[i[1]]
        
        vis1, vis2 = [False]*numCourses, [False]*numCourses
        flow = [] #Topological sorting
        
        def dfs(i):
            if vis2[i]==True:
                return False
            if vis1[i]==True:
                return True
            
            vis1[i]=True
            vis2[i]=True
            if adj[i]:
                for pre in adj[i]:
                    if not dfs(pre):
                        return False
            vis2[i]=False
            flow.append(i)
            return True

        for i in range(numCourses):
            if not dfs(i):
                return []
        return flow