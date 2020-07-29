package base.sort.compared;

import base.BaseSortAlgorithm;

/**
 * @Author: morris
 * @Date: 2020/7/28 16:03
 * @description O(n^(1.3~2)) related to incremental sequence
 * @reviewer
 */
public class ShellSort extends BaseSortAlgorithm {
    @Override
    public int[] sort(int[] nums) {
        // definition gap is int[].length / 2 to 1
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            //definition begin to avoid arrayOutOfBounds
            for (int i = gap; i < nums.length; i++) {
                insertSort(gap, nums, i);
            }
        }
        return nums;
    }

    private void insertSort(int gap, int[] nums, int i) {
        for (int j = i - gap; j >= 0 && nums[j] > nums[j + gap]; j -= gap) {
            int temp = nums[j];
            nums[j] = nums[j + gap];
            nums[j + gap] = temp;
        }
    }
}
