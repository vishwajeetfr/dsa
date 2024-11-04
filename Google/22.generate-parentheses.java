/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
// Difficulty : Medium
// Related Topics : Backtracking
// Problem Link : https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) 
    {
       return parentheses(1,0,n,"(",new ArrayList<String>());
    }

    public static List<String> parentheses(int open, int close,int n,String str, ArrayList<String> list)
    {
        if (open > n || close > n) {
            return list;
        }
        if(close == n && open == n)
        {
            list.add(str);
            return list;
        }
        parentheses(open+1, close , n, str+"(", list);
        if(open > close) {
            return parentheses(open, close + 1, n, str + ")", list);
        }
        return list;
    }
}

