class Solution:
    def makeSimilar(self, nums: List[int], target: List[int]) -> int:
        nums.sort()
        target.sort()
        
        arr = [[], [], [], []]
        for i in range(len(nums)):
            if nums[i]%2==0:
                arr[0].append(nums[i])
            elif nums[i]%2!=0:
                arr[2].append(nums[i])
            
            if target[i]%2==0:
                arr[1].append(target[i])
            elif target[i]%2!=0:
                arr[3].append(target[i])
        
        ans=0
        for i in range(len(arr[0])):
            ans += abs(arr[0][i]-arr[1][i])
        for i in range(len(arr[2])):
            ans += abs(arr[2][i]-arr[3][i])
        
        return ans//4
        
        