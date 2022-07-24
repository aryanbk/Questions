class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i,j = 0, len(matrix[0])-1
        while i<len(matrix) and j>=0 and matrix[i][j]!=target:
            if target>matrix[i][j]:
                i+=1
            else:
                j-=1
        return False if (i>=len(matrix) or j<0) else True
        