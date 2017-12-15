
public class Partition {
	private int startAddress;
	private int partitionSize;
	private int reservedSize;
	private boolean empty;

	public Partition() {
		startAddress = partitionSize = reservedSize = 0;
		empty = true;
	}

	public Partition(int start, int t_size, int reserved) {
		startAddress = start;
		partitionSize = t_size;
		reservedSize = reserved;
		empty=true;
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

	public boolean isEmpty() {
		return empty;
	}

	public void setPartitionStatus(boolean partitionStatus) {
		this.empty = partitionStatus;
	}

}
