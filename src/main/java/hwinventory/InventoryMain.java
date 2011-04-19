package hwinventory;

import java.util.Calendar;
import java.util.GregorianCalendar;

import hwinventory.domain.*;

public class InventoryMain {

	public static void main(String[] args) {
		
		InventoryAccess anInventoryAccess = new InventoryAccess();

		int aScgNumber = 20;
		int anIanNumber = 3000;
		String aNameCategory = "Dell";
		//String aNewNameCategory = "Other hardware";
		String aNameItem = "dellmagu";
		String anIpAddress = "130.92.65.200";
		String aMacAddress = "00:16:cb:96:e1:ad";
		String aNameType = "Dell Notebook Pro 15";
		//String aNewNameType = "Dell Notebook Pro 15";
		String aDiskSize = "5GB";
		String aMemorySize = "3GB";
		String aNameLocation = "Office Luis";
		String aNameUser = "Luis";
		float aPrice = (float) 2000.20;
		Calendar anInventoryDate = new GregorianCalendar(2011,10,20);
		String aBudget = "BUD111";
		String aSerialNumber = "W111111111";
		String aGuarantee = "Dell 222222";
		Calendar aGuaranteeEnd = new GregorianCalendar(2011,5,2);
		String aNote = "Test 5";
		
		CategoryHardwareDevice aCategory = anInventoryAccess.addCategory(aNameCategory);
		
		TypeHardwareDevice aType = anInventoryAccess.addType(aNameType, aCategory);
		
		HardwareDevice aHardwareDevice = anInventoryAccess.addHardwareDevice(aType, aDiskSize, aMemorySize
				,anIanNumber, aMacAddress, aSerialNumber, anIpAddress);
		
		User anUser = anInventoryAccess.addUser(aNameUser);
		
		LocationItemInventory aLocation = anInventoryAccess.addAlocation(aNameLocation);
		
		anInventoryAccess.addInventoryItem(aHardwareDevice, aScgNumber, aNameItem, anUser,
				aLocation, anInventoryDate, aPrice, aBudget, aGuarantee,
				aGuaranteeEnd, aNote);
		
		/**
		anInventoryAccess.modifyCategory(aNameCategory, aNewNameCategory);
		
		anInventoryAccess.modidyInventoryItem(aScgNumber, anIanNumber, aNameCategory,
				aNameItem, anIpAddress, aMacAddress, aNameType, aDiskSize,
				aMemorySize, aNameLocation, aNameUser, aPrice, anInventoryDate,
				aBudget, aSerialNumber, aGuarantee, aGuaranteeEnd, aNote);
		
		anInventoryAccess.removeInventoryItem(aScgNumber);
		**/
	}
}
