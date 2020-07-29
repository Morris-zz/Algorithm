package base.sort.compared;

import base.BaseSortAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: morris
 * @Date: 2020/7/28 17:04
 * @description
 * @reviewer
 */
public class MergeSort extends BaseSortAlgorithm {
    @Override
    public int[] sort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int[] left = new int[nums.length / 2];
        int[] right = new int[nums.length / 2 + (nums.length % 2)];
        //split int[] to n/2 then merge
        for (int i = 0; i < nums.length / 2; i++) {
            left[i] = nums[i];
        }
        for (int i = nums.length / 2, j = 0; i < nums.length; i++, j++) {
            right[j] = nums[i];
        }
        //Recursion
        left = sort(left);
        right = sort(right);
        int[] merge = new int[left.length + right.length];
        int j = 0, r = 0, m = 0;
        for (int i = 0; i < merge.length && j < left.length && r < right.length; i++) {
            if (left[j] <= right[r]) {
                merge[i] = left[j];
                j++;
            } else {
                merge[i] = right[r];
                r++;
            }
            m++;
        }
        //尾合并
        if (left.length != j) {
            addAll(merge, left, m, j);
        } else if (right.length != r) {
            addAll(merge, right, m, r);
        }
        return merge;

    }

    private void addAll(int[] merge, int[] left, int m, int j) {
        for (int i = j; i < left.length; i++, m++) {
            merge[m] = left[i];

        }
    }

    public int[] sort2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int[] a = new int[10];
        Object[] objects = sortByArrayList(list).toArray();
        return null;
    }

    public List<Integer> sortByArrayList(List<Integer> nums) {
        if (nums.size() == 1) {
            return nums;
        }
        //split list
        int length = nums.size() / 2;
        List<Integer> left = nums.subList(0, length);
        List<Integer> right = nums.subList(length, nums.size());
        left = sortByArrayList(left);
        right = sortByArrayList(left);
        //merge
        ArrayList<Integer> mergeList = new ArrayList<>();
        int l = 0;
        int r = 0;
        while(l < left.size() && r < right.size()) {
            if (left.get(l) > right.get(r)){
                mergeList.add(right.get(r));
                r++;
            }else {
                mergeList.add(left.get(l));
                l++;
            }
        }

        return null;
    }
}
