import java.util.ArrayList;

public class MMS {
	public static ArrayList<Partition> memory;

	public MMS() {
		memory = new ArrayList<Partition>();
	}

	public static void init(int size) {
		memory = new ArrayList<Partition>();
		Partition wholeMemory = new Partition(0, size, 0);
		memory.add(wholeMemory);
	}

	public static boolean allocate(Policy wantedPolicy, int sizeOfNeddedMomory) {

		return true;
	}

	public static boolean deallocate(int startingAddress) {
		for (int i = 0; i < memory.size(); ++i) {
			if (memory.get(i).getStartAddress() == startingAddress) {
				memory.get(i).setReservedSize(0);
				memory.get(i).setPartitionStatus(true);
				return true;
			}
		}
		return false;
	}

	public static void defragment(int caseNumber) {

	}

	public static void printStatus() {

	}

}
