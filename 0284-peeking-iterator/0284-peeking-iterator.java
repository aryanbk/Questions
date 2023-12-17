// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> i;
    int peekVal;
    boolean hasNx;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        i = iterator;
        hasNx = i.hasNext();
        peekVal = i.next();
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peekVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        int ans = peekVal;
        hasNx = i.hasNext();
        if (i.hasNext())
            peekVal = i.next();
        return ans;
	}
	
	@Override
	public boolean hasNext() {
	    return hasNx;
	}
}