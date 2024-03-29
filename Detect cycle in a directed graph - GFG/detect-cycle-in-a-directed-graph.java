//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int visited[],int path[],int node){
        visited[node]=1;
        path[node]=1;
        
        ArrayList<Integer> children =adj.get(node);
        for(int i=0;i<children.size();i++){
            int child=children.get(i);
            if(visited[child]==1 && path[child]==1){
                return true;
            }
            
            if(visited[child]==0){
                boolean res=dfs(adj,visited,path,child);
                if(res){
                    return true;
                }
            }
        }
        path[node]=0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int visited[]=new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]!=1){
                boolean res=dfs(adj,visited,new int[V],i);
                if(res){
                    return true;
                }
            }
            
        }
        return false;
    }
}