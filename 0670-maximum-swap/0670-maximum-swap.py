class Solution:
    def maximumSwap(self, num: int) -> int:
        num=list(str(num))
        for i in range(0, len(num)):
            maxi=num[i]
            ind=i
            for j in range(i+1, len(num)):
                if ord(num[j])>=ord(maxi):
                    maxi=num[j]
                    ind=j
            if maxi!=num[i]:
                num[i], num[ind] = maxi, num[i]
                break
        return int("".join(num))