package com.algorithm;

import java.util.Arrays;

public class Memo {

    public static void main(String[] args) {

        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;

        merge(nums1, m, nums2, n);
    }

    public static int[] sortedSquares(int[] nums) {
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int squaresNum = Math.abs(nums[i] * nums[i]);
            resultArr[i] = squaresNum;
        }

        Arrays.sort(resultArr);

        return resultArr;
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j >= i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            for (int i = m, j = 0; i < n+m; i++, j++) {
                nums1[i] = nums2[j];
            }
        }
        Arrays.sort(nums1);

        for (int nu : nums1) {
            System.out.println(nu);
        }
    }
}
