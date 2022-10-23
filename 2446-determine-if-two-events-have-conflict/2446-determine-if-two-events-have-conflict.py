class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        def gettime(t):
            return int(t[:2])*60 + int(t[3:])
        return gettime(event1[0])<=gettime(event2[0])<=gettime(event1[1]) or gettime(event2[0])<=gettime(event1[0])<=gettime(event2[1])
            
        