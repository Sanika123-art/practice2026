class jobsequen
{
    public static void main(String[] args) {
        
        int[] p={100,27,25,19};
        int[] d={2,1,2,1};
        int n=4;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(p[i]<p[j])
                    {
                          int temp=p[i];
                          p[i]=p[j];
                          p[j]=temp;

                          int t=d[i];
                          d[i]=d[j];
                          d[j]=t;
                    }
                
            }
        }

        int max=0;

        for(int x:d)
        {
            if(x>max)
            {
                max=x;
            }
        }

        int[] slot=new int[max+1];
        int total=0;

        for(int i=0;i<n;i++)
        {
            for(int j=d[i];j>=1;j--)
            {
                if(slot[j]==0)
                {
                    slot[j]=p[i];
                     total=total+p[i];
                     break;
                }
            }
        }

        System.out.println("maximum profit="+total);
    }
}