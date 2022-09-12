class TimeMap:

    def __init__(self):
        self.dct={}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key in self.dct:
            ind=self.__floor(self.dct[key], timestamp)
            self.dct[key].insert(ind+1,[timestamp, value])
        else:
            self.dct[key]=[ [0, ""], [timestamp, value] ]

    def get(self, key: str, timestamp: int) -> str:
        if key in self.dct:
            return self.dct[key][self.__floor(self.dct[key], timestamp)][1]
        return ""
    
    def __floor(self, arr, t):
        lo, hi, res = 0, len(arr)-1,0
        while lo<=hi:
            mid=(lo+hi)//2
            if arr[mid][0]<=t:
                res=mid
                lo=mid+1
            else:
                hi=mid-1
        return res

# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)