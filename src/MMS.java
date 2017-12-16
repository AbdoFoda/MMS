import java.util.ArrayList;

public class MMS {
	public static ArrayList<Partition> memory;
	public static Integer t_size;

	public MMS() {
		memory = new ArrayList<Partition>();
	}

	public static void init(int size) {
		memory = new ArrayList<Partition>();
		Partition wholeMemory = new Partition(0, t_size = size, 0);
		memory.add(wholeMemory);
	}

	public static Policy callTheRightPolicy(String policy) {
		if (policy.equals("BEST-FIT")) {
			return new bestFit();
		} else if (policy.equals("WORST-FIT")) {
			return new worstFit();
		} else {
			return new firstFit();
		}
	}

	public static Integer allocate(Policy wantedPolicy, int sizeOfNeededMomory) {
		Integer ret = wantedPolicy.selectIndex(sizeOfNeededMomory);
		if (ret != -1) {
			MMS.memory.get(ret).setPartitionStatus(false);
			MMS.memory.get(ret).setReservedSize(sizeOfNeededMomory);
			ret = MMS.memory.get(ret).getStartAddress();
		}
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
			break;
		case 3:
			new NonContiguousExternalDefragmentation().eliminatingFragmentation();
			break;
		default:
			System.out.println("Undefined Operation");
			break;
		}

	}

	public static void printStatus() {

	}

}
