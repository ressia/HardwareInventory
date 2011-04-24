package hwinventory.system;

import hwinventory.dao.HardwareInventoryDAO;

public class HardwareInventorySystem {

	HardwareInventoryDAO hardwareInventoryDAO;
	
	public HardwareInventoryDAO getHardwareInventoryDAO() {
		return hardwareInventoryDAO;
	}

	public HardwareInventorySystem(HardwareInventoryDAO aHardwareInventoryDAO) {
		hardwareInventoryDAO = aHardwareInventoryDAO;
	}
	
	
}
