/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
// Difficulty : Medium
// Related Topics : Backtracking, String, Hash Table
// Problem Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {

    public List<String> letterCombinations(String digits)
    {
        if(digits.length()==0) return new ArrayList<String>();
        HashMap<Character, ArrayList<Character>> digitMap = new HashMap<>();
        digitMap.put('2',new ArrayList<>(Arrays.asList('a','b','c')));
        digitMap.put('3',new ArrayList<>(Arrays.asList('d','e','f')));
        digitMap.put('4',new ArrayList<>(Arrays.asList('g','h','i')));
        digitMap.put('5',new ArrayList<>(Arrays.asList('j','k','l')));
        digitMap.put('6',new ArrayList<>(Arrays.asList('m','n','o')));
        digitMap.put('7',new ArrayList<>(Arrays.asList('p','q','r','s')));
        digitMap.put('8',new ArrayList<>(Arrays.asList('t','u','v')));
        digitMap.put('9',new ArrayList<>(Arrays.asList('w','x','y','z')));

        return getLetterCombinations(digitMap,digits, 0, "",new ArrayList<String>());

    }

    public ArrayList<String> getLetterCombinations(HashMap<Character, ArrayList<Character>> digitMap,String digits, int index, String comb,ArrayList<String> sol)
    {
        if(index == digits.length())
        {
            sol.add(comb);
            return sol;
        }
        
       Character current =  digits.charAt(index);
       ArrayList<Character> charList = digitMap.get(current);

       for(char c : charList)
       {
           getLetterCombinations(digitMap,digits, index+1, comb+c,sol);
           
       }

       return sol;
    }
}
// @lc code=end

