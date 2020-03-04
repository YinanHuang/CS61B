package Map61B;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] copy = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            copy[i] = nums[i];
        }
        mergeSort(nums, left, right);
        while(left != right){
            if(nums[left] + nums[right] == target){
                break;
            } else if(nums[left] + nums[right] < target){
                left++;
            } else{
                right--;
            }
        }
        System.out.println(nums[left]);
        System.out.println(nums[right]);
        for(int i = 0; i < nums.length;i++){
            if(copy[i] == nums[left]){
                left = i;

            }
        }
        /*
        for(int i = 0;i < nums.length;i++){
            if(copy[i] == nums[right] && i != left){
                right = i;
            }
        } */
        return new int[]{left, right};
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }

        while (p1 <= mid) tmp[k++] = a[p1++];
        while (p2 <= right) tmp[k++] = a[p2++];//同上

        //复制回原素组
        for (int i = left; i <= right; i++)
            a[i] = tmp[i];
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (start < end) {//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid + 1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }

    public static void main(String[] args){
        int[] a = new int[]{3,2,3};
        int[] ans = twoSum(a, 6);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

}