class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        def bk(ptr, sub):
            if ptr>=len(digits):
                if sub:
                    ans.append(sub[:])
                return

            for i in ref[int(digits[ptr])-2]:
                sub+=i
                bk(ptr+1, sub)
                sub=sub[:-1]
        
        ref=["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" ]
        ans=[]
        bk(0, "")
        return ans
                
            
            
            
        