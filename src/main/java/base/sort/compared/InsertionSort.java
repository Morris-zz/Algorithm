package base.sort.compared;

import base.BaseSortAlgorithm;

/**
 * @Author: morris
 * @Date: 2020/7/28 15:22
 * @description
 * insert sort : every time get i+1 index ,then find the right place in 0~i int[] back to front
 * time complexity O(n^2)
 * stable algorithm
 * @reviewer
 */
public class InsertionSort extends BaseSortAlgorithm {
    @Override
    public int[] sort(int[] nums) {
        int target,idx;
        //already sort index in for
        for (int i = 0; i < nums.length - 1; i++) {
//            target = nums[i + 1];
            idx = i + 1;
            //back to front
            for (int j = i; j >= 0; j--) {
                if (nums[idx] < nums[j]){
                    //every time change place
                    int temp = nums[j];
                    nums[j] = nums[idx];
                    nums[idx] = temp;
                    //change idx
                    idx = j;
                }

            }
        }
        return nums;
    }
}
