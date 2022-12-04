class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        n, sumt = len(skill)//2, sum(skill)
        if sumt%n!=0: return -1
        
        skill.sort()
        team, ans = sumt//n, 0
        for i in range(n):
            if skill[i]+skill[2*n-i-1] != team: return -1
            ans += skill[i]*skill[2*n-i-1]
        return ans
        