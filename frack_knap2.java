public class frack_knap2 
{

    public static void main(String[] args) {
        
        int[] w={1,3,4,5};
        int[] p={1,4,5,6};
        int cap=7;
        int n=4;

        int[][] dp=new int[n+1][cap+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=cap;j++)
            {
                if(w[i-1]<=j)
                {
                    dp[i][j]=Math.max(p[i-1]+dp[i-1][j-w[i-1]],dp[i-1][j]);
                }
                else{

                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println("maximum profit="+dp[n][cap]);
    }
    
}
