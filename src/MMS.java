import java.util.ArrayList;

public class MMS {
	public ArrayList<Partition> memory;

	public MMS() {
		memory = new ArrayList<Partition>();
	}

	public MMS(int size) {
		memory = new ArrayList<Partition>();
		Partition wholeMemory = new Partition();
		wholeMemory.setPartitionSize(size);
		wholeMemory.setStartAddress(0);
	}

	public static boolean allocate(Policy wantedPolicy, int sizeOfNeddedMomory) {
		return true;
	}

	public static boolean deallocate(int startedAddress) {
		return true;
	}

	public static void defragment(int caseNumber) {

	}

	public static void printStatus() {

	}

}
