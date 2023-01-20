class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        val = (digits[-1]+1)%10
        carry = (digits[-1]+1)//10
        digits[-1]=val
        i=len(digits)-2
        while i>=0 and carry!=0:
            digits[i] += carry
            carry = digits[i]//10
            digits[i] %= 10
            i-=1
        if carry:
            digits.insert(0, carry)
        return digits