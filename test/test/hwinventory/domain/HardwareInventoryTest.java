package test.hwinventory.domain;

import java.util.HashSet;
import java.util.Set;

import hwinventory.domain.HardwareInventory;
import hwinventory.domain.InventoryItem;
import junit.framework.TestCase;

public class HardwareInventoryTest extends TestCase {
	
	public void testCreation() {
		HardwareInventory inventory = new HardwareInventory();
		assertTrue(inventory.getItems().isEmpty());
	}
	
	public void testSetItems() {
		HardwareInventory inventory = new HardwareInventory();
		assertTrue(inventory.getItems().isEmpty());
		Set aSet = new HashSet();
		aSet.add("1");
		inventory.setItems(aSet);
		assertFalse(inventory.getItems().isEmpty());
		assertTrue(inventory.getItems().size() == 1);
		assertTrue(inventory.getItems().contains("1"));
	}

	public void testAddItem() {
		HardwareInventory inventory = new HardwareInventory();
		InventoryItem anItem = new InventoryItem();
		inventory.addItem(anItem);
		assertFalse(inventory.getItems().isEmpty());
		assertTrue(inventory.getItems().size() == 1);
		assertTrue(inventory.getItems().contains(anItem));
	}
	
	public void testAddItems() {
		HardwareInventory inventory = new HardwareInventory();
		InventoryItem anItem = new InventoryItem();
		inventory.addItem(anItem);
		assertFalse(inventory.getItems().isEmpty());
		assertTrue(inventory.getItems().size() == 1);
		assertTrue(inventory.getItems().contains(anItem));
		InventoryItem anotherItem = new InventoryItem();
		anotherItem.setNameItem("2");
		inventory.addItem(anotherItem);
		assertTrue(inventory.getItems().size() == 2);
		assertTrue(inventory.getItems().contains(anItem));
		assertTrue(inventory.getItems().contains(anotherItem));
	}

}
