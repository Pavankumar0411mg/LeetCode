class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        product = 1
        zero_count = 0
        
        # 1. Calculate product of NON-ZERO numbers, and count zeros
        for i in nums:
            if i == 0:
                zero_count += 1
            else:
                product *= i
        
        arr = []
        # 2. Safely apply division logic based on zero count
        for i in nums:
            if zero_count > 1:
                arr.append(0)
            elif zero_count == 1:
                # If there's 1 zero, only the zero position gets the product
                arr.append(product if i == 0 else 0)
            else:
                # Standard case (no zeros), divide product by the number
                arr.append(product // i)
                
        return arr
