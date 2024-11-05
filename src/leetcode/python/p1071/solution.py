"""
https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
"""
class Solution:
    """
    String
    - Time: O(n^2)
    - Space: O(n)
    """
    def gcdOfStrings(self, a: str, b: str) -> str:
        ret= ""
        for i, _ in enumerate(a):
            if i < len(b) and a[i] == b[i]:
                cand= a[:i+1]
                divisible_a= self.divisible(a, cand)
                divisible_b= self.divisible(b, cand)
                if divisible_a and divisible_b:
                    ret= cand
        return ret
    
    def divisible(self, a: str, b: str) -> bool:
        temp= b
        while len(temp) < len(a):
            temp= temp + b
        return temp == a
