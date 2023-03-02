class Solution:
    def compress(self, chars: List[str]) -> int:
        idx, pos = 0, 0
        while idx<len(chars):
            temp = idx
            while temp<len(chars) and chars[temp] == chars[idx]:
                temp+=1
            chars[pos] = chars[idx]
            pos += 1
            if temp != idx+1:
                for c in str(temp-idx):
                    chars[pos] = c
                    pos += 1
            idx = temp
        return pos