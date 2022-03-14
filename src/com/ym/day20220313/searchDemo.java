package com.ym.day20220313;

/**
 * @author ym
 * @create 2022-03-13 17:48
 * @description
 */
public class searchDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        new searchDemo().search(arr,2);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle=0;
        while(left<=right){
            middle = left+(right-left)/2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle] > target){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return right+1;
    }
}
