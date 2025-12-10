import java.util.*;
public class Rod_Cutting{
	int rod_cut(int[] nums,int l, int n,int cut,int[][] dp){
		if(n>=nums.length || cut==l)
			return 0;
		if(dp[n][cut]!=-1)
			return dp[n][cut];
		int pick = 0;
		if(cut + n+1<=l){
			pick = rod_cut(nums,l,n,cut + n+1,dp) + nums[n];
		}
		int not_pick = rod_cut(nums,l,n+1,cut,dp);
		dp[n][cut] = Math.max(pick,not_pick);
		return dp[n][cut];
	}

	public static void main(String[] args) {
		int[] arr = {1, 5, 8, 9};
		int  l = 4;
		int[][] dp = new int[arr.length+1][l+1];

		for(int[] r: dp)
			Arrays.fill(r,-1);

		Rod_Cutting s = new Rod_Cutting();
		System.out.println(s.rod_cut(arr,l,0,0,dp));
	}
}
