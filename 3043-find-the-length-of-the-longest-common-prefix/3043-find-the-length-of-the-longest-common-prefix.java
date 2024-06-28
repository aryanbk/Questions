class Solution {
    Node root1;
    Node root2;
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root1 = new Node();
        root2 = new Node();
        add(arr1, root1);
        add(arr2, root2);
        
        return dfs(root1, root2, 0);
    }
    
    
    int dfs(Node root1, Node root2, int cur){
        if(root1==null || root2==null) return 0;
        int ans = 0;
        if((root1.end || root2.end) && (root1.child>0 || root2.child>0))
            ans = cur;
        
        for(int i=0; i<10; ++i){
            if(root1.arr[i]!=null && root2.arr[i]!=null){
                ans = Math.max(ans, cur+1); // Important
                ans = Math.max(ans, dfs(root1.arr[i], root2.arr[i], cur+1));
            }
        }
        
        return ans;
    }
    
    void add(int[] nums, Node root){
        for(int num: nums){
            String str = Integer.toString(num);
            
            Node cur = root;
            for(int i=0; i<str.length(); ++i){
                int x = str.charAt(i)-'0';
                if(cur.arr[x]==null)
                    cur.arr[x] = new Node();
                cur.child = cur.child+1;
                cur = cur.arr[x];
            }
            cur.end = true;
        }
    }
}

class Node{
    Node[] arr;
    boolean end;
    int child;
    public Node(){
        arr = new Node[10];
        end = false;
        child = 0;
    }
}