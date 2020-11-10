/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
*/


class Solution {
    public int[][] kClosest(int[][] points, int K) {
        sortComparator comp=new sortComparator();
        PriorityQueue<node> mheap=new PriorityQueue<>(comp);
        
        for(int i=0;i<points.length;i++){
        // x^2+y^2, no need of taking sqroot coz comparison is same for sorting
            int x=points[i][0];
            int y=points[i][1];
            int d=(x*x)+(y*y);
            // System.out.println(x+" "+y+" "+d);
            mheap.add(new node(d, x, y));
            
            if(mheap.size()>K)
                mheap.poll();
        }
        int a[][]=new int[K][2];
        for(int i=0;i<K;i++){
            node temp=mheap.poll();
            a[i][0]=temp.x;
            a[i][1]=temp.y;
        }
        return a;
    }
}
class node{
    int dist, x, y;
    public node(int dist, int x, int y){
        this.dist=dist;
        this.x=x;
        this.y=y;
    }
}
class sortComparator implements Comparator<node>{
    public int compare(node a, node b){
        return b.dist-a.dist;
    }
}
