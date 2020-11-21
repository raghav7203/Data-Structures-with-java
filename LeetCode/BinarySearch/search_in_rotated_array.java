/*
You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guranteed to be rotated at some pivot.
-10^4 <= target <= 10^4
*/


class Solution {
    public int search(int[] nums, int target) {
        int min=getMin(nums, 0, nums.length-1, nums.length);
        int ls=get(nums, 0,min-1, target);
        int rs=get(nums, min, nums.length-1, target);
        // System.out.println(min+" "+ls+" "+rs);
        if(ls!=-1)
            return ls;
        else
            return rs;
    }
    public int get(int a[], int l, int r, int k){
        int ans=-1, mid=0;
        if(l<=r){
            mid=l+(r-l)/2;
            if(a[mid]==k)
                return mid;
            else if(a[mid]<k)
                return get(a, mid+1, r, k);
            else
                return get(a, l, mid-1, k);
        }
        return ans;
    }
    public int getMin(int a[], int l, int r, int n){
        int mid=0, ans=-1, prev=0, next=0;
        if(l<=r){
            if(a[l]<=a[r])
                return l;
            mid=l+(r-l)/2;
            next=(mid+1)%n;
            prev=(mid+n-1)%n;
            if(a[mid]<=a[prev] && a[mid]<=a[next])
                return mid;
            else if(a[mid]<=a[r])
                return getMin(a, l, mid-1, n);
            else
                return getMin(a, mid+1, r, n);
        }
        return ans;
    }
}
