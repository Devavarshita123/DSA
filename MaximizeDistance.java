import java.util.*;//So that we can use math clss
class MaximizeDistance
{
    //boolean function to check if there exists k number of values in the array with minimum distancce between the elements as mid
    public static boolean feasible(int[] arr,int n,int k,int mid)
    {
        int pos= arr[0];
        int element = 1;//certainly one value will exists, if taken first and last so element initialised with 1.
        for(int i=1;i<n;i++)
        {
            if(arr[i]-pos>=mid)
            {
                element++;
                pos = arr[i];
                if(element==k)
                {
                    return true;
                }
            }
        }
        return false;
    
    }
    public static int largestMinimumDistance(int[] arr,int n,int k)
    {
        int result = -1;
        int left = 1;
        int right = arr[n-1];
        while(left<right)
        {
            // we can also check it using two for loops but this method is more efficient
            int mid = left+(right-left)/2;
            //feasible in the sense that we can find k elements in the array such that the minimum diatnce between them is mid
            if(feasible(arr,n,k,mid))
            {
                result = Math.max(result,mid);
                //if feasible then we will increment it slowly
                //we will check for the next mid
                left = mid+1;
            }
            else
            {
                // if not feasible then we will reduce the value 
                //of getting the mid so that there exists a value with that distance
                right = mid;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        //Example usage
        int[] arr={1,2,24,5,7,18,11,12};   
        Arrays.sort(arr);
        //Sorting the array is important for the binary search to work correctly
        //The array should be sorted in ascending order
        //The function will return the maximum minimum distance between k elements
        int ans = largestMinimumDistance(arr,arr.length,3);
        System.out.println(ans);
    }
}
