package hwinventory;

import java.util.Calendar;
import java.util.GregorianCalendar;

import hwinventory.domain.*;

public class InventoryEntry {

	public static void main(String[] args) {
		
		InventoryAccess anInventoryAccess = new InventoryAccess();

		int aScgNumber = 9;
		int anIanNumber = 2523;
		String aNameCategory = "Mac laptop";
		String aNameItem = "magul";
		String anIpAddress = "130.92.65.219";
		String aMacAddress = "00:16:cb:96:e1:ad";
		String aNameType = "MacBook Pro 2.16Ghz 15";
		String aDiskSize = "2GB";
		String aMemorySize = "220GB";
		String aNameLocation = "S14/101";
		String aNameUser = "Magu";
		float aPrice = (float) 3993.12;
		Calendar anInventoryDate = new GregorianCalendar(2004,01,01);
		String aBudget = "EK 1999";
		String aSerialNumber = "W863112UVWZ";
		String aGuarantee = "MacBook 531040673291";
		Calendar aGuaranteeEnd = new GregorianCalendar(2008,02,03);
		String aNote = "1 x LAN, 2 x USB 1.1 + 512 MB (CHF 1126.60, EK 2000)";

		anInventoryAccess.InventoryAccess(aScgNumber, anIanNumber, aNameCategory,
				aNameItem, anIpAddress, aMacAddress, aNameType, aDiskSize,
				aMemorySize, aNameLocation, aNameUser, aPrice, anInventoryDate,
				aBudget, aSerialNumber, aGuarantee, aGuaranteeEnd, aNote);
	}
}
