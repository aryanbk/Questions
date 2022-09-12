class TimeMap:
​
def __init__(self):
self.dct={}
​
def set(self, key: str, value: str, timestamp: int) -> None:
print(1, self.dct)
if key in self.dct:
ind=self.floor(self.dct[key], timestamp)
if ind==len(self.dct[key]):
self.dct[key].append([timestamp, value])
else:
self.dct[key].insert(ind+1,[timestamp, value])
else:
self.dct[key]=[[timestamp, value]]
​
def get(self, key: str, timestamp: int) -> str:
print(2, self.dct)
if key in self.dct:
return self.dct[key][self.floor(self.dct[key], timestamp)][1]
else:
return ""
def floor(self, arr, t):
lo, hi, res = 0, len(arr)-1,0
while lo<=hi:
mid=(lo+hi)//2
if arr[mid][0]<=t:
res=mid
lo=mid+1
else:
hi=mid-1
return res