class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        
        def get_avg(i, j):
            sumt = 0
            cnt = 0
            for x in range(max(i-1, 0), min(i+2, m)):
                for y in range(max(j-1, 0), min(j+2, n)):
                    sumt += img[x][y]
                    cnt += 1
            return math.floor(sumt/cnt)
        
        
        
        m = len(img)
        n = len(img[0])
        
        return [[get_avg(i, j) for j in range(n)] for i in range(m)]