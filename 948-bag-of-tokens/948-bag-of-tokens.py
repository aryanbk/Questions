class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        tokens.sort()
        i,j,score = 0,len(tokens)-1, 0
        while i<=j:
            if power>=tokens[i]:
                power-=tokens[i]
                score+=1
                i+=1
            elif power<tokens[i] and power+tokens[j]>=tokens[i] and score>0:
                power+=tokens[j]-tokens[i]
                i+=1
                j-=1
            else:
                return score
        return score