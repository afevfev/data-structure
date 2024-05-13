package LabExam5;

import java.util.Arrays;
import java.util.Scanner;

public class MeargeSort {
    private static void mergeSort(int[] array){
        int length =array.length;
        if (length<=1) return; // base case
        int middle= length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];
        int i = 0;//left array
        int j = 0;//right array
        for (; i< length; i++){
            if (i < middle){
                leftArray[i] = array[i];
            }else{
                rightArray[j]=array[i];
                j++;
            }
            mergeSort(leftArray);
            mergeSort(rightArray);
            merge(leftArray, rightArray, array);
        }
    }
    private static void merge(int[] leftArray,int[] rightArray, int[] array){
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;//indices
        //check the conditions for merging
        while(l < leftSize && r < rightSize){
            if (leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }else{array[i] = rightArray[r];
                i++;
                l++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
        Scanner n = new Scanner(System.in);
        static void EnterArrayElement(int n) {
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < n; i++) {
                System.out.println();
                input.nextLine();
                int[] array = new int[n];
                for (Scanner it = input; it.hasNext(); ) {
                    array[it] = i;
                }
                System.out.println(Arrays.toString(array));
            }
        }

        public static void main(String[] args) {
            merge(EnterArrayElement.array);
        }
    }


}

