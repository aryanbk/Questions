class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        
        def merge(a, b):
            n, m = len(a), len(b)
            ans = []
            
            i = j = k = 0
            
            while i<n and j<m:
                if a[i]<=b[j]:
                    # ans[k] = a[i]
                    ans.append(a[i])
                    i+=1
                else:
                    # ans[k] = b[j]
                    ans.append(b[j])
                    j+=1
                k+=1
            while i<n:
                # ans[k] = a[i]
                ans.append(a[i])
                i+=1
                k+=1
            while j<m:
                # ans[k] = b[j]
                ans.append(b[j])
                j+=1
                k+=1
            return ans
        
        def divide(l):
            if len(l)<=1:
                return l
            first, last = divide(l[len(l)//2:]), divide(l[:len(l)//2])
            
            return merge(first, last)
            
        return divide(nums)