class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n=len(gas)
        if sum(gas)-sum(cost)<0:
            return -1
        i=0
        tank=0
        start=0
        while True:
            if start==i-n and tank>=0:
                return i%n
            if tank<0:
                tank=0
                start=i
            tank+=gas[i%n]-cost[i%n]
            i+=1
            
            
        