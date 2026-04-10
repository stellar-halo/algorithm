import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] map = new int[n];
        LinkedList<Integer>[] paths = new LinkedList[n];
        
        for(int i = 0 ; i < n ; i++){
            paths[i] = new LinkedList<Integer>();
        }
        
        Arrays.fill(map, Integer.MAX_VALUE);
        map[destination - 1] = 0;
        
        for(int[] road : roads){
            int a = road[0] - 1;
            int b = road[1] - 1;
            
            paths[a].add(b);
            paths[b].add(a);
        }
        
        Queue<Path> q  = new LinkedList<>();
        q.add(new Path(destination-1, 1));
        
        while(!q.isEmpty()){
            Path p = q.poll();
            for(int path: paths[p.start]){
                if(map[path] > p.depth) {
                    map[path] = p.depth;
                    q.add(new Path(path, p.depth+1));
                }
            }
        }
        for(int i = 0 ; i < sources.length ; i++){
            int d = sources[i] - 1;
            if(map[d] == Integer.MAX_VALUE) map[d] = -1;
            answer[i] = map[d];
        }
        
        return answer;
    }
    
    class Path{
        int start, depth;
        
        Path(int start, int depth){
            this.start = start;
            this.depth = depth;
        }
    }
}