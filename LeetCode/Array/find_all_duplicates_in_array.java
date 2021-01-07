/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]!=nums[nums[i]-1]){
                int t=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=t;
            }
            else
                i++;
        }
        List<Integer> al=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1)
                al.add(nums[j]);
        }
        return al;
    }
}
