import java.util.Scanner;

public class Exp2 
{
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a");
        int a=sc.nextInt();
        System.out.println("Enter b");
        int b=sc.nextInt();
        System.out.println("Enter k");
        int k=sc.nextInt();

        double p=Math.log(a)/Math.log(b);

        if(p>k)
        {
            System.out.println("case 1:o(n^"+p+")");
        }
        else if(p==k)
        {
            System.out.println("case 2:o(n^"+k+"log n)");
        }
        else
        {
            System.out.println("case 3:o(n^"+k+")");
        }

    }
    
}
