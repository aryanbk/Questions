class DataStream {
    
    int val;
    int k;
    int times;
    
    public DataStream(int value, int k) {
        val = value;
        this.k = k;
        times = 0;
    }
    
    public boolean consec(int num) {
        if(num == val)
            return ++times >= k;
        times = 0;
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */