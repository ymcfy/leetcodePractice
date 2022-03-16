package com.ym.no278firstbadversion;

/**
 * @author ym
 * @create 2022-03-01 22:40
 * @description
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {//返回true   ---   right = mid  左半部分
                right = mid;
            } else {                //返回false  ---   left = mid+1 右半部分
                left = mid + 1;
            }
        }
        return left;


//        //左边界
//        int left = 1;
//        //右边界
//        int right = n;
//        while(left<=right){
//            int mid = left+(right-left)/2;
//            if(isBadVersion(mid)&&isBadVersion(mid-1)){
//                //往前找
//                right=mid-1;
//            }else if(!isBadVersion(mid)&&!isBadVersion(mid-1)) {
//                //往后走
//                left=mid+1;
//            }else if(isBadVersion(mid)&&!isBadVersion(mid-1)){
//                return mid;
//            }
//        }
//        return -1;
    }
}
