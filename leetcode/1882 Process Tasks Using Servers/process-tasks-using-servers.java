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
13        int taskIdx=0;
14        while(time<n||!queue.isEmpty()){
15            while(!serversInUse.isEmpty()&&serversInUse.peek()[1]<=time){
16                int idx=(int)serversInUse.poll()[0];
17                freeServers.offer(new int[]{idx,servers[idx]});
18            }
19            if(taskIdx<n&&taskIdx<=time){
20                queue.offer(taskIdx++);
21            }
22            while(!queue.isEmpty()&&!freeServers.isEmpty()){
23                int[]curr=freeServers.poll();
24                int idx=queue.poll();
25                res[idx]=curr[0];
26                serversInUse.offer(new int[]{curr[0],time+tasks[idx]});
27            }
28            if(!queue.isEmpty()&&freeServers.isEmpty()){
29                time=serversInUse.peek()[1];
30            }
31            else time++;
32        }
33        return res;
34    }
35}
