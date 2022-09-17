class Solution:
    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        
        days = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365]
        
        # day of year when alive arrive
        alcarr= int(arriveAlice[3:]) + days[ int(arriveAlice[:2]) - 1]
        
        # day of year when alive leave
        alclvv= int(leaveAlice[3:]) + days[ int(leaveAlice[:2]) - 1]
        
        # day of year when bob arrive
        bobarr= int(arriveBob[3:]) + days[ int(arriveBob[:2]) - 1]
        
        # day of year when bob leave
        boblvv= int(leaveBob[3:]) + days[ int(leaveBob[:2]) - 1]
        
        return max(0, min(alclvv, boblvv) - max(alcarr, bobarr) + 1)