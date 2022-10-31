class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        m, n = len(matrix), len(matrix[0])
        
        for row in range(1, m):
            for col in range(1, n):
                if matrix[row][col] != matrix[row-1][col-1]:
                    return False
        
        return True