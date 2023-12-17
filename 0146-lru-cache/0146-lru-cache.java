class LRUCache {
    Node head;
    Node tail;
    int size;
    int cap;
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            if(curr == head){
                return head.v;
            }
            else if(curr==tail){ // curr == tail after curr == head WA #3
                tail = tail.next;
                tail.prev = null; // imp
            }
            else{
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev; // imp
            }
            head.next = new Node(key, curr.v, null, head);
            head = head.next;
            map.put(key, head);
            return head.v;
        }
        return -1;  
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            get(key);
            head.v = value;
            return;
        }
        
        if(head == null){
            head = new Node(key, value, null, null);
            tail = head;
            map.put(key, head);
            size++;
            return;
        }

        head.next = new Node(key, value, null, head);
        head = head.next;
        map.put(key, head);
        size++;
        
        if(size > cap){
            map.remove(tail.k);
            tail = tail.next;
            tail.prev = null; // imp
            size--;
        }

    }
}

class Node{
    int k,v;
    Node next, prev;
    
    Node(int kk, int vv, Node nx, Node pr){
        k = kk; v = vv; next = nx; prev = pr;
    }
}


// // first AC
//
// class LRUCache {
//     Node head;
//     Node tail;
//     int size;
//     int cap;
//     Map<Integer, Node> map;
    
//     public LRUCache(int capacity) {
//         cap = capacity;
//         map = new HashMap<>();
//     }
    
//     public int get(int key) {
//         // System.out.println(map);
//         if(map.containsKey(key)){
//             Node curr = map.get(key);
//             if(curr == head){
//                 return head.v;
//             }
//             else if(curr==tail){
//                 tail = tail.next;
//                 tail.prev = null; // imp
//                 head.next = new Node(key, curr.v, null, head);
//                 head = head.next;
//                 map.put(key, head);
//                 return head.v;
//             }
//             else{
//                 curr.prev.next = curr.next;
//                 curr.next.prev = curr.prev; // imp
//                 head.next = new Node(key, curr.v, null, head);
//                 head = head.next;
//                 map.put(key, head);
//                 return head.v;
//             }
//         }
//         return -1;  
//     }
    
//     public void put(int key, int value) {
//         if(map.containsKey(key)){
//             get(key);
//             head.v = value;
//             return;
//         }
        
//         if(head == null){
//             head = new Node(key, value, null, null);
//             tail = head;
//             map.put(key, head);
//             size++;
//             return;
//         }

//         head.next = new Node(key, value, null, head);
//         head = head.next;
//         map.put(key, head);
//         size++;
        
//         if(size > cap){
//             map.remove(tail.k);
//             tail = tail.next;
//             tail.prev = null; // imp
//             size--;
//         }

//     }
// }

// class Node{
//     int k;
//     int v;
//     Node next;
//     Node prev;
//     Node(int kk, int vv, Node nx, Node pr){
//         k = kk;
//         v = vv;
//         next = nx;
//         prev = pr;
//     }
// }


// // correct code but TLE
//
// class LRUCache {
    
//     int time;
//     int cap;
//     Map<Integer, Integer> map;
//     Map<Integer, Integer> timeMap;
//     PriorityQueue<int[]> pq;
    
//     public LRUCache(int capacity) {
//         time = 0;
//         cap = capacity;
//         map = new HashMap<>();
//         timeMap = new HashMap<>();
//         pq = new PriorityQueue<>((a,b) -> {return a[1]-b[1];});
//     }
    
//     public int get(int key) {
//         pq.removeIf(e -> e[0]==key);
//         if(map.containsKey(key)){
//             pq.offer(new int[]{key, time});
//             timeMap.put(key, time);
//             time++;
//             return  map.get(key);
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         if(map.containsKey(key)){ //WA #1
//             map.put(key, value);
//             pq.removeIf(e -> e[0]==key); // WA #2
//             pq.offer(new int[]{key, time});
//             time++;
//             return;
//         }
//         if(map.size() >= cap){
//             int oldKey = pq.poll()[0];
//             map.remove(oldKey);
//         }
//         map.put(key, value);
//         pq.offer(new int[]{key, time});
//         timeMap.put(key, time);
//         time++;
//     }
// }



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */