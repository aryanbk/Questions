class Solution:
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        adj = [None]*numCourses
        for i in prereq:
            if adj[i[0]]:
                adj[i[0]].append(i[1])
            else:
                adj[i[0]]=[i[1]]
        # print(adj)
        
        vis1=[0]*numCourses
        vis2=[0]*numCourses
        
        
        def dfs(i):
            if vis1[i]!=0 and vis2[i]==0:
                return True
            if vis2[i]!=0:
                return False

            
            
            vis1[i]+=1
            vis2[i]+=1
            ans=True
            if adj[i]:
                for pre in adj[i]:
                    ans = ans and dfs(pre)
            vis2[i]-=1
            return ans
        
        
        
        for i in range(numCourses):
            if not dfs(i):
                return False
        return True
        #     if vis1[i]!=0:
        #         con
        #     if adj[i]==None:
        #         vis1[i]+=1
        #         # vis2[i]+=1
        #         continue
        
        
            