/**
 * Problem: 1882. Process Tasks Using Servers
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/process-tasks-using-servers/
 */

1class Solution {
2    public int[] assignTasks(int[] servers, int[] tasks) {
3        int m=servers.length;
4        int n=tasks.length;
5        PriorityQueue<int[]>freeServers=new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
6        for(int i=0;i<m;i++){
7            freeServers.offer(new int[]{i,servers[i]});
8        }
9        int[]res=new int[n];
10        PriorityQueue<int[]>serversInUse=new PriorityQueue<>((a,b)->a[1]-b[1]);
11        Queue<Integer>queue=new LinkedList<>();
12        int time=0;
13        while(time<n||!queue.isEmpty()){
14            while(!serversInUse.isEmpty()&&serversInUse.peek()[1]<=time){
15                int idx=serversInUse.poll()[0];
16                freeServers.offer(new int[]{idx,servers[idx]});
17            }
18            if(time<n){
19                queue.offer(time);
20            }
21            while(!queue.isEmpty()&&!freeServers.isEmpty()){
22                int[]curr=freeServers.poll();
23                int idx=queue.poll();
24                res[idx]=curr[0];
25                serversInUse.offer(new int[]{curr[0],time+tasks[idx]});
26            }
27            time++;
28        }
29        return res;
30    }
31}
