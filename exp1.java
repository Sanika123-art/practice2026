import java.util.Scanner;

public class exp1 
{

    static int solve(int n)
    {
        if(n==1)
        {
            return 1;
        }

        return 2*solve(n/2)+n;
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println("Total work done="+solve(n));
        System.out.println("time complexity is nlogn");
    }
    
}
