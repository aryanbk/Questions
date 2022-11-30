class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        a = Counter(arr).values()
        return len(a)==len(set(a))