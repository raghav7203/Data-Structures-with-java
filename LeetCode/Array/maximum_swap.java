/*
Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]
*/

class Solution {
    public int maximumSwap(int num) {
        int hold=num;
        ArrayList<Integer> al=new ArrayList<>();
        while(num>0){
            al.add(num%10);
            num=num/10;
        }
        Collections.reverse(al);
        int n=al.size();
        ArrayList<String> l=new ArrayList<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=al.get(i);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
                String x="";
                for(int k:a)
                    x+=String.valueOf(k);
                l.add(x);
                a[j]=a[i];
                a[i]=t;
            }
        }
        // System.out.println(l);
        if(n==1)
            return hold;
        int ans=0;
        for(String s:l){
            int temp=Integer.parseInt(s);
            if(temp>ans)
                ans=temp;
        }
        if(hold>ans)
            return hold;
        return ans;
    }
}
