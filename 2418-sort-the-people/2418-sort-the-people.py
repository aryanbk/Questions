class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        arr=[]
        for i in range(len(names)):
            arr.append([heights[i], names[i]])
        return [i[1] for i in sorted(arr, reverse=True)]
        # arr.sort(reverse=True)
        # return [i[1] for i in arr]
        