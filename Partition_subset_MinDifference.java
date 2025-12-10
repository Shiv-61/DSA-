import java.util.*;
public class Partition_subset_MinDifference{
    static boolean[][] dp;

    static void func(int[] arr, int k){
        for(int idx = 1;idx<arr.length;idx++){
            for(int j =1;j<=k;j++){
                boolean nottake = dp[idx -1][j];
                boolean take= false;
                if(arr[idx]<=j)
                    take = dp[idx-1][j - arr[idx]];
                dp[idx][j] = take | nottake;
            }
        }
    }

	public static void main(String[] args) {
		int[] arr = {3, 1, 6, 2, 2}; 
		int k = Arrays.stream(arr).sum();
        dp =  new boolean[arr.length][k+1];

        for(int i = 0;i<arr.length;i++)
            dp[i][0] = true;

        dp[0][arr[0]] = true;
		func(arr,k);		

        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<=k;i++){
            if(dp[arr.length-1][i]){
                int sub2 = k - i;
                ans = Math.min(Math.abs(sub2 - i),ans);
            }
        }

        System.out.println(ans);
	}
}