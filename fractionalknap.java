import java.util.Scanner;

public class fractionalknap 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter item");
        int n=sc.nextInt();
        double[] ratio=new double[n];
        int[] p=new int[n];
        int[] wt=new int[n];

        for(int i=0;i<n;i++)
        {
            p[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            wt[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++)
        {
            ratio[i]=(double)p[i]/wt[i];
        }

        System.out.println("Enter capacity");
        int cap=sc.nextInt();
       
        
         
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
               if(ratio[j]>ratio[i])
               {
                  double temp=ratio[j];
                  ratio[j]=ratio[i];
                  ratio[i]=temp;

                  int t=p[j];
                  p[j]=p[i];
                  p[i]=t;

                  int s=wt[j];
                  wt[j]=wt[i];
                  wt[i]=s;

               }
            }
        }

        double profit=0;

        for(int i=0;i<n;i++)
        
            {
                if(cap>=wt[i])
                {
                    profit=profit+p[i];
                    cap=cap-wt[i];


                }

                else{

                    profit=profit+ratio[i]*cap;
                }
            }

            System.out.println("maximum profit="+profit);
        


        
    }
    
}
