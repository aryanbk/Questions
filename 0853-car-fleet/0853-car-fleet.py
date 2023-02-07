class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        stk = []
        
        for pos, sp in sorted([(p, s) for p,s in zip(position, speed)])[::-1]:
            time = (target-pos)/sp
            if (not stk) or time>stk[-1]: stk.append(time)
        
        return len(stk)