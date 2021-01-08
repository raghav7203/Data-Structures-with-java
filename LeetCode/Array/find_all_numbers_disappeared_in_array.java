/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

*/


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        int i=0, temp=0;
        while(i<n){
            // if(nums[i]!=nums[nums[i]-1]){
            //     temp=nums[i];
            //     nums[i]=nums[nums[i]-1];
            //     nums[nums[i]-1]=temp;
            // }
            //nums[i] is changing so need to swap accordingly as above not working
            if(nums[i]!=nums[nums[i]-1]){
                temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
            else
                i++;
        }
        List<Integer> al=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1)
                al.add(j+1);
        }
        return al;
    }
}
