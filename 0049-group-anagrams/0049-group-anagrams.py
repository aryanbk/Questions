class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp = collections.defaultdict(list)
        for i in range(len(strs)): mp["".join(sorted(strs[i]))].append(strs[i])
        return mp.values()