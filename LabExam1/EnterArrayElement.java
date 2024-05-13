package LabExam1;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class EnterArrayElement {

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
        EnterArrayElement(8);
    }
}
