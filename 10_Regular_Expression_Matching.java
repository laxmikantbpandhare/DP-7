    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/edit-distance/
    Time Complexity for operators : o(n*m) .. 
    Extra Space Complexity for operators : o(n*m) .. size of matrix
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */  

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length() + 1;
        int m = p.length() + 1;
        
        boolean[][] dp = new boolean[n][m];// initialized everything in matrix as False
        
        dp[0][0] = true;
        //populate row
        
        for(int j = 1;j < m;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        
        // no need to do for column as it is already false.
        
        
        // now dp
        for(int i = 1;i < n;i++){
            for(int j = 1;j<m;j++){
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    
                    //extra checks
                    
                    if(p.charAt(j-2) == s.charAt(i-1)  || p.charAt(j-2) == '.'){
                        if(dp[i-1][j]){
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}