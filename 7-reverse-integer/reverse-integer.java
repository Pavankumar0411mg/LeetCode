class Solution {
    public int reverse(int x) {
        int reversed = 0;
        
        // Define the 32-bit integer limits for clarity
        // Integer.MAX_VALUE = 2147483647
        // Integer.MIN_VALUE = -2147483648

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // 1. OVERFLOW CHECK: Positive Case
            // If reversed > INT_MAX / 10 (214748364), multiplying by 10 will overflow.
            if (reversed > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // Boundary Case: reversed equals INT_MAX / 10, but the last digit (pop) 
            // causes overflow (e.g., reversed=214748364 and pop=8 or 9)
            if (reversed == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }

            // 2. OVERFLOW CHECK: Negative Case
            // If reversed < INT_MIN / 10 (-214748364), multiplying by 10 will overflow.
            if (reversed < Integer.MIN_VALUE / 10) {
                return 0;
            }
            // Boundary Case: reversed equals INT_MIN / 10, but the last digit (pop) 
            // causes overflow (e.g., reversed=-214748364 and pop=-9)
            if (reversed == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }

            // 3. Update the reversed number (Push)
            reversed = reversed * 10 + pop;
        }

        return reversed;
    }
}