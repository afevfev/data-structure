package LabExam6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DeleteElement {
    static void deleteElement(int[] array, int index){
        if(index<0 | index>=array.length){
            System.out.println("Invalid index.");
        }
        for (int i=0;i<array.length;i++){
            if (index==i){
                if (i>index){
                    array[i]=array[i+1];
                    System.out.println(Arrays.toString(array));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array= {3,7,1,9,4};
        int index=2;
        DeleteElement.deleteElement(array,index);
    }
}
