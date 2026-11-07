/**
 * Problem: 1882. Process Tasks Using Servers
 * Difficulty: Medium
 * Language: Java
 * Runtime: 29 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/process-tasks-using-servers/
 */

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int m=servers.length;
        int n=tasks.length;
        PriorityQueue<int[]>freeServers=new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        for(int i=0;i<m;i++){
            freeServers.offer(new int[]{i,servers[i]});
        }
        int[]res=new int[n];
        PriorityQueue<int[]>serversInUse=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Queue<Integer>queue=new LinkedList<>();
        int time=0;
        int taskIndex=0;
        while(taskIndex<n||!queue.isEmpty()){
            while(!serversInUse.isEmpty()&&serversInUse.peek()[1]<=time){
                int idx=serversInUse.poll()[0];
                freeServers.offer(new int[]{idx,servers[idx]});
            }
            while(taskIndex<n&&taskIndex<=time){
                queue.offer(taskIndex++);
            }
            while(!queue.isEmpty()&&!freeServers.isEmpty()){
                int[]curr=freeServers.poll();
                int idx=queue.poll();
                res[idx]=curr[0];
                serversInUse.offer(new int[]{curr[0],time+tasks[idx]});
            }
            if(!queue.isEmpty()&&freeServers.isEmpty()){
                time=serversInUse.peek()[1];
            }
            else time++;
        }
        return res;
    }
}
