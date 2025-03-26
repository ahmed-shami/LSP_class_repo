package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class representing a set of integers with various operations.
 * The set is implemented using an ArrayList to store elements.
 */ 
public class IntegerSet  {
	// Store the set elements in an ArrayList.
	private List<Integer> set = new ArrayList<Integer>();

	// Default Constructor
	 /**
     * Default constructor that creates an empty IntegerSet.
     */
	public IntegerSet() {
		
	}

	 /**
     * Constructor that creates an IntegerSet from an existing ArrayList.
     * @param set The ArrayList containing initial set elements
     */
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}
	
	/**
	 * Removes all element from the set
	 */
    public void clear() {
    	set.clear();
    }
    
    /**
     * Returns the number of elements in the set.
     * @return The size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set with another object for equality.
     * Two sets are equal if they contain all of the same values in any order.
     * @param o The object to compare with
     * @return true if the sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntegerSet)) {
            return false;
        }

        IntegerSet otherSet = (IntegerSet) o;

        if (this.set.size() != otherSet.set.size()) {
            return false;
        }

        List<Integer> thisCopy = new ArrayList<>(this.set);
        List<Integer> otherCopy = new ArrayList<>(otherSet.set);
        Collections.sort(thisCopy);
        Collections.sort(otherCopy);

        return thisCopy.equals(otherCopy);
    }

    /**
     * Checks if the set contains a specific value.
     * @param value The integer value to check for
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Finds the largest element in the set.
     * @return The largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
    	 if (set.isEmpty()) {
             throw new RuntimeException("Cannot find largest - set is empty");
         }
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) > maximum) {
                maximum = set.get(i);
            }
        }
        return maximum;
    }

    /**
     * Finds the smallest element in the set.
     * @return The smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
    	 if (set.isEmpty()) {
             throw new RuntimeException("Cannot find smallest - set is empty");
         }
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) < minimum) {
                minimum = set.get(i);
            }
        }
        return minimum;
    }

    /**
     * Adds an item to the set if not already present.
     * @param item The Integer to add to the set
     */
    public void add(int item) {
        if (!set.contains(item)) {
        	 set.add(item);
        }
    }

    /**
     * Removes an element from the set if it exists
     * @param item The integer to remove from the set
     */ 
    public void remove(int item) {
        for (int i = 0; i < this.set.size(); i++) {
            if (this.set.get(i) == item) {
                this.set.remove(i);
                return;
            }
        }
    }

  /**
   * Performs union operation with another IntegerSet.
   * @param intSetb The other integer set to union with. 
   */
  public void union(IntegerSet intSetb) {
    	for (int element : intSetb.set) {
        if (!set.contains(element)) {
            set.add(element);
        }
    }
  }

  /**
   * Performs set intersection with another IntegerSet.
   * Modifies this set to contain only elements that are present in both Sets. 
   * @param intSetb the other IntegerSet to intersect with
   */
  public void intersect(IntegerSet intSetb) {
    	set.retainAll(intSetb.set);
  }

  /**
   * Performs set difference (this set minus the other set).
   * @param intSetb the other IntegerSet to compare with
   */
  public void diff(IntegerSet intSetb) {
    	set.removeAll(intSetb.set);
  }

  /**
   * Performs complement operation relative to the other set.
   * Replaces this set with values in intSetb that are not in this set.
   * @param intSetb The IntegerSet to use for the complement operation.
   */
  public void complement(IntegerSet intSetb) {
  	List<Integer> dummySet = new ArrayList<>();
  	for (int i = 0; i < intSetb.length(); i++) {
  		if (!this.set.contains(intSetb.set.get(i))) {
  			dummySet.add(intSetb.set.get(i));
  		}
  	}
  	this.set.clear();
  	this.set.addAll(dummySet);
  }

  /**
   * Checks if the set is empty.
   * @return true if the set contains no elements, false otherwise
   */
  public boolean isEmpty() {
  	return this.length() == 0;
  }

  /**
   * Returns a string representation of the set.
   * @return A string representation of the set
   */
  @Override
  public String toString() {
  	return set.toString();
  }
}