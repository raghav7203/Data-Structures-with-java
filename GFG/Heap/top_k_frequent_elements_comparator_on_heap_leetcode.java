/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
*/



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.replace(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        sortComparator comp=new sortComparator();
        PriorityQueue<node> minHeap=new PriorityQueue<>(comp);
        ArrayList<Integer> key=new ArrayList<>(map.keySet());
        for(int i:key){
            minHeap.add(new node(map.get(i), i));
            if(minHeap.size()>k)
                minHeap.poll();
        }
        int a[]=new int[k];
        for(int i=0;i<k;i++){
            a[i]=minHeap.poll().data;
        }
        return a;
    }
}
class sortComparator implements Comparator<node>{
    public int compare(node a, node b){
        return a.freq-b.freq;
    }
}
class node{
    int freq, data;
    public node(int freq, int data){
        this.freq=freq;
        this.data=data;
    }
}
