import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Converts a string into a zigzag pattern across a given number of rows.
     * * @param s The input string.
     * @param numRows The number of rows for the zigzag pattern.
     * @return The converted string, read row by row.
     */
    public String convert(String s, int numRows) {
        // Handle the edge cases where zigzag conversion is trivial
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // 1. Initialize Row Buffers
        // We need a list of StringBuilder objects, one for each row.
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        // Direction variable: 1 means moving down, -1 means moving up
        int direction = 1; 

        // 2. Simulate the Zigzag Movement
        for (char c : s.toCharArray()) {
            // Append the current character to the current row's buffer
            rows.get(currentRow).append(c);

            // Check if we hit the boundary (top or bottom row)
            if (currentRow == 0) {
                // If at the top row (0), change direction to DOWN (1)
                direction = 1;
            } else if (currentRow == numRows - 1) {
                // If at the bottom row, change direction to UP (-1)
                direction = -1;
            }

            // Move the pointer to the next row based on the current direction
            currentRow += direction;
        }

        // 3. Concatenate the Rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}