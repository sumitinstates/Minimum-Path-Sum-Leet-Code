package com.sumit;

public class Solution {
	
	/*
	 * constraint is :
	 * 
	 * we can go either right or down
	 * 
	 * 
	 */
    public static int minPathSum(int[][] grid) {
        
        int rows = grid.length;
        int col = grid[0].length;
        
        if(rows==0) 
        {
        	return 0;
        }
        
        //creating dp array
        int dp[][] = new int[rows][col];
        
        //first index of dp array will be same as first index of grid array
        dp[0][0] = grid[0][0];
        
        //filling first row
        for(int i=1;i<col;i++)
        {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        
        //filling first column
        for(int i=1;i<rows;i++)
        {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        
        /*
         * filling remaining indexes of dp array. so according to constraint, lets say if 
         * we want to find element for dp[1][1], then we can reach dp[1][1] from either
         * top index , dp[0][1] as we can go DOWN from here, or left index of dp[1][1], 
         * which is dp[1][0] as we can go RIGHT from here.
         * 
        */
        for(int i = 1 ; i < rows; i++)
        {
            for(int j= 1; j<col;j++)
            {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[rows-1][col-1];
    }
    
    public static void main(String[] args) {
		
    	int[][] grid = {{1,3,1},
    			        {1,5,1},
    			        {4,2,1}};
    	
    	System.out.println(Solution.minPathSum(grid)); // output is 7. (1 -> 3 -> 1 -> 1 -> 1 = 7)
	}

}
