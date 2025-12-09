    import java.util.*;
    class Solution {
        int func(int[] wt, int[] val, int n, int W,int curr_wt,int curr_val,int[][] dp){
            if(n>= wt.length || curr_wt >W)
                return 0;
            if(dp[n][curr_wt]!=-1)
                    return dp[n][curr_wt];
            if(wt[n]>W)
               return func(wt,val,n+1,W,curr_wt,curr_val,dp);

               int pick = 0;
               if (curr_wt + wt[n] <= W) {
                System.out.println("For Pick : curr_wt = "+curr_wt+" curr_val = "+curr_val);
                pick = val[n] + func(wt, val, n,W,curr_wt + wt[n], curr_val,dp);
                }

               int not_pick = func(wt,val,n+1,W,curr_wt,curr_val,dp);
            dp[n][curr_wt] = Math.max(pick,not_pick);
            return dp[n][curr_wt];
        }
        public int unboundedKnapsack(int[] wt, int[] val, int n, int W,int[][] dp) {
            return func(wt,val,0,W,0,0,dp);
        }
    }
    public class UnboundedKnapsack{
        public static void main(String[] args) {
            int[] wt = new int[]{2,4,6};
            int[] val = new int[]{5,11,13}; 

            int[][] dp = new int[3][11];
            for(int[] r : dp)
                Arrays.fill(r,-1);

            Solution s = new Solution();
            s.unboundedKnapsack(wt,val,wt.length,10,dp);
            System.out.println(dp[0][0]);
        }
    }