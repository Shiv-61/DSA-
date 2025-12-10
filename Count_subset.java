class Solution {
    int func(int[] arr, int k, int n,int curr){
        if(k==curr)
            return 1;
       	if(n>=arr.length)
       		return 0;
        int pick = func(arr,k,n+1,curr+arr[n]);
        int notpick = func(arr,k,n+1,curr);
        System.out.println("notpick: "+notpick+" pick : "+ pick);
        return notpick+pick;
    }
    public int perfectSum(int[] arr, int k) {
        return func(arr,k,0,0);
    }
}
public class Count_subset{
	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 16, 8, 10}; 
		int k = 10;
		Solution s= new Solution();
		System.out.println(s.perfectSum(arr,k));		
	}
}