package base.sort.compared;

import base.BaseSortAlgorithm;

/**
 * @Author: morris
 * @Date: 2020/7/28 12:13
 * @description
 * @reviewer
 */
public class BubbleSort extends BaseSortAlgorithm {

    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length  -1 -i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
