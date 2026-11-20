public class quicksort 
{

    public static void main(String args[])
    {

        int[] arr={20,40,60,10};

        quicksort1(arr,0,arr.length-1);

        for(int num:arr)
        {
            System.out.println("Element are="+num);
        }
    }

    private static void quicksort1(int[] arr, int low, int high) 
    {

       

        if(low<high)
        {
             int pi=partition(arr,low,high);
            quicksort1(arr, low, pi-1 );
            quicksort1(arr, pi+1, high );

        }
      
    }
    private static int partition(int[] arr, int low, int high) 
    {
        int pivot=arr[high];
        int i=low-1;

        for(int j=low;j<arr.length;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }


        }

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }
    
}
