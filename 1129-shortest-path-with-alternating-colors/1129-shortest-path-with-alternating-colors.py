class Solution:
    def shortestAlternatingPaths(self, n: int, red: List[List[int]], blue: List[List[int]]) -> List[int]:
        
        def find(dest):
            q = [(0, None)]
            step=1
            vis=set()
            while True:
                if not q:
                    return -1
                for _ in range(len(q)):
                    curr, col = q.pop(0)
                    for node, node_col in edge[curr]:
                        # print("hi", node, curr, node_col)
                        if (col != node_col) and (curr, node,node_col) not in vis:
                            if node == dest:
                                # print('hi')
                                return step
                            q.append((node, node_col))
                            vis.add((curr, node, node_col))
                step+=1
        
        
        edge=defaultdict(list)
        for a,b in red: edge[a].append((b, True))
        for a,b in blue: edge[a].append((b, False))
        ans = [0]*n
        for dest in range(1, n): ans[dest] = find(dest)
        return ans
            