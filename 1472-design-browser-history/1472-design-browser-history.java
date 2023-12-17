class BrowserHistory {
    
    Node curr;
    
    public BrowserHistory(String homepage) {
        curr = new Node(homepage, null, null);
    }
    
    public void visit(String url) {
        curr.next = new Node(url, curr, null);
        curr=curr.next;
    }
    
    public String back(int steps) {
        for(int s=0; s<steps && curr.prev != null; ++s)
            curr = curr.prev;
        return curr.url;
    }
    
    public String forward(int steps) {
        for(int s=0; s<steps && curr.next != null; ++s)
            curr = curr.next;
        return curr.url;
    }
}

class Node{
    String url;
    Node prev;
    Node next;
    public Node(String u, Node p, Node n){
        url = u;
        prev = p;
        next = n;
    }
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */