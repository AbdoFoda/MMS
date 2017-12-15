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

	public static Integer allocate(Policy wantedPolicy, int sizeOfNeddedMomory) {
		Integer ret = wantedPolicy.selectIndex(sizeOfNeddedMomory);
		return ret;
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
		switch (caseNumber) {
		case 1:
			new InternalDefragmentation().eliminatingFragmentation();
			break;
		case 2:
			new ContiguousExternalDefragmentation().eliminatingFragmentation();
		case 3:
			new NonContiguousExternalDefragmentation().eliminatingFragmentation();
		default:
			System.out.println("Undefined Operation");
			break;
		}

	}

	public static void printStatus() {

	}

}
