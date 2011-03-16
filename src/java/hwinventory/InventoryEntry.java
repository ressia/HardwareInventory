package hwinventory;

import hwinventory.domain.*;

public class InventoryEntry {

	public static void main(String[] args) {
		
		InventoryAccess anInventoryAccess = new InventoryAccess();

		int aScgNumber = 1;
		int anIanItem = 265;
		String aNameCategory = "PC desktop";
		String aNameItem = "moore";
		String anIpItem = "130.92.65.139";
		String aMacItem = "00:50:DA:68:9A:1B";
		String aNameType = "Dell Dimension XPS T700r";
		String aDiskSize = "512MB";
		String aMemorySize = "80GB";
		String aNameLocation = "";
		String aNameUser = "NOONE";
		float aPrice = 3993;
		String anInventoryDate = "01/01/04";
		String aBudget = "EK 1999";
		String aSnItem = "";
		String aGuarantee = "";
		String aGuaranteeEnd = "3/2/08";
		String aHwNotes = "1 x LAN, 2 x USB 1.1 + 512 MB (CHF 1126.60, EK 2000)";

		anInventoryAccess.InventoryAccess();
	}
}
