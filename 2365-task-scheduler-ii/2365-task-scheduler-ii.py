class Solution:
    def taskSchedulerII(self, tasks: List[int], space: int) -> int:
        time = 0
        ptr = 0
        mp = {}
        
        while ptr<len(tasks):
            if tasks[ptr] in mp and mp[tasks[ptr]]>time:
                time = mp[tasks[ptr]]
            else:
                mp[tasks[ptr]] = time+space+1
                time+=1
                ptr+=1
        return time