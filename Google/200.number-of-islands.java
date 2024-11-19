/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 * 
 * problem link : https://leetcode.com/problems/number-of-islands/
 * difficulty : Medium
 * topics : Depth-First Search, Breadth-First Search, Union Find, Graph
 */

// @lc code=start
class Solution 
{
    public int numIslands(char[][] grid) 
    {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    islands += 1;
                    getIsland(i, j, grid, visited);
                }
            }
        }

        return islands;
    }

    private void getIsland(int i, int j, char[][] grid, int[][] visited) 
    {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check bounds and if already visited or water
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0' || visited[i][j] == 1) {
            return;
        }

        // Mark as visited
        visited[i][j] = 1;

        // Traverse all 4 directions
        getIsland(i - 1, j, grid, visited); // up
        getIsland(i + 1, j, grid, visited); // down
        getIsland(i, j - 1, grid, visited); // left
        getIsland(i, j + 1, grid, visited); // right
    }
}

// @lc code=end

// Explanation of Fixes:
// islands Initialization:

// Changed islands to start at 0.
// Edge Case Handling:

// Ensured the grid is not null or empty.
// Traversal Fix:

// Corrected visited[1][j+1] to visited[i][j+1].
// Full Traversal:

// Added upward (i-1) and leftward (j-1) traversal to getIsland.
// Avoided Redundant Initialization:

// Removed explicit initialization of visited since the default values are 0.