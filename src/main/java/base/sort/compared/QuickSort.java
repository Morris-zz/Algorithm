package base.sort.compared;

import base.BaseSortAlgorithm;


/**
 * @Author: morris
 * @Date: 2020/7/29 10:00
 * @description
 * @reviewer
 */
public class QuickSort extends BaseSortAlgorithm {
    @Override
    public int[] sort(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);

    }

    public int[] quickSort(int[] nums, int left, int right) {
        if (right > left) {
            int temp = qSort(nums, left, right);
            quickSort(nums, left, temp - 1);
            quickSort(nums, temp + 1, right);
        }
        return nums;

    }

    private int qSort(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            //find the index where right.v < temp ,change place between right and left
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= temp) {
                left++;
            }
            //from left to right ，find the v < temp
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        //assign the final right value
        nums[right] = temp;
        return right;

    }
}
