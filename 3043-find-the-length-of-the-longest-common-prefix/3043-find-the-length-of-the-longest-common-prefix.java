class Solution {
    Node root;
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new Node();
        insert(arr1, root);
        int ans = 0;
        
        
        for(int a: arr2){
            ans = Math.max(ans, matchPrefix(Integer.toString(a)));
        }
        
        return ans;
        
    }
    
    int matchPrefix(String str){
        Node cur = root;
        int i=0;
        for(; i<str.length(); ++i){
            int x = str.charAt(i)-'0';
            if(cur.arr[x]==null) break;
            else cur = cur.arr[x];
        }
        return i;
    }
    
    void insert(int[] nums, Node root){
        for(int num: nums){
            String str = Integer.toString(num);
            
            Node cur = root;
            for(int i=0; i<str.length(); ++i){
                int x = str.charAt(i)-'0';
                if(cur.arr[x]==null)
                    cur.arr[x] = new Node();
                cur = cur.arr[x];
            }
            cur.end = true;
        }
    }
}

class Node{
    Node[] arr;
    boolean end;
    public Node(){
        arr = new Node[10];
        end = false;
    }
}






// // 2 trie soolution - no need to use 2 tries
//
// class Solution {
//     Node roo;
//     Node root2;
//     public int longestCommonPrefix(int[] arr1, int[] arr2) {
//         roo= new Node();
//         root2 = new Node();
//         insert(arr1, roo);
//         insert(arr2, root2);
        
//         return dfs(roo, root2, 0);
//     }
    
    
//     int dfs(Node roo, Node root2, int cur){
//         if(root==null || root2==null) return 0;
//         int ans = 0;
        
//         for(int i=0; i<10; ++i){
//             if(roo.arr[i]!=null && root2.arr[i]!=null){
//                 ans = Math.max(ans, cur+1); // Important
//                 ans = Math.max(ans, dfs(roo.arr[i], root2.arr[i], cur+1));
//             }
//         }
        
//         return ans;
//     }
    
//     void insert(int[] nums, Node root){
//         for(int num: nums){
//             String str = Integer.toString(num);
            
//             Node cur = root;
//             for(int i=0; i<str.length(); ++i){
//                 int x = str.charAt(i)-'0';
//                 if(cur.arr[x]==null)
//                     cur.arr[x] = new Node();
//                 cur = cur.arr[x];
//             }
//             cur.end = true;
//         }
//     }
// }

// class Node{
//     Node[] arr;
//     boolean end;
//     public Node(){
//         arr = new Node[10];
//         end = false;
//     }
// }