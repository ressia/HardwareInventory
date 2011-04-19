package hwinventory.domain;

public class HardwareDevice {
	
	private Long idHardwareDevice;
	private TypeHardwareDevice type;
	private String diskSize;
	private String memorySize;
	private int ianNumber;
	private String macAddress;
	private String serialNumber;
	private String ipAddress;

	public HardwareDevice () {
	}
	
	public HardwareDevice (TypeHardwareDevice aType, String aDiskSize, String aMemorySize, int anIanNumber
			, String aMacAddress, String aSerialNumber, String anIpAddress) {
		type = aType;
		diskSize = aDiskSize;
		memorySize = aMemorySize;
		ianNumber = anIanNumber;
		macAddress = aMacAddress;
		serialNumber = aSerialNumber;
		ipAddress = anIpAddress;
	}

	public Long getIdHardwareDevice() {
		return idHardwareDevice;
	}

	public void setIdHardwareDevice(Long idHardwareDevice) {
		this.idHardwareDevice = idHardwareDevice;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((diskSize == null) ? 0 : diskSize.hashCode());
		result = prime * result + ianNumber;
		result = prime * result
				+ ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result
				+ ((macAddress == null) ? 0 : macAddress.hashCode());
		result = prime * result
				+ ((memorySize == null) ? 0 : memorySize.hashCode());
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HardwareDevice other = (HardwareDevice) obj;
		if (diskSize == null) {
			if (other.diskSize != null)
				return false;
		} else if (!diskSize.equals(other.diskSize))
			return false;
		if (ianNumber != other.ianNumber)
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (macAddress == null) {
			if (other.macAddress != null)
				return false;
		} else if (!macAddress.equals(other.macAddress))
			return false;
		if (memorySize == null) {
			if (other.memorySize != null)
				return false;
		} else if (!memorySize.equals(other.memorySize))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
