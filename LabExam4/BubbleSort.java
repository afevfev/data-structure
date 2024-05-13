package LabExam4;

import java.util.Arrays;

public class BubbleSort {

    static void bubbleSorting(char[] array){
        int n=array.length;
        for(int j=0; j < n-1; j++){
            for (int i=0; i< n-1; i++){   //for (int i=0; i< array.length-1 - j; i++){
                if ( (array[i]) > (array[i+1])){
                    char temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }
    public static void main(String[] args) {
        char[] array={'d','g','y','r','a'};
        bubbleSorting(array);
    }
}
