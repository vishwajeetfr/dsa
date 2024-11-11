/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int value = romanValues.get(s.charAt(i));
            if (i < n - 1 && value < romanValues.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        
        return result;
    }
}
// @lc code=end

// Explanation:
// Mapping Roman Numerals to Values:

// We use a HashMap to store the integer values of each Roman numeral character.
// Iterating Through the String:

// For each character, we check if the current numeral should be subtracted or added to the result.
// If a numeral with a smaller value comes before a numeral with a larger value, we subtract it (e.g., in "IV" for 4, "I" is subtracted).
// Otherwise, we add it to the result.
// Returning the Result:

// The result is updated as we move through the string and is returned at the end.
// This solution has a time complexity of 
// 𝑂
// (
// 𝑛
// )
// O(n) where 
// 𝑛
// n is the length of the Roman numeral string, making it efficient for this problem.








