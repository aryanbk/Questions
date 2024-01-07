class Solution {
    public int findTheWinner(int n, int k) {
        Node first = new Node (1, null);
        Node prev = first;
        int curNum = 2;
        while(curNum<=n){
            Node curx = new Node(curNum++, prev);
            prev.next = curx;
            prev = curx;
        }
        prev.next = first;
        first.prev = prev;
        
        int x = k;
        Node cur = first;
        while(!(cur.next==cur && cur.prev==cur)){
            if(--x==0){
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                x = k;
            }
            cur = cur.next;
        }
        
        return cur.val;
    }
}


class Node{
    int val;
    Node next;
    Node prev;
    public Node (int v, Node p){
        val = v;
        prev = p;
    }
}



// class Solution {
//     public int findTheWinner(int n, int k) {
//         boolean[] map = new boolean[n];
//         int cur = 0;
//         int x = k;
//         int baki = n;
        
//         while(baki!=0){
//             if(!map[cur%n]){
//                 --x;
//                 if(x==0){
//                     map[cur%n] = true;
//                     x = k;
//                     --baki;
//                 }
//             }
//             ++cur;
//             // System.out.println(Arrays.toString(map));
//         }
//         return (cur-1)%n + 1;
//     }
// }