public class LinearBinarySearch {

    //The linearSearch finds the index of the target in an integer array

    public static int LinearSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] ==target){
                return i;
            }
        }
        return -1;
    }
    //BINARY SEARCH ASSUMING THE ARRAY IS SORTED, FINDING THE INDEX OF THE TARGET NUMBER
    public static int binarysearch(int[] arr, int target){
        int low = 0, high = arr.length -1;

        while (low <= high){
            int mid = (low +high)/2;
                if (arr[mid]==target){
                    return mid;
                }
                else if (arr[mid]<target){
                    low = mid +1;

        } else {
                high = mid -1;
            }
    }
        return -1;
}
public static void main(String[]args){
        int [] arr ={1,1};
        int target =5;
        int LinearResult = LinearSearch(arr,target);
        int BinaryResult = binarysearch(arr,target);
    System.out.println("linear search result: "+ LinearResult);
    System.out.println("binary search result: "+ BinaryResult);
    }
}
