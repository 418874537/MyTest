package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: mayingjie@sensorsdata.com
 * @Date: 2021/8/13
 */
public class FourSum {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int a = 0;a<nums.length;a++){
      if (a>0 && nums[a] == nums [a-1]){
        continue;
      }
      for (int d = nums.length-1 ;d> a+2; d--){
        if (d<nums.length-1 && nums[d] == nums [d+1]){
          continue;
        }
        Integer b = a+1;
        Integer c = d-1;
        while (b<c){
          Integer sum = nums[a] + nums[b] + nums[c] + nums[d] ;
          if (sum == target) {
            result.add(Arrays.asList( nums[a] , nums[b] , nums[c] , nums[d]));
            do{
              b++;
            }while (nums[b]==nums[b-1] && b<c);
            do{
              c--;
            }while (nums[c]==nums[c+1] && b<c);
          } else if (sum <target && b<c){
            b++;
          } else if (sum >target && b<c){
            c--;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));
//    List l1 = new ArrayList<Integer>();
  }
}
