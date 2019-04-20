package lists;

public class UnsortedArrayList<T> implements ListInterface<T> {

	protected int numElements;
	protected final int DEFCAP = 5;
	protected T[] list;

	public UnsortedArrayList() {
		list = (T[]) new Object[DEFCAP];
		numElements = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElements;
	}

	protected void enlarge() {

		// create a new array with the original capacity plus the current size of the array
		T[] newList = (T[]) new Object[DEFCAP+list.length];

		// copy all elements 
		for (int i=0; i < list.length; i++)
			newList[i] = list[i];

		// assign list to the new array
		list = newList;
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		if (isFull())
			enlarge();

		list[numElements] = element;
		numElements++;

	}
	
	private int find(T element) {
		
		for (int i=0; i < numElements; i++) {
			if (element.equals(list[i])) 
				return i;
		}
		
		return -1;
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		
		int foundIndex = find(element);
		if (foundIndex == -1)		
			return false;
		
		list[foundIndex] = list[numElements-1];
		list[numElements-1] = null;
		numElements--;
		return true;
		
	}
	

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return (find(element) != -1);
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		
		int foundIndex = find(element);
		if (foundIndex == -1)
			return null;
		
		return list[foundIndex];
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public T getNext() {
		// TODO Auto-generated method stub
		return null;
	}


	private boolean isFull() {
		return list.length == size();
	}

	public int length() {
		return list.length;
	}
	
	public String toString() {
		String retStr = "[";
		
		for (int i=0; i < numElements; i++) {
			retStr += list[i];
			retStr += " ";
		}
		retStr += "]";
		
		return retStr;
	}
}
