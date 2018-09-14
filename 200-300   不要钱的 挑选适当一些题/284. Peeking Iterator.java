// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
//用一个缓存好数据就可以了
    Iterator<Integer> it ;
    Integer peek;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
        if(it.hasNext())  peek = it.next();
        else
            peek = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peek==null)
            throw new java.util.NoSuchElementException();
        Integer re = peek;
        peek = it.hasNext() ? it.next() :null;
        return re;
	}

	@Override
	public boolean hasNext() {
	    return peek!=null;
	}
}