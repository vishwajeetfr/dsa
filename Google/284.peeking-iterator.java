/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

// @lc code=start
// Java Iterator interface reference: https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
// difficulty : Medium
// Related Topics : Design, Iterator
// Problem Link : https://leetcode.com/problems/peeking-iterator/

import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextElement = iterator.next();  // Pre-fetch the first element for peeking
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;  // Simply return the pre-fetched element
    }

    @Override
    public Integer next() {
        if (nextElement == null) {
            throw new NoSuchElementException();  // Ensure correct behavior if called at the end
        }
        Integer result = nextElement;  // Store the current peeked value
        nextElement = iterator.hasNext() ? iterator.next() : null;  // Fetch the next element
        return result;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;  // Check if there's a pre-fetched element available
    }
}

// @lc code=end

