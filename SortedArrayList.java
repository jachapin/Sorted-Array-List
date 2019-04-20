/**
 * Sorted Array List
 * @author Jeff Chapin
 */

package lists;

public class SortedArrayList<T extends Comparable<T>> extends UnsortedArrayList<T> {

	public SortedArrayList() {
		list = (T[]) new Comparable[DEFCAP];
		numElements = 0;
	}

	/** Adds an element to a sorted list */
	public void add(T element) {
		
		// If the list is full, enlarge the list
		if (numElements == list.length) {
			enlarge();
		}

		// Find the insertion index
		int index = 0;	
		while (index < list.length) {
			if (list[index] != null) { // Check that indices are not null before running compareTo.
				if (list[index].compareTo(element) < 0) { // if object in index is less than element go to next index
					index++;
				} else {
					break;
				}
			} else {
				break;
			}
		}

		// shift elements in array starting at end of list and traversing back to i
		for (int j = numElements; j > index; j--) {
			list[j] = list[j - 1];
		}

		list[index] = element; // add the element at index
		numElements++;
	}

	/** If list is full, enlarges the list by the size of the DEFCAP */
	protected void enlarge() {
		// create a new array with the original capacity plus the current size of the
		// array
		T[] newList = (T[]) new Comparable[DEFCAP + list.length];

		// copy all elements
		for (int i = 0; i < list.length; i++)
			newList[i] = list[i];

		// assign list to the new array
		list = newList;
	}

	/** Removes the element from the list. Removes only the first instance found. Returns true if found, false if not found */
	public boolean remove(T element) {
		for (int i = 0; i < numElements; i++) { // Loop through the list until it finds an element
			if (element.equals(list[i])) {
				for (int j = i; j <= numElements - 2; j++) { // If equal element is found, shift remaining list left one
																// index
					list[j] = list[j + 1];

				}
				numElements--; // Reduce number of elements by one an return true
				return true;
			}
		}
		return false; // If no element is found return false
	}

	/** Removes all instances of element from the list */
	public boolean removeAll(T element) {
		boolean found = true;
		boolean elementRemoved = false;
		while (found) { // while found is true, keep running remove(element)
			found = remove(element);
			if (found == true) { // Capture boolean if element was found and removed
				elementRemoved = true;
			}
		}
		if (elementRemoved == true) {
			return true;
		} else {
			return false;
		}
	}
}
