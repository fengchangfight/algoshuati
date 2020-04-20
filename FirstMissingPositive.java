package com.example.demo.leetcode;

import java.util.BitSet;

/**
 * leetcode 41
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        BitSet bs = new BitSet();

        int maxBit = 0;
        for(int i=0;i<nums.length;i++){
            // if its positive intege
            if(nums[i]>0 && nums[i]<=nums.length){
                bs.set(nums[i]);
                if(maxBit<nums[i]){
                    maxBit = nums[i];
                }
            }
        }

        for(int j = 1 ;j<=nums.length;j++){
            if(!bs.get(j)){
                return j;
            }
        }
        return nums.length+1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        System.out.println(firstMissingPositive(nums));
    }
}

