public class mergeso 
{

    public static void main(String args[])
    {
        int[] arr={20,30,40,10};

        System.out.println("Beefor sort");

        for(int num:arr)
        {
            System.out.println(num);

        }
       mergesort(arr,0,arr.length-1);
        System.out.println("after sort");
        for(int num:arr)
        {
            System.out.println(num);

        }
    }

   static void mergesort(int[] arr,int l,int r)
    {
        if(l<r)
        {
            int mid=(l+r)/2;
            mergesort(arr,l,mid);
            mergesort(arr,mid+1,r);

            merge(arr,l,mid,r);
        }
    }

     private static void merge(int[] arr,int l,int mid,int r)
    {
        int num1=mid-l+1;
        int num2=r-mid;

        int[] larr=new int[num1];
        int[] rarr=new int[num2];

        for(int x=0;x<num1;x++)
        {
           larr[x]=arr[l+x];

        }
         for(int x=0;x<num2;x++)
        {
           rarr[x]=arr[mid+1+x]; 
        }

        int i=0;
        int j=0;
        int k=l;

        while(i<num1 && j<num2)
        {
            if(larr[i]<rarr[j])
            {
                arr[k]=larr[i];
                i++;
                
            }

            else
            {
                arr[k]=rarr[j];
                j++;
            }

            k++;
        }

        while(i<num1)
        {
            arr[k]=larr[i];
            i++;
            k++;
                }

                while(j<num2)
        {
            arr[k]=rarr[j];
            j++;
            k++;
                }

    }
    
}
