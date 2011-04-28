package hwinventory.ui.hardware;

import hwinventory.domain.TypeHardwareDevice;

public class HardwareDraft {
	private TypeHardwareDevice type;
	private String diskSize;
	private String memorySize;
	private int ianNumber;
	private String macAddress;
	private String serialNumber;
	private String ipAddress;
	
	public TypeHardwareDevice getType() {
		return type;
	}
	public void setType(TypeHardwareDevice type) {
		this.type = type;
	}
	public String getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}
	public String getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}
	public int getIanNumber() {
		return ianNumber;
	}
	public void setIanNumber(int ianNumber) {
		this.ianNumber = ianNumber;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}	
}
