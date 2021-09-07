package review.d0905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 18. 四数之和
 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：

 0 <= a, b, c, d < n
 a、b、c 和 d 互不相同
 nums[a] + nums[b] + nums[c] + nums[d] == target
 你可以按 任意顺序 返回答案 。

 示例 1：

 输入：nums = [1,0,-1,0,-2,2], target = 0
 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 示例 2：

 输入：nums = [2,2,2,2,2], target = 8
 输出：[[2,2,2,2]]


 提示：

 1 <= nums.length <= 200
 -109 <= nums[i] <= 109
 -109 <= target <= 109
 */
public class FourSum {
  //双指针:前两个数通过两层for循环来处理
  //去重: i,j:下一个和当前相同,移动到下一个.(不能这样去重,这样处理的是后面的那个数字->应该先处理前面的,遇到后面重复的再跳过)

  //去重: left,right:下一个和当前相同,移动到下一个.(注意要已经移动一个之后(必做的步骤)再做)->(不能这样去重,这样处理的是后面的那个数字->应该先处理前面的,遇到后面重复的再跳过)
  //* 不是等于的情况下 不用去重
  //减枝: i,j:和如果大于target/2 ,那组合不可能存在(因为之后的数字会更大)
  //-5,-5,-4,-3,-2,-2,0,2,4
  public static List<List<Integer>> fourSum2(int[] nums, int target) {
    Arrays.sort(nums);
    for (int num : nums) {
      System.out.print(num+",");
    }
    System.out.println();
    LinkedList<List<Integer>> ret = new LinkedList<>();
    for(int i = 0; i < nums.length - 3;i++){
      if(i > 0 && nums[i-1] == nums[i] ){
        continue;
      }
      for (int j = i+1;j<nums.length - 2 ;j++){
        int sumOfij = nums[i] + nums[j];
        if(sumOfij > target/2){
          break;
        }
        if(j > i+1 && nums[j-1] == nums[j]){
          continue;
        }
        int left = j+1;
        int right = nums.length-1;
        int targetSum = target - sumOfij;
        //指针和<目标 ,需要增大,left右移
        while(left < right){

          int sum = nums[left] + nums[right];
          if(nums[i] == -7 && nums[j] == -3){
            System.out.println("targetSum:"+targetSum);
            System.out.println("sum:"+sum);
            System.out.println("left,right:"+nums[left]+ " "+nums[right]);
          }

          if(sum < targetSum){
            left++;
//            while(left < right-1 && nums[left-1] == nums[left]){
//              left++;
//            }
          }else if(sum > targetSum){
            right--;
//            while(left < right-1 && nums[right+1] == nums[right]){
//              right--;
//            }
          }else {
            ret.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
            left++;
            while(left < right-1 && nums[left-1] == nums[left]){
              left++;
            }
            right--;
            while(left < right-1 && nums[right+1] == nums[right]){
              right--;
            }
          }
        }
//        System.out.println("--------------");
      }
    }
    return ret;
  }
  //回溯: 在连续重复的判断上:先加一/减一(必做步骤),再看前一个是否和当前相等,相等的话再向后移动
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    ArrayList<List<Integer>> ret = new ArrayList<>();
    Arrays.sort(nums);
    for(int i = 0; i < nums.length;i++){
      if(i>0 && nums[i] == nums[i-1]){
        continue;
      }
      for (int j = i+1 ; j < nums.length;j++){
        if(nums[i]+nums[j]> target/2){
          break;
        }
        if(j>i+1 && nums[j] == nums[j-1] ){
          continue;
        }
        ArrayList<List<Integer>> headAndEnd = new ArrayList<>();
        int i1 = nums[i];
        int i2 = nums[j];
        fourSumBackTrack(headAndEnd,nums,target-nums[i]-nums[j],j+1,nums.length-1,j);
        headAndEnd.forEach(list->{
          list.add(i1);
          list.add(i2);
        });
        ret.addAll(headAndEnd);
      }
    }


    return ret;
  }

  private static void fourSumBackTrack(ArrayList<List<Integer>> headAndEnd , int[] nums,int sum, int head,int end,int j) {
    //退出
    if(head>=end){
      return;
    }
    int i = nums[head]+ nums[end];
    if(i == sum){
      headAndEnd.add(new ArrayList<>(Arrays.asList(nums[head],nums[end])));
      head++;
      while(head>j+1 && head <=end && nums[head] == nums[head-1]){
        head++;
      }
      end--;
      //当end的右边和end不相同时,才算是下一个end
      while(end<nums.length-2 &&  head <=end && nums[end] == nums[end+1]){
        end--;
      }
      fourSumBackTrack(headAndEnd,nums,sum,head,end,j);
    }else if(i < sum ){
      //当head的左边和head不相同时,才算是下一个head
      head++;
      while(head>j+1 && head <=end && nums[head] == nums[head-1]){
        head++;
      }
      fourSumBackTrack(headAndEnd,nums,sum,head,end,j);
    }else if(i > sum){
      end--;
      //当end的右边和end不相同时,才算是下一个end
      while(end<nums.length-2 &&  head <=end && nums[end] == nums[end+1]){
        end--;
      }
      fourSumBackTrack(headAndEnd,nums,sum,head,end,j);
    }

  }

  public static void main(String[] args) {
//    System.out.println(fourSum(new int[]{2,2,2,2},8));
    //-2,-1,0,0,1,2
//    System.out.println(fourSum(new int[]{-5,5,4,-3,0,0,4,-2},4));
    //-4,0,0,1,1,5,5,5
    System.out.println(fourSum(new int[]{-9,4,0,-3,6,3,-3,-9,-7,1,0,-7,-8,7,1},-9));
//    System.out.println(fourSum2(new int[]{2,2,2,2},8));
    //-2,-1,0,0,1,2
//    System.out.println(fourSum(new int[]{-5,5,4,-3,0,0,4,-2},4));
    System.out.println(fourSum2(new int[]{-9,4,0,-3,6,3,-3,-9,-7,1,0,-7,-8,7,1},-9));
//    List l1 = new ArrayList<Integer>();
  }
}
