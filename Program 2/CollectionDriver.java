import java.util.Iterator;
/** 
 * Collection Driver
 * @author Taeju Park
 *
 */
public class CollectionDriver {
	public static void main(String[] args) {
		// Created the collection with capacity 10
		CollectionInventory mageInv = new CollectionInventory(10);
		
		// The second inventory
		Inventory rogueInv = new Inventory("Belt", 3, 50);
		
		// Iterator
		Iterator<Inventory> itr = mageInv.iterator();
		
		// Added 8 items in the inventory (Item name, Weight, Gold Value)
		mageInv.insert("Shield", 10, 60);
		mageInv.insert("Book", 3, 20);
		mageInv.insert("Secptre", 10, 50);
		mageInv.insert("Diamond", 1, 500);
		mageInv.insert("Belt", 3, 50);
		mageInv.insert("Armor", 5, 150);
		mageInv.insert("Helmet", 3, 80);
		mageInv.insert("Glove", 3, 60);
		
		
		// 2. Size
		int sizeInventory = mageInv.size();
		System.out.println("\n#2 size\nThe size of Inventory is " + sizeInventory);
		
		// 3. toString
		System.out.println("\n#3 toString\n" + mageInv.toString());
		
		// 4. find
		Inventory findTarget = mageInv.find("Belt");
		System.out.println("\n#4 find in inventory\n" + findTarget);
		
		// 5. countOccurence
		String target = "Armor";
		int countO = mageInv.countOccurrences(target);
		System.out.print("\n#5 countOccurence\nThere is " + countO + " " + target + " in inventory\n");
		
		// 6. contains
		System.out.println("\n#6 contains");
		if (mageInv.contains(rogueInv))
			System.out.println("");
		else
			System.out.println("False");
			
		
		// 7. total
		int totalGold = mageInv.total();
		System.out.println("\n#7 total gold\nThe total gold in inventory: " + totalGold + "G\n");
		
		// 8. countRage
		int x = 40, y = 80;
		int range = mageInv.countRange(x, y);
		System.out.println("#8 countRage\nYou have " + range + " items of gold value between " + x + " and " + y);
		
		
		// 9. delete
		System.out.println("\n#9 delete");
		if (mageInv.delete(rogueInv))
			System.out.println("The targeted item has deleted.");
		else
			System.out.println("There is no item to delete");
		
//		10. iterator
		String str = "\n";
		str += "\tItem Name\tWeight\tGold Value\n";
		str += "\t----------------------------------";
		System.out.println("\n#10 display reverse alphabetical order\n" + str);
		
		for (Inventory i: mageInv)
			System.out.println(i);
		
	}
}
