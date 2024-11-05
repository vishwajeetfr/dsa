#
# @lc app=leetcode id=14 lang=python
#
# [14] Longest Common Prefix
#

# @lc code=start
# difficulty : Easy
# link : https://leetcode.com/problems/longest-common-prefix/
# related topics : String, Array, Two Pointers
class Solution(object):
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""

        prefix = strs[0]

        for string in strs[1:]:
            while not string.startswith(prefix):
                prefix = prefix[:-1]
                if not prefix:
                    return ""

        return prefix

        
# @lc code=end

# Explanation:
# Initial Check: If the input list strs is empty, return an empty string since there can't be any common prefix.

# Prefix Initialization: Start by assuming the first string is the longest common prefix.

# Iterate Through Strings: For each subsequent string, check if it starts with the current prefix.

# If not, reduce the prefix by removing the last character.
# Continue this until the string starts with the prefix or the prefix becomes empty.
# Return the Result: After checking all strings, return the longest common prefix found.



