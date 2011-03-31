package hwinventory;

import java.util.Calendar;
import java.util.GregorianCalendar;

import hwinventory.domain.*;

public class InventoryEntry {

	public static void main(String[] args) {
		
		InventoryAccess anInventoryAccess = new InventoryAccess();

		int aScgNumber = 121;
		int anIanNumber = 0;
		String aNameCategory = "Other hardware";
		String aNameItem = "";
		String anIpAddress = "";
		String aMacAddress = "";
		String aNameType = "iPod Shuffle";
		String aDiskSize = "512MB";
		String aMemorySize = "";
		String aNameLocation = "S14/102";
		String aNameUser = "Pipi";
		float aPrice = (float) 139.00;
		Calendar anInventoryDate = new GregorianCalendar(2007,2,9);
		String aBudget = "IK 2005";
		String aSerialNumber = "";
		String aGuarantee = "";
		Calendar aGuaranteeEnd = new GregorianCalendar(2008,2,3);
		String aNote = "";
		
		anInventoryAccess.insertInventoryItem(aScgNumber, anIanNumber, aNameCategory,
				aNameItem, anIpAddress, aMacAddress, aNameType, aDiskSize,
				aMemorySize, aNameLocation, aNameUser, aPrice, anInventoryDate,
				aBudget, aSerialNumber, aGuarantee, aGuaranteeEnd, aNote);
	}
}
