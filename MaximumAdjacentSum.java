
public class MaximumAdjacentSum {
    
    //Wrong Approch
    static int FindMaxSum(int arr[], int n) {
        int incl=arr[0];
        int excl=0;
        int flag=0;
        int maxSum=0;
        for(int i=1;i<n;i+=2){
            if(flag==0){
                maxSum=Math.max(excl,arr[i]+incl);
                excl+=arr[i];
                flag=1;
            }
            else{
                maxSum=Math.max(excl+arr[i],incl);
                incl+=arr[i];
                flag=0; 
            }

        }
        return maxSum;

    }

    //Correct approch
    static int FindMaxSumCorrect(int arr[], int n) {
        int incl=arr[0];
        int excl=0;
        for(int i=1;i<arr.length;i++){
            int temp_incl=incl; 
            incl=excl+arr[i];//11 .. 10
            excl=Math.max(excl,temp_incl);//5 .. 11
            System.out.println("incl "+incl+"  excl  "+excl);
        }

        return Math.max(incl,excl);

    }
    public static void main(String[] args) {
        int arr[] = new int[]{-2,1,3,-4,5}; 
        System.out.println(FindMaxSum(arr, arr.length));
        System.out.println(FindMaxSumCorrect(arr, arr.length));
    }
}