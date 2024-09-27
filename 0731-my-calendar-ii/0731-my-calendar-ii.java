class MyCalendarTwo {
    
    List<int[]> bookings;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        List<int[]> doubleBooking = new ArrayList<>();
        
        for(int[] booking: bookings){
            if(Math.max(booking[0], start) < Math.min(booking[1], end))
                doubleBooking.add(new int[]{Math.max(booking[0], start), Math.min(booking[1], end)});
        }
        
        Collections.sort(doubleBooking, (a, b) -> a[0]-b[0]);
        for(int i=0; i<doubleBooking.size()-1; ++i){
            int[] cur = doubleBooking.get(i);
            int[] nx = doubleBooking.get(i+1);
            if(cur[1] > nx[0]) return false;
        }
        
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */