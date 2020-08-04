package base;

import base.sort.compared.BubbleSort;
import base.sort.compared.QuickSort;

import java.util.Arrays;

/**
 * @Author: morris
 * @Date: 2020/7/28 12:08
 * @description
 * @reviewer
 */
public class BaseAlgorithmMain {
    public static void main(String[] args) {
        int[] ints = {12, 3, 1, 2, 9, 3, 4, 6};
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        int[] sort = new BubbleSort().sort(ints);
//        int[] sort = new SelectedSort().sort(ints);
//        int[] sort = new InsertionSort().sort(ints);
//        int[] sort = new ShellSort().sort(ints);
//        int[] sort = new MergeSort().sort(ints);
//        int[] sort = new QuickSort().sort(arr);

        System.out.println(Arrays.toString(sort));


    }


}
