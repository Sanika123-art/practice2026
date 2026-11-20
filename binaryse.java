import java.util.Scanner;

public class binaryse 
{
    public static void main(String[] args) 
    {
         Scanner sc = new Scanner(System.in);
        
         System.out.println("Enter element size");
         int n=sc.nextInt();

         int[] arr=new int[n];
         for(int i=0;i<n;i++)
         {
            arr[i]=sc.nextInt();

         }

        System.out.println("Enter key search");
        int key=sc.nextInt();

        int low=0;
        int high=n-1;
        int mid;
        int found=-1;

        while(low<=high)
        {

        

        mid=(low+high)/2;

        if(arr[mid]==key)
        {
            found=mid;
            break;
        }
        else if(arr[mid]>key)
        {
           high=mid-1;

        }

        else
        {
            low=mid+1;
        }

    }

    if(found!=-1)
    {
        System.out.println("element found="+(found+1));
    }
    else
    {
        System.out.println("element not found=");
    }


        
    }
    
}
