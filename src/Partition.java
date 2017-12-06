
public class Partition {
	private int startAddress;
	private int partitionSize;
	private int reservedSize;
	private boolean partitionStatus;

	public Partition() {
		startAddress = partitionSize = reservedSize = 0;
		partitionStatus = false;
	}

	public int getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(int startAddress) {
		this.startAddress = startAddress;
	}

	public int getPartitionSize() {
		return partitionSize;
	}

	public void setPartitionSize(int partitionSize) {
		this.partitionSize = partitionSize;
	}

	public int getReservedSize() {
		return reservedSize;
	}

	public void setReservedSize(int reservedSize) {
		this.reservedSize = reservedSize;
	}

	public boolean isPartitionStatus() {
		return partitionStatus;
	}

	public void setPartitionStatus(boolean partitionStatus) {
		this.partitionStatus = partitionStatus;
	}

}
