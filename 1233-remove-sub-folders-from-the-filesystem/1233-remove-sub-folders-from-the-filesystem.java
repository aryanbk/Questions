// class Solution {
//     Node root;
//     public List<String> removeSubfolders(String[] folder) {
//         root = new Node("root");
//         for(String f: folder){
//             String[] s = f.split("/");
//             // insert(s);
//             solve(s);
//         }
        
//         for(String f: folder){
//             String[] s = f.split("/");
//             delete(s);
//         }
        
//         return dfs(root, "");
//     }
    
//     void solve(String[] str){
//         Node node = root;
//         for(String s: str){
//             if(!root.child.containsKey(s))
//                 root.child.put()
//         }
//     }
    
//     void insert(String[] str){
//         Node node = root;
//         for(String s: str){
//             if(!root.child.containsKey(s))
//                 root.child.put(s, new Node(s));
//             node = root.child.get(s);
//         }
//     }
    
//     void delete(String[] str){
//         Node node = root;
//         for(int i=0; i<str.length; ++i){
//             String s = str[i];
//             if(!root.child.containsKey(s)) break;
//             node = root.child.get(s);
//         }
//         node.child.clear();
//     }
    
//     List<String> dfs(Node root, String prefix){
//         if(root.child.size()==0) return new ArrayList<>();
//         var ans = new ArrayList<String>();
//         for(var c: root.child.entrySet()){
//             String x = prefix + "/" + c.getKey();
//             ans.add(x);
//             ans.addAll(dfs(c.getValue(), x));
//         }
//         return ans;
//     }
// }


// class Node {
//     String name;
//     Map<String, Node> child;
//     public Node(String name){
//         this.name = name;
//         child = new HashMap<>();
//     }
// }



class Solution {
    public class TrieNode{
        boolean isWord;
        Map<String,TrieNode> children;
        public TrieNode(){
            children = new HashMap<>();
            isWord = false;
        }
    }
    
    public class Trie{
        TrieNode root;
        List<String> folders;
        public Trie(){
            root = new TrieNode();
            folders = new ArrayList<>();
        }
        
        public void insert(String[] arr){
            int l = arr.length;
            TrieNode node = root;
            for(int i=1; i<l; i++){
                if (!node.children.containsKey(arr[i])){
                    node.children.put(arr[i], new TrieNode());
                }
                node = node.children.get(arr[i]);
            }
            node.isWord = true;
        }
        
        public void search(){
            dfs(root, "");
            return;
        }
        
        public void dfs(TrieNode node, String str){
            if (node.isWord){
                folders.add(str);
                return;
            }
            for(String key: node.children.keySet()){
                dfs(node.children.get(key), str+"/"+key);
            }
            return;
        }
    }
    
    public List<String> removeSubfolders(String[] folder) {
        Trie tree = new Trie();
        int l = folder.length;
        for(int i=0; i<l; i++){
            String[] str = folder[i].split("/");
            tree.insert(str);
        }
        tree.search();
        return tree.folders;
    }
}