import java.util.ArrayList;

public class MMS {
	public static ArrayList<Partition> memory;

	public MMS() {
		memory = new ArrayList<Partition>();
	}

	public MMS(int size) {
		memory = new ArrayList<Partition>();
		Partition wholeMemory = new Partition();
		wholeMemory.setPartitionSize(size);
		wholeMemory.setStartAddress(0);
	}

	public static Integer allocate(Policy wantedPolicy, int sizeOfNeddedMomory) {
		Integer ret = wantedPolicy.selectIndex(sizeOfNeddedMomory);
		return ret;
	}

	public static boolean deallocate(int startedAddress) {
		return true;
	}

	public static void defragment(int caseNumber) {
		switch (caseNumber) {
		case 1:
			
			break;

		}

	}

	public static void printStatus() {

	}

}
