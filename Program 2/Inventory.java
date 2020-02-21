/** 
 * The game inventory has multiple items with description of the weight and gold value
 * @author Taeju Park
 *
 */
public class Inventory implements Comparable<Inventory> {
	
	// instance variables
	private String itemName;
	private double weight;
	private int goldValue;
	
	// constructor
	public Inventory() {}
	
	
	/**
	 * Item list in the inventory
	 * @param itemName		The item name
	 * @param weight		The weight of the items
	 * @param goldValue		The item's value in gold
	 */
	public Inventory(String itemName, double weight, int goldValue) {
		this.itemName = itemName;
		this.weight = weight;
		this.goldValue = goldValue;
	}
	
	
	// Setter
	public void setweight(double weight) { this.weight = weight; }
	public void setitemName(String itemName) { this.itemName = itemName; }
	public void setGoldValue(int goldValue) {this.goldValue = goldValue; }
	
	// Getter
	public double getweight() { return this.weight; }
	public String getitemName() { return this.itemName; }
	public int getGoldValue() { return this.goldValue; }
	
	// the method that returns a String representation of Inventory
	public String toString() {
		return "\t" + itemName + "\t\t" + weight + "\t   " + goldValue + "G";
	}
	
	/**
	 * Compares between two items in the inventory.
	 * @param 	target
	 * @return	1 if two item's names are same
	 * 			0 if two item's names are not same 
	 */
	public boolean equals(Inventory target) {
		return (this.getitemName().compareToIgnoreCase(target.getitemName())) == 0;
	}


	
	@Override
	/**
	 * it returns 	-1 if object's search key is less than the parameter's search key
	 * 				 0 when two search keys are equal
	 * 				 1 object's search key is greater than the parameter's search key
	 */
	public int compareTo(Inventory index) {
		int result = -1;
		
		if (this.itemName.compareToIgnoreCase(index.getitemName()) >= 1)
			result = 1;
		else if (this.itemName.compareToIgnoreCase(index.getitemName()) == 0)
			result = 0;
		
		return result;
	}
}
