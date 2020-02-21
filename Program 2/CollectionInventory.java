import java.util.Iterator;
/** 
 * Implemented a collection class of Inventory using an array.
 * @author Taeju Park
 *
 */

//Invariant of the InventoryArrayBAg
	//	1. The number of elements in the Bag is the instance variable manyItems.
	//	2. The elements in the Bag are stored in data[0] through data[manyItems-1].
	//	3. The current item is found at data[curentIndex]; If there is no current item, currentIndex == manyItems
	//	4. The data in this class will always be in an Ascending Order.

public class CollectionInventory implements Iterable<Inventory> {
	
	// Instance variables
	private Inventory item[];
	private int manyItems;
	
	// constructor
	public CollectionInventory(int initialCapacity) {
		item = new Inventory[initialCapacity];
		manyItems = 0;
	}
	
	/**
	 * Add your item name, weight, and gold value.
	 * @param itemName		Item name
	 * @param weight		Item weight
	 * @param goldValue		Item gold value
	 */
	public void insert(String itemName, int weight, int goldValue) {
		try {
			Inventory newItem = new Inventory(itemName, weight, goldValue);
			int i = 0;

			while (i < size() && (item[i].compareTo(newItem) == -1)) { i++; }

			for (int j = size(); j > i; j--)
				item[j] = item[j - 1];

			item[i] = newItem;
			manyItems++;
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Counting the size of array(inventory)
	 * @return	size of array
	 */
	public int size() {
		return this.manyItems;
	}
	
	/**
	 * display the item list in inventory
	 */
	public String toString() {
		String str = "\n";
		str += "\tItem Name\tWeight\tGold Value\n";
		str += "\t----------------------------------\n";
		
		for (int i = 0; i < size(); i++)
			str += item[i].toString() + "\n";
		
		return str;
	}
	
	/**
	 * Checking if the item exists in the inventory or not
	 * @param target	the item name you want to find it from inventory
	 * @return			the item name, weight, and gold value.
	 */
	public Inventory find(String target) {
		int index = 0;
		
		for (int i = 0; i < size(); i++)
			if (item[i].getitemName().compareToIgnoreCase(target) == 0)
				index = i;
		
		return item[index];
	}
	
	/**
	 * Counting how many selected item exists in the inventory
	 * @param target	the item name you want to count it from inventory
	 * @return			total count
	 */
	public int countOccurrences(String target) {
		int count = 0;
		
		for (int i = 0; i < size(); i++)
			if (item[i].getitemName().compareToIgnoreCase(target) == 0)
				count++;
		
		return count;
	}
	
	/**
	 * whether the collection contains at least one Inventory that is equal to the input parameter.
	 * @param target	the item you want to check if it contains
	 * @return			true if the item equals same
	 * 					false if the item equals not same
	 */
	public boolean contains(Inventory target) {
		for (int i = 0; i < size(); i++) 
			if (item[i].equals(target))
				return true;
		return false;
	}
	
	/**
	 * Counts total gold in the inventory
	 * @return	totalGold
	 */
	public int total() {
		int totalGold = 0;
		for (int i = 0; i < size(); i++)
			totalGold += item[i].getGoldValue();
		
		return totalGold;
	}
	
	/**
	 * Counting the item numbers between gold values
	 * @param target1	first time gold value
	 * @param target2	second item gold value
	 * @return		total item numbers
	 */
	public int countRange(int target1, int target2) {
		int count = 0;
		
		if (target1 > target2)
			return 0;
		else
			for (int i = 0; i < size(); i++)
				if (item[i].getGoldValue() > target1 &&
					item[i].getGoldValue() < target2)
					count++;
		
		return count;
	}
	
	/**
	 * Delete the targeted Item in inventory
	 * @param target	item name want to be deleted
	 * @return	result of delete which true or false
	 */
	public boolean delete(Inventory target) {
		boolean found = false;
		int i = 0;
		
		while (i < manyItems && !found) {
			if (item[i].equals(target))
				found = true;
			else
				i++;
		}
		
		if(found) {
			for (int j = i; j < manyItems; j++)
				item[j] = item[j + 1];
			manyItems--;
		}
		return found;
	}
	
	@Override
	public Iterator<Inventory> iterator() {
		return new InventoryIterator();
	}
	
	// The Inventory Iterator
	public class InventoryIterator implements Iterator<Inventory> {
		private int location = size() - 1;
		
		@Override
		public boolean hasNext() {
			boolean result = false;
			if (location >= 0 )
				result = true;
			else
				result = false;
			return result;
		}
		
		@Override
		public Inventory next() {
			Inventory result = item[location];
			location--;
			return result;
		}
	}
	
}
