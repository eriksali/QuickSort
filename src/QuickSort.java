/**
 * https://github.com/eugenp/tutorials/tree/master/algorithms-modules/algorithms-sorting
 * https://sites.math.rutgers.edu/~ajl213/CLRS/CLRS.html
 * https://www.baeldung.com/java-quicksort
 * https://www.geeksforgeeks.org/quick-sort/
 * https://www.geeksforgeeks.org/in-place-algorithm/
 */

import java.util.Random;
import java.util.Arrays;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class QuickSort {
    public static void main(String [] args){
        Random g = new Random();
        int [] number = new int [10];
        FileWriter myWriter;
        System.out.println();


        try {
            myWriter = new FileWriter("random-integers.txt");    

            for (int d = 0 ; d<number.length ; d++){
                number[d] = g.nextInt(100) + 1;

                try {
                    //myWriter.write("\r\n");
                    myWriter.write(new Integer(number[d]).toString());  
                    myWriter.write("\r\n");
                    System.out.println(number[d]);

                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
            }
            
            myWriter.close();

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.print("\nUnsorted Numbers:" + Arrays.toString(number));
        //System.out.print("\nSorted Numbers:  " + Arrays.toString(mergeSort(number,number.length));
        
        quickSort(number, 0, 9);

        System.out.print("\nSorted Numbers:  [");
        for(int i = 0; i < number.length; ++i){
            if(i < number.length - 1)
                System.out.print(number[i]+ ", ");
            else
                System.out.print(number[i]);
        }

        System.out.print("]\n");

    }


    static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
    
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }


    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
    
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
    
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
    
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
    
        return i + 1;
    }

}

/*
 *     public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
    
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        merge(a, l, r, mid, n - mid);
    } 

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
 */





    /**
     * 
     * @param left_arr
     * @param right_arr
     * @param arr
     * @param left_size
     * @param right_size
     * 
     * public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){
        
        int i=0,l=0,r = 0;
        //The while loops check the conditions for merging
        while(l<left_size && r<right_size){
            
            if(left_arr[l]<right_arr[r]){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
          arr[i++] = right_arr[r++];
        }
    }
  
    public static void mergeSort(int [] arr, int len){
        if (len < 2){return;}
        
        int mid = len / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[len-mid];
        
      //Dividing array into two and copying into two separate arrays
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k = k+1;
            }
        }
      // Recursively calling the function to divide the subarrays further
        mergeSort(left_arr,mid);
        mergeSort(right_arr,len-mid);
      // Calling the merge method on each subdivision
        merge(left_arr,right_arr,arr,mid,len-mid);
    }
  */
    /** 
     * 
     *     public static void main( String args[] ) {
          int [] array = {12,1,10,50,5,15,45};
          mergeSort(array,array.length);
          for(int i =0; i< array.length;++i){
              System.out.print(array[i]+ " ");
          }
      }
    */
    
    

 