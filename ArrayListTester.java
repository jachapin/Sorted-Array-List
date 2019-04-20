/**
 * Sorted Array List Tester
 * @author Jeff Chapin
 */
package lists;

public class ArrayListTester {

	public static void main(String[] args) {

		SortedArrayList<String> letterList = new SortedArrayList<String>();		
		
		letterList.add("B");
		letterList.add("A");
		letterList.add("D");
		letterList.add("C");
		System.out.println("Contents of list: " + letterList);
		System.out.println("Size: " + letterList.size());
		System.out.println("Length: " + letterList.length());
		letterList.add("F");
		letterList.add("E");
		letterList.add("B");
		letterList.add("A");
		System.out.println("Contents of list: " + letterList);
		System.out.println("Size: " + letterList.size());
		System.out.println("Length: " + letterList.length());
		System.out.println("Contents of list before remove: " + letterList);
		System.out.println("Remove C: " + letterList.remove("C"));
		System.out.println("Contents of list after remove: " + letterList);
		System.out.println("Size: " + letterList.size());
		System.out.println("Length: " + letterList.length());	
		System.out.println("Contains C: " + letterList.contains("C"));
		System.out.println("Contains E: " + letterList.contains("E"));
		System.out.println("Get A: " + letterList.get("A"));
		System.out.println("Remove all A: " + letterList.removeAll("A"));
		System.out.println("Contents of list: " + letterList);
		System.out.println("Size: " + letterList.size());
		System.out.println("Length: " + letterList.length());
	}

}
