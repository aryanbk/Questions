class Solution:
    def minimumSteps(self, s: str) -> int:
        z=0
        step=0
        for i in range(len(s)):
            if s[i] == '1':
                z += 1
            else:
                step += z
        return step