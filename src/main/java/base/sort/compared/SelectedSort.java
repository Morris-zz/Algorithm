package base.sort.compared;

import base.BaseSortAlgorithm;

/**
 * @Author: morris
 * @Date: 2020/7/28 15:03
 * @description
 * 选择排序：表现最稳定的算法，无论什么数据都是O(n^2)，使用时数据量小为优
 * 不稳定算法
 * @reviewer
 */
public class SelectedSort extends BaseSortAlgorithm {
    @Override
    public int[] sort(int[] nums) {
        int minIdx ;
        int min ;
        for (int i = 0; i < nums.length; i++) {
            min = nums[i];
            minIdx = i;
            for (int j = i ; j < nums.length; j++) {
                if (min > nums[j]) {
                    minIdx = j;
                    min = nums[j];
                }
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
        }
        return nums;
    }
}
